package Teachium.Teachium.domain;

public interface UtilisateurService {

  boolean ajouterUtilisateur(Utilisateur utilisateur);
  Utilisateur choisirFormation(Utilisateur utilisateur, String id);
Utilisateur getUtilisateur(String string);

}

