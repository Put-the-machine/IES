package org.put_the_machine.ies.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class SubjectGroup {

    public enum SubjectGroupType {
        LECTURE, PRACTICE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Subject subject;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Teacher teacher;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subjectGroup", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<DocumentMetaInfo> documentMetaInfos;

    private int hours;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "SUBJECT_GROUP_STUDENT",
            joinColumns = @JoinColumn(name = "subject_group_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students;

    @Enumerated
    private SubjectGroupType type;

    private String name;
}
