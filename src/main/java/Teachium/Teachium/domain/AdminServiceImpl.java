package Teachium.Teachium.domain;

import Teachium.Teachium.database.TeachiumDatabase;

import org.springframework.stereotype.Service;

public class AdminServiceImpl implements AdminService {
  private TeachiumDatabase teachiumDatabase;

  public AdminServiceImpl(TeachiumDatabase teachiumDatabase) {
    // TODO Auto-generated constructor stub
    this.teachiumDatabase = teachiumDatabase;
  }

  public boolean ajouterUtilisateur(String id) {
    try {
      this.teachiumDatabase.accepterUtilisateur(id);
      return true;
    } catch(Exception e) {// TODO Auto-generated catch block
      //e.printStackTrace();

      return false;
    }
  }

  public boolean supprimerUtilisateur(
    String id
  ) {// TODO Auto-generated method stub

    try {
      this.teachiumDatabase.supprimerUtilisateur(id);
      return true;
    } catch(Exception e) {//e.printStackTrace();
    }
    return false;
  }

  public boolean ajouterFormation(String id) {
    try {
      this.teachiumDatabase.accepterFormation(id);
      return true;
    } catch(Exception e) {//e.printStackTrace();
    } // TODO Auto-generated method stub

    return false;
  }

  public boolean supprimerFormation(String id) {
    try {
      this.teachiumDatabase.supprimerFormation(id);
      return true;
    } catch(Exception e) {//e.printStackTrace();
    } // TODO Auto-generated method stub

    return false;
  }

  public Utilisateur[] getDemandesDinscriptions(

  ) {// TODO Auto-generated method stub

    return null;
  }

  public Utilisateur[] getDemandesDinscriptionsAppreneurs(

  ) {// TODO Auto-generated method stub

    return this.teachiumDatabase.getDemandesDinscriptionsAppreneurs();
  }

  public Utilisateur[] getDemandesDinscriptionsFormatteurs(

  ) {// TODO Auto-generated method stub

    return this.teachiumDatabase.getDemandesDinscriptionsFormatteurs();
  }

  public Message[] getMessages() {
    return this.teachiumDatabase.getAdminMessages();
  }

}

