package Teachium.Teachium.Api;

import Teachium.Teachium.domain.Message;
import Teachium.Teachium.domain.Utilisateur;

public interface AdminApi {

  void accepterUtilisateur(String string);

  void supprimerUtilisateur(String string);

  void accepterFormation(String string);

  void supprimerFormation(String string);

  Utilisateur[] getDemandesDinscription();

  Utilisateur[] getDemandesDinscriptionAppreneurs();

  Utilisateur[] getDemandesDinscriptionFormatteurs();

  Message[] getMessages();

}

