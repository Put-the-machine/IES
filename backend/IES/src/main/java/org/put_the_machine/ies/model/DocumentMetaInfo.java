package org.put_the_machine.ies.model;

import lombok.*;
import org.put_the_machine.ies.model.user.Teacher;

import javax.activation.MimeType;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(exclude = {"creator", "subjectGroup"})
public class DocumentMetaInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private MimeType mimeType;
    private String name;
    private String path;
    private LocalDateTime creationTime;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Teacher creator;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private SubjectGroup subjectGroup;
    private Boolean isFile;
}
