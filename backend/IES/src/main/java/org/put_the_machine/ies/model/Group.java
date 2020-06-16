package org.put_the_machine.ies.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.put_the_machine.ies.model.user.Manager;
import org.put_the_machine.ies.model.user.Student;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "GRP")
@Data
@EqualsAndHashCode(exclude = {"students"})
@ToString(exclude = {"students"})
@JsonIdentityInfo(
        generator = JSOGGenerator.class,
        property = "id")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long semester;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "GROUP_STUDENT",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private CourseProfile courseProfile;

}
