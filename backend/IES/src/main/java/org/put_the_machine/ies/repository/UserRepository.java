package org.put_the_machine.ies.repository;

import org.put_the_machine.ies.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {
}