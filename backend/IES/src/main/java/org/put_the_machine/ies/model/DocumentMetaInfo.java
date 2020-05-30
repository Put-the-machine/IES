package org.put_the_machine.ies.model;

import lombok.Getter;
import lombok.Setter;
import org.put_the_machine.ies.model.user.User;

import javax.activation.MimeType;
import java.time.LocalDateTime;

@Getter
@Setter   // todo: add JPA annotation
public class DocumentMetaInfo {
    private MimeType mimeType;
    private String name;
    private String path;
    private LocalDateTime creationTime;
    private User creator;
    private Course hostCourse;
    private Boolean isFile;
}