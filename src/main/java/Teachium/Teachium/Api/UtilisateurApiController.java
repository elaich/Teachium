package Teachium.Teachium.Api;

import Teachium.Teachium.domain.Utilisateur;
import Teachium.Teachium.domain.UtilisateurService;

public class UtilisateurApiController implements UtilisateurApi {
  private UtilisateurService utilisateurService;

  public UtilisateurApiController(UtilisateurService utilisateurService) {
    // TODO Auto-generated constructor stub
    this.utilisateurService = utilisateurService;
  }

  public Utilisateur insererUtilisateur(Utilisateur utilisateur) {
    // TODO Auto-generated method stub
    this.utilisateurService.ajouterUtilisateur(utilisateur);
    return utilisateur;
  }

}

