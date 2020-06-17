package org.put_the_machine.ies.repository.impl;

import org.put_the_machine.ies.model.DocumentMetaInfo;
import org.put_the_machine.ies.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Repository
public class DocumentRepositoryImpl implements DocumentRepository {
    @Value("${documents.path}")
    private File dir;

    @Override
    public String saveAndReturnPath(MultipartFile file) throws Exception {
        createDirIfNecessary();

        File resultFile = saveFileToDir(file, dir);

        return resultFile.getName();
    }

    private void createDirIfNecessary() {
        if (!dir.exists())
            //noinspection ResultOfMethodCallIgnored
            dir.mkdirs();
    }

    private File saveFileToDir(MultipartFile file, File dir) throws Exception {
        File createdFile = File.createTempFile("file", ".file", dir);
        file.transferTo(createdFile.getAbsoluteFile());
        return createdFile;
    }

    @Override
    public MultipartFile getByDocumentMetaInfo(DocumentMetaInfo documentMetaInfo) throws IOException {
        if (!documentMetaInfo.getIsFile())
            throw new IllegalArgumentException("Document meta info has to refers to file, not directory.");

        byte[] fileBytes = Files.readAllBytes(Paths.get(documentMetaInfo.getRealPath()));

        return createFileFromMetaInfoAndBytes(documentMetaInfo, fileBytes);
    }

    private MultipartFile createFileFromMetaInfoAndBytes(DocumentMetaInfo documentMetaInfo, byte[] fileBytes) {
        return new MultipartFile() {
            @Override
            public String getName() {
                return documentMetaInfo.getName();
            }

            @Override
            public String getOriginalFilename() {
                return documentMetaInfo.getName();
            }

            @Override
            public String getContentType() {
                return documentMetaInfo.getMimeType().getType();
            }

            @Override
            public boolean isEmpty() {
                return fileBytes.length == 0;
            }

            @Override
            public long getSize() {
                return fileBytes.length;
            }

            @Override
            public byte[] getBytes() {
                return fileBytes;
            }

            @Override
            public InputStream getInputStream() {
                return new ByteArrayInputStream(fileBytes);
            }

            @Override
            public void transferTo(File file) {

            }
        };
    }

    @Override
    public void deleteByPath(String path) throws IOException {
        Files.delete(Paths.get(path));
    }

    @Override
    public Path getDocumentPath(DocumentMetaInfo documentMetaInfo) {
        return Paths.get(dir.getAbsolutePath(), documentMetaInfo.getRealPath());
    }
}
