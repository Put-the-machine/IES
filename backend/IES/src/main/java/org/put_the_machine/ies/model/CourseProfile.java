package org.put_the_machine.ies.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;
import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = {"studyPlanSubjects", "course"})
@ToString(exclude = {"studyPlanSubjects", "course"})
public class CourseProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private boolean isDefault;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courseProfile", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<StudyPlanSubject> studyPlanSubjects;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Course course;
}
