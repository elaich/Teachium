package Teachium.Teachium.Api;

import java.util.Map;

import Teachium.Teachium.domain.Message;
import Teachium.Teachium.domain.Utilisateur;

public interface UtilisateurApi {

  Utilisateur insererUtilisateur(Utilisateur utilisateur);

Utilisateur choisirFormation(String utilisateurID, Map<String, String> params);

void contactAdmin(Message message);

Utilisateur getUser(String id);

}

