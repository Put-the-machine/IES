package org.put_the_machine.ies.service;

import org.put_the_machine.ies.model.Document;
import org.put_the_machine.ies.model.DocumentMetaInfo;

import java.util.List;

public interface DocumentService {
    Document save(Document document);

    Document get(String path);

    void delete(String path);

    List<DocumentMetaInfo> getDirectoryContentByPath(String path);

    boolean isDocumentMimeTypeAvailable(DocumentMetaInfo documentMetaInfo);

    List<String> getAvailableMimeTypes();
}