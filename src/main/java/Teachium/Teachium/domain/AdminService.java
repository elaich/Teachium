package Teachium.Teachium.domain;

import java.util.ArrayList;

public interface AdminService {

  public boolean ajouterUtilisateur(String id);

  public boolean supprimerUtilisateur(String id);

  public boolean ajouterFormation(String id);

  public boolean supprimerFormation(String string);

  public Utilisateur[] getDemandesDinscriptions();

  public Utilisateur[] getDemandesDinscriptionsAppreneurs();

  public Utilisateur[] getDemandesDinscriptionsFormatteurs();

  public Message[] getMessages();

}

