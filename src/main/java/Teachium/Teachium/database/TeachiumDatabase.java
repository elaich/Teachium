package Teachium.Teachium.database;

import Teachium.Teachium.domain.Message;
import Teachium.Teachium.domain.Utilisateur;

public interface TeachiumDatabase {

  public boolean accepterUtilisateur(String id) throws Exception;

  public boolean supprimerUtilisateur(String id) throws Exception;

  public boolean accepterFormation(String string) throws Exception;

  public boolean supprimerFormation(String string) throws Exception;

  public void insererUtilisateur(Utilisateur utilisateur);

  public Utilisateur[] getDemandesDinscriptionsAppreneurs();

  public Utilisateur[] getDemandesDinscriptionsFormatteurs();

  public Message[] getAdminMessages();

}

