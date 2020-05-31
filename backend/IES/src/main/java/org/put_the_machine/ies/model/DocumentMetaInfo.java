package org.put_the_machine.ies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.put_the_machine.ies.model.user.Teacher;

import org.springframework.util.MimeType;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(exclude = {"subjectGroup"})
public class DocumentMetaInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private MimeType mimeType;
    private String name;
    private String virtualPath;
    @JsonIgnore
    private String realPath;

    private LocalDateTime creationTime;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private SubjectGroup subjectGroup;
    private Boolean isFile;
}
