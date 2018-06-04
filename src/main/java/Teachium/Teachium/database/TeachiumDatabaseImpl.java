package Teachium.Teachium.database;

import Teachium.Teachium.domain.Message;
import Teachium.Teachium.domain.Utilisateur;

import java.util.ArrayList;

public class TeachiumDatabaseImpl implements TeachiumDatabase {
  private ArrayList<Utilisateur> utilisateurs;

  public TeachiumDatabaseImpl() {
    // TODO Auto-generated constructor stub
    this.utilisateurs = new ArrayList<Utilisateur>();
  }

  public boolean accepterUtilisateur(String id) throws Exception {
    // TODO Auto-generated method stub
    this.utilisateurs.get(Integer.parseInt(id)).setAccepted(true);
    return false;
  }

  public boolean supprimerUtilisateur(String id) throws Exception {
    // TODO Auto-generated method stub
    this.utilisateurs.remove(Integer.parseInt(id));
    return false;
  }

  public boolean accepterFormation(String string)
    throws
      Exception {// TODO Auto-generated method stub

    return false;
  }

  public boolean supprimerFormation(String string)
    throws
      Exception {// TODO Auto-generated method stub

    return false;
  }

  public void insererUtilisateur(
    Utilisateur utilisateur
  ) {// TODO Auto-generated method stub
  }

  public Utilisateur[] getDemandesDinscriptionsAppreneurs(

  ) {// TODO Auto-generated method stub

    return null;
  }

  public Utilisateur[] getDemandesDinscriptionsFormatteurs(

  ) {// TODO Auto-generated method stub

    return null;
  }

  public Message[] getAdminMessages() {// TODO Auto-generated method stub

    return new Message[] {
      new Message("title", "message"),
      new Message("Urgent", "Need sex")
    };
  }

}

