package org.put_the_machine.ies.service.impl;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.*;
import org.put_the_machine.ies.repository.*;
import org.put_the_machine.ies.service.DocumentService;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepo;
    private final DocumentMetaInfoRepository documentMetaInfoRepo;

    @Override
    public DocumentMetaInfo save(MultipartFile document, SubjectGroup subjectGroup, String path) throws IOException {
        String realPath = documentRepo.saveAndReturnPath(document);

        DocumentMetaInfo metaInfo = new DocumentMetaInfo();
        metaInfo.setCreationTime(LocalDateTime.now());
        metaInfo.setIsFile(true);
        metaInfo.setMimeType(MimeType.valueOf(Objects.requireNonNull(document.getContentType())));
        metaInfo.setName(document.getName());
        metaInfo.setSubjectGroup(subjectGroup);
        metaInfo.setVirtualPath(path);
        metaInfo.setRealPath(realPath);

        metaInfo = documentMetaInfoRepo.save(metaInfo);

        return metaInfo;
    }

    @Override
    public DocumentMetaInfo getById(Long documentMetaInfoId) {
        return documentMetaInfoRepo.findById(documentMetaInfoId)
                .orElseThrow(() -> new NoSuchElementException("DocumentMetaInfo not found by id: " + documentMetaInfoId));
    }

    @Override
    public void deleteById(Long documentMetaInfoId) throws IOException {
        DocumentMetaInfo metaInfo = getById(documentMetaInfoId);

        documentRepo.deleteByPath(metaInfo.getRealPath());

        documentMetaInfoRepo.deleteById(documentMetaInfoId);
    }

    @Override
    public List<DocumentMetaInfo> getAllBySubjectGroupId(Long subjectGroupId) {
        return documentMetaInfoRepo.findAllBySubjectGroupId(subjectGroupId);
    }

    @Override
    public MultipartFile getFileFromDocumentMetaInfo(DocumentMetaInfo documentMetaInfo) throws IOException {
        return documentRepo.getByDocumentMetaInfo(documentMetaInfo);
    }
}
