package org.put_the_machine.ies.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter  // todo: add JPA annotation
public class Document {
    private MultipartFile file;
    private DocumentMetaInfo metaInfo;
}