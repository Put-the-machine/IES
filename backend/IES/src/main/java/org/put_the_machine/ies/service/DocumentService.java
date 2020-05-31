package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.DocumentMetaInfo;
import org.put_the_machine.ies.model.SubjectGroup;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DocumentService {
    DocumentMetaInfo save(MultipartFile document, SubjectGroup subjectGroup, String path) throws IOException;

    DocumentMetaInfo getById(Long departmentId);

    void deleteById(Long documentMetaInfoId) throws IOException;

    List<DocumentMetaInfo> getAllBySubjectGroupId(Long groupSubjectId);

    MultipartFile getFileFromDocumentMetaInfo(DocumentMetaInfo documentMetaInfo) throws IOException;
}