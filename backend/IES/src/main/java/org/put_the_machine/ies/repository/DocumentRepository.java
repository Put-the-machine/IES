package org.put_the_machine.ies.repository;

import org.put_the_machine.ies.model.Document;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Long>, JpaSpecificationExecutor<Document> {
}