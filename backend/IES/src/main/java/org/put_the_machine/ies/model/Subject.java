package org.put_the_machine.ies.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
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
        generator = JSOGGenerator.class,
        property = "id")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subject", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<StudyPlanSubject> studyPlanSubjects;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subject", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<SubjectGroup> subjectGroups;

}
