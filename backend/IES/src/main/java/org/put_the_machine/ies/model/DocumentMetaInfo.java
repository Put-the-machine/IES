package org.put_the_machine.ies.model;

import lombok.Data;

import javax.activation.MimeType;
import java.time.LocalDateTime;

@Data   // todo: add JPA annotation
public class DocumentMetaInfo {
    private MimeType mimeType;
    private String name;
    private String path;
    private LocalDateTime creationTime;
    private User creator;
    private Course hostCourse;
    private Boolean isFile;
}