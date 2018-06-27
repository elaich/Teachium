package Teachium.Teachium.database;

import java.util.List;

import Teachium.Teachium.domain.Formation;
import Teachium.Teachium.domain.Message;
import Teachium.Teachium.domain.Utilisateur;

public interface TeachiumDatabase {

	public Utilisateur accepterUtilisateur(String id);

	public boolean supprimerUtilisateur(String id);

	public boolean accepterFormation(String string);

	public boolean supprimerFormation(String string);

	public void insererUtilisateur(Utilisateur utilisateur);

	public List<Utilisateur> getDemandesDinscriptionsAppreneurs();

	public List<Utilisateur> getDemandesDinscriptionsFormatteurs();

	public List<Message> getAdminMessages();

	public void updateUtilisateur(Utilisateur result);

	public Formation insertFormation(Formation formation);

	public Formation findFormationById(String string);

	public void updateFormation(Formation formation);

	public Utilisateur getUtilisateur(String id);

	public void insertMessage(Message message);

	public List<Formation> findAllFormations();

	public List<Formation> findDemandesFormations();

	public Message getAdminMessage(String string);

	public Utilisateur getUtilisateurByUsername(String username);

	public List<Message> getMessagesByTo(String id);

	public void readMessage(String id);

	public List<Utilisateur> getDemandesDinscriptions();

	public Utilisateur refusterUtilisateur(String id);

}
