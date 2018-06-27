package Teachium.Teachium.domain;

import java.util.List;

public interface AdminService {

	public Utilisateur ajouterUtilisateur(String id);

	public boolean supprimerUtilisateur(String id);

	public boolean ajouterFormation(String id);

	public boolean supprimerFormation(String string);

	public List<Utilisateur> getDemandesDinscriptions();

	public List<Utilisateur> getDemandesDinscriptionsAppreneurs();

	public List<Utilisateur> getDemandesDinscriptionsFormatteurs();

	public List<Message> getMessages(String username);

	public Message getMessage(String string);

	public void readMessage(String id);

	public Utilisateur getUser(String username);

	public Utilisateur refuserUtilisateur(String id);

}
