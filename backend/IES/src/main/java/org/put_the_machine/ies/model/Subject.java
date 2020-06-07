package org.put_the_machine.ies.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.put_the_machine.ies.model.user.Teacher;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"studyPlanSubjects", "subjectGroups"})
@ToString(exclude = {"studyPlanSubjects", "subjectGroups"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subject", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<StudyPlanSubject> studyPlanSubjects;

    private Integer semester;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subject", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<SubjectGroup> subjectGroups;

}
