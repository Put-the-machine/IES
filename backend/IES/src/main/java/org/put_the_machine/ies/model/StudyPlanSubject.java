package org.put_the_machine.ies.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
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
