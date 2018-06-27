package Teachium.Teachium.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Teachium.Teachium.domain.Formation;
import Teachium.Teachium.domain.Message;
import Teachium.Teachium.domain.Utilisateur;
import Teachium.Teachium.repos.AdminMessageRepository;
import Teachium.Teachium.repos.FormationRepository;
import Teachium.Teachium.repos.UtilisateurRepository;

@Component
public class TeachiumDatabaseImpl implements TeachiumDatabase {
	private ArrayList<Utilisateur> utilisateurs;
	
	private FormationRepository formationRepository;
	private UtilisateurRepository utilisateurRepository;
	private AdminMessageRepository adminMessageRepositry;

	@Autowired
	public TeachiumDatabaseImpl(FormationRepository formationRepository, 
			UtilisateurRepository utilisateurRepository, AdminMessageRepository adminMessageRepositry) {
		this.utilisateurs = new ArrayList<Utilisateur>();
		this.formationRepository = formationRepository;
		this.utilisateurRepository = utilisateurRepository;
		this.adminMessageRepositry = adminMessageRepositry;
	}

	public Utilisateur accepterUtilisateur(String id){
		Utilisateur user = this.utilisateurRepository.findById(id).get();
		user.setAccepted(true);
		return this.utilisateurRepository.save(user);
	}

	public boolean supprimerUtilisateur(String id){
		this.utilisateurs.remove(Integer.parseInt(id));
		return false;
	}

	public boolean accepterFormation(String string) {
		Formation formation = this.formationRepository.findById(string).get();
		formation.setConfirme(true);
		this.formationRepository.save(formation);
		return true;
	}

	public boolean supprimerFormation(String string) {
		return false;
	}

	public void insererUtilisateur(Utilisateur utilisateur)	{
		this.utilisateurRepository.save(utilisateur);
	}

	public List<Utilisateur> getDemandesDinscriptionsAppreneurs() {
		return this.utilisateurRepository.findByType("APPRENEUR"); 
	}

	public List<Utilisateur> getDemandesDinscriptionsFormatteurs() {
		return this.utilisateurRepository.findByType("FORMATTEUR"); 
	}

	public List<Message> getAdminMessages() { 
		return this.adminMessageRepositry.findAll();
	}

	@Override
	public void updateUtilisateur(Utilisateur result) {
		this.utilisateurRepository.save(result);
	}

	@Override
	public Formation insertFormation(Formation formation) {
		Formation result = this.formationRepository.save(formation);
		return result;
		
	}

	@Override
	public Formation findFormationById(String string) {
		return this.formationRepository.findById(string).get();
	}

	@Override
	public void updateFormation(Formation formation) {
		this.formationRepository.save(formation);
	}

	@Override
	public Utilisateur getUtilisateur(String id) {
		return this.utilisateurRepository.findById(id).get();
	}

	@Override
	public void insertMessage(Message message) {
		// TODO Auto-generated method stub
		this.adminMessageRepositry.save(message);
		
	}

	@Override
	public List<Formation> findAllFormations() {
		return this.formationRepository.findAll();
	}

	@Override
	public List<Formation> findDemandesFormations() {
		return this.formationRepository.findByConfirme(false);
	}

	@Override
	public Message getAdminMessage(String string) {
		return this.adminMessageRepositry.findById(string).get();
	}

	@Override
	public Utilisateur getUtilisateurByUsername(String username) {
		return this.utilisateurRepository.findByUsername(username);
	}

	@Override
	public List<Message> getMessagesByTo(String id) {
		return this.adminMessageRepositry.findByTo(id);
	}

	@Override
	public void readMessage(String id) {
		Message message = this.adminMessageRepositry.findById(id).get();
		message.setRead(true);
		this.adminMessageRepositry.save(message);
	}

	@Override
	public List<Utilisateur> getDemandesDinscriptions() {
		// TODO Auto-generated method stub
		return this.utilisateurRepository.findByAccepted(false);
	}

	@Override
	public Utilisateur refusterUtilisateur(String id) {
		Utilisateur user = this.utilisateurRepository.findById(id).get();
		this.utilisateurRepository.delete(user);
		return null;
	}


}
