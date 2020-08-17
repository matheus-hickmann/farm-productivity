package br.com.farmproductivity.domain.repository;

import br.com.farmproductivity.domain.FieldDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepository extends MongoRepository<FieldDocument, String> {

    List<FieldDocument> findByFarmId(String farmId);
}
