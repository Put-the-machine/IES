package org.put_the_machine.ies.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;
import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = {"studyPlanSubjects", "course", "groups"})
@ToString(exclude = {"studyPlanSubjects", "course", "groups"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class CourseProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private boolean isDefault;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courseProfile", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<StudyPlanSubject> studyPlanSubjects;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courseProfile", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Group> groups;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Course course;
}
