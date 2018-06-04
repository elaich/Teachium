package Teachium.Teachium.domain;

import Teachium.Teachium.database.TeachiumDatabase;

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

}

