package Teachium.Teachium.Api;

import java.util.List;
import java.util.Map;

import Teachium.Teachium.domain.Message;
import Teachium.Teachium.domain.Utilisateur;

public interface AdminApi {

	Utilisateur accepterUtilisateur(Map<String, String> params);

	void supprimerUtilisateur(String string);

	void accepterFormation(Map<String, String> params);

	void supprimerFormation(String string);

	List<Utilisateur> getDemandesDinscription();

	List<Utilisateur> getDemandesDinscriptionAppreneurs();

	List<Utilisateur> getDemandesDinscriptionFormatteurs();

	List<Message> getMessages(String username);

	Message getMessage(String string);

}
