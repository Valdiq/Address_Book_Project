package org.vladstasyshyn.logging.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.vladstasyshyn.logging.document.ApiCallDocument;

@Repository
public interface ApiCallRepository extends MongoRepository<ApiCallDocument, String> {

}
