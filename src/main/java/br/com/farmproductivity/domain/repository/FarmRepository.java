package br.com.farmproductivity.domain.repository;

import br.com.farmproductivity.domain.FarmDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends MongoRepository<FarmDocument, String> {

}