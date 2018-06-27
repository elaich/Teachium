package Teachium.Teachium.repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import Teachium.Teachium.domain.Utilisateur;


public interface UtilisateurRepository extends MongoRepository<Utilisateur, String> {
	List<Utilisateur> findByType(String type);
	Utilisateur findByUsername(String username);
	List<Utilisateur> findByAccepted(boolean b);
}
