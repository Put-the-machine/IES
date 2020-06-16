package org.put_the_machine.ies.repository;

import org.put_the_machine.ies.model.Institute;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstituteRepository extends CrudRepository<Institute, Long>, JpaSpecificationExecutor<Institute> {

    @Query("SELECT DISTINCT i FROM Institute AS i " +
            "LEFT JOIN FETCH i.departments AS d " +
            "LEFT JOIN FETCH d.courses AS c " +
            "LEFT JOIN FETCH c.courseProfiles")
    List<Institute> findAllWithFullInfoAboutDepartments();
}