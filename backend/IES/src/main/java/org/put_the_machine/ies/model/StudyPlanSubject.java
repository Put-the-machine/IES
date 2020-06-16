package org.put_the_machine.ies.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString(exclude = {"courseProfile"})
@EqualsAndHashCode(exclude = {"courseProfile"})
@JsonIdentityInfo(
        generator = JSOGGenerator.class,
        property = "id")

public class StudyPlanSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int semester;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Subject subject;

    private boolean isTest;
    private boolean isExam;
    private boolean isCourseWork;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private CourseProfile courseProfile;

}
