package br.com.farmproductivity.domain.repository;

import br.com.farmproductivity.domain.ProductionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductionRepository extends MongoRepository<ProductionDocument, String> {

    Optional<ProductionDocument> findByFarmIdAndFieldIdAndId(String farmId, String fieldId, String id);

}
