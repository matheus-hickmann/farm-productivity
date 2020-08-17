package br.com.farmproductivity.domain.repository;

import br.com.farmproductivity.domain.FarmDocument;
import br.com.farmproductivity.domain.FieldDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FarmRepository extends MongoRepository<FarmDocument, String> {

    Optional<FarmDocument> findByName(String name);

    @Query("{ 'id' : {id}, { fields : 1 }")
    List<FieldDocument> findFieldsByFarmId(String farmId);
    
}
