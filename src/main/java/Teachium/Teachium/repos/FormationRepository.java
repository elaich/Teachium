package Teachium.Teachium.repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import Teachium.Teachium.domain.Formation;

public interface FormationRepository extends MongoRepository<Formation, String> {

	List<Formation> findByConfirme(boolean confirme);
}
