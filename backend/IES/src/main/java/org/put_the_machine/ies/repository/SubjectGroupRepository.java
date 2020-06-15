package org.put_the_machine.ies.repository;

import org.put_the_machine.ies.model.SubjectGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectGroupRepository extends CrudRepository<SubjectGroup, Long> {
    @Query("SELECT sg FROM SubjectGroup AS sg " +
            "INNER JOIN sg.students AS st " +
            "WHERE sg.subject.id = :subjectId AND st.id = :studentId")
    List<SubjectGroup> findAllBySubjectIdAndStudentId(Long subjectId, Long studentId);
}
