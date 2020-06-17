package org.put_the_machine.ies.controller;

import lombok.RequiredArgsConstructor;
import org.put_the_machine.ies.model.DocumentMetaInfo;
import org.put_the_machine.ies.model.SubjectGroup;
import org.put_the_machine.ies.service.DocumentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService documentService;

    @PostMapping("subject_groups/{subjectGroupId}/documents")
    public DocumentMetaInfo save(
            @ModelAttribute("document") MultipartFile document,
            @PathVariable("subjectGroupId") SubjectGroup subjectGroup,
            @ModelAttribute("path") String path) throws Exception {
        return documentService.save(document, subjectGroup, path);
    }

    @DeleteMapping("documents/{documentId}")
    public void deleteById(@PathVariable Long documentId) throws IOException {
        documentService.deleteById(documentId);
    }

    @GetMapping("documents/{documentMetaInfoId}")
    public void getDocumentByMetaInfo(HttpServletResponse response,
                                      @PathVariable("documentMetaInfoId") DocumentMetaInfo documentMetaInfo) throws IOException {
        response.setContentType(documentMetaInfo.getMimeType().getType());
        response.setHeader("Content-Disposition", "attachment; filename="+documentMetaInfo.getName());
        Files.copy(documentService.getDocumentPath(documentMetaInfo), response.getOutputStream());
    }

    @GetMapping("subject_groups/{subjectGroupId}/documents")
    public List<DocumentMetaInfo> getAllBySubjectGroupId(@PathVariable Long subjectGroupId) {
        return documentService.getAllBySubjectGroupId(subjectGroupId);
    }
}
