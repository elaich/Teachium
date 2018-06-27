package Teachium.Teachium.domain;

import java.util.List;

import org.springframework.stereotype.Service;

import Teachium.Teachium.database.TeachiumDatabase;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	private TeachiumDatabase databaseMock;

	public UtilisateurServiceImpl(TeachiumDatabase databaseMock) {
		// TODO Auto-generated constructor stub
		this.databaseMock = databaseMock;
	}

	public boolean ajouterUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		this.databaseMock.insererUtilisateur(utilisateur);
		return true;
	}

	public Utilisateur choisirFormation(Utilisateur utilisateur, String id) {
		List<String> formations = utilisateur.getFormations();
		formations.add(id);
		utilisateur.setFormations(formations);
		databaseMock.updateUtilisateur(utilisateur);
		return utilisateur;
	}

	@Override
	public Utilisateur getUtilisateur(String id) {
		// TODO Auto-generated method stub
		return this.databaseMock.getUtilisateur(id);
	}

}
