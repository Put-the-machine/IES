package org.put_the_machine.ies.repository;


import org.put_the_machine.ies.model.DocumentMetaInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public interface DocumentRepository {
    String saveAndReturnPath(MultipartFile file) throws Exception;

    MultipartFile getByDocumentMetaInfo(DocumentMetaInfo documentMetaInfo) throws IOException;

    void deleteByPath(String path) throws IOException;

    Path getDocumentPath(DocumentMetaInfo documentMetaInfo);
}