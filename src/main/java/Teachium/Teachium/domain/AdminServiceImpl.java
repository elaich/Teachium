package Teachium.Teachium.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Teachium.Teachium.database.TeachiumDatabase;

@Service
public class AdminServiceImpl implements AdminService {
  private TeachiumDatabase teachiumDatabase;

  @Autowired
  public AdminServiceImpl(TeachiumDatabase teachiumDatabase) {
    // TODO Auto-generated constructor stub
    this.teachiumDatabase = teachiumDatabase;
  }

  public Utilisateur ajouterUtilisateur(String id) {
      return this.teachiumDatabase.accepterUtilisateur(id);
  }

  public boolean supprimerUtilisateur(
    String id
  ) {// TODO Auto-generated method stub

    try {
      this.teachiumDatabase.supprimerUtilisateur(id);
      return true;
    } catch(Exception e) //e.printStackTrace();
    {}
    return false;
  }

  public boolean ajouterFormation(String id) {
      this.teachiumDatabase.accepterFormation(id);
      return true;
  }

  public boolean supprimerFormation(String id) {
    try {
      this.teachiumDatabase.supprimerFormation(id);
      return true;
    } catch(Exception e) //e.printStackTrace();
    {} // TODO Auto-generated method stub

    return false;
  }

  public List<Utilisateur> getDemandesDinscriptions(

  ) {// TODO Auto-generated method stub

    return this.teachiumDatabase.getDemandesDinscriptions();
  }

  public List<Utilisateur> getDemandesDinscriptionsAppreneurs() {
    return this.teachiumDatabase.getDemandesDinscriptionsAppreneurs();
  }

  public List<Utilisateur> getDemandesDinscriptionsFormatteurs(

  ) {// TODO Auto-generated method stub

    return this.teachiumDatabase.getDemandesDinscriptionsFormatteurs();
  }

  public List<Message> getMessages(String username) {
	  Utilisateur user = this.teachiumDatabase.getUtilisateurByUsername(username);
	  return this.teachiumDatabase.getMessagesByTo(user.getId());
  }

@Override
public Message getMessage(String string) {
	return this.teachiumDatabase.getAdminMessage(string);
}

@Override
public void readMessage(String id) {
	this.teachiumDatabase.readMessage(id);
}

@Override
public Utilisateur getUser(String username) {
	// TODO Auto-generated method stub

	return this.teachiumDatabase.getUtilisateurByUsername(username);
}

@Override
public Utilisateur refuserUtilisateur(String id) {
	return this.teachiumDatabase.refusterUtilisateur(id);
}

}

