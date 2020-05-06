package org.put_the_machine.ies.model;

import lombok.*;

import javax.activation.MimeType;
import java.util.Date;

@Data
public class DocumentMetaInfo {
    private MimeType mimeType;
    private String name;
    private String path;
    private Date creationTime;
    private Long creatorId;
    private Course hostCourse;
    private Boolean isFile;
}