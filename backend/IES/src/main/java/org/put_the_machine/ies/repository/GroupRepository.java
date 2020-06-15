package org.put_the_machine.ies.repository;

import org.put_the_machine.ies.model.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
    @Query("SELECT g FROM Group AS g " +
            "INNER JOIN g.students AS st " +
            "WHERE st.id = :studentId")
    List<Group> findAllByStudentId(Long studentId);
}
