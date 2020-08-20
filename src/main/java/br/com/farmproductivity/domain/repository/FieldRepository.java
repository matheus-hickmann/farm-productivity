package br.com.farmproductivity.domain.repository;

import br.com.farmproductivity.domain.FieldDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FieldRepository extends MongoRepository<FieldDocument, String> {

    List<FieldDocument> findByFarmId(String farmId);
    Optional<FieldDocument> findByFarmIdAndId(String farmId, String id);
    Optional<FieldDocument> findByFarmIdAndName(String farmId, String name);
}
