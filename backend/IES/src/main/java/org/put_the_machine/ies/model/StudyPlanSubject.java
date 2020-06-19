package org.put_the_machine.ies.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@ToString(exclude = {"courseProfile"})
@EqualsAndHashCode(exclude = {"courseProfile"})
@JsonIdentityInfo(
        generator = JSOGGenerator.class,
        property = "id")

public class StudyPlanSubject {
    public enum ReportType {
        Test,
        Exam
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int semester;
    private String description;
    private String content;
    private String purpose;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Subject subject;

    private ReportType reportType;

    @Getter(AccessLevel.NONE)
    private boolean courseWork;

    public boolean hasCourseWork() {
        return courseWork;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private CourseProfile courseProfile;

}
