package Teachium.Teachium.Api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import Teachium.Teachium.domain.AdminService;
import Teachium.Teachium.domain.Message;
import Teachium.Teachium.domain.Utilisateur;

@RestController
@RequestMapping("/admin")
public class AdminApiController implements AdminApi {
	private AdminService adminService;

	@Autowired
	public AdminApiController(AdminService adminService) {
		this.adminService = adminService;
	}

	@PostMapping("/utilisateur")
	public Utilisateur accepterUtilisateur(@RequestBody Map<String, String> params) {
		// TODO Auto-generated method stub
		String id = params.get("id");
		return this.adminService.ajouterUtilisateur(id);
	}
	
	@PostMapping("/utilisateur/refuser")
	public Utilisateur refuserUtilisateur(@RequestBody Map<String, String> params) {
		// TODO Auto-generated method stub
		String id = params.get("id");
		return this.adminService.refuserUtilisateur(id);
	}

	public void supprimerUtilisateur(String string) {
		// TODO Auto-generated method stub
		this.adminService.supprimerUtilisateur(string);
	}

	public void supprimerFormation(String string) {
		// TODO Auto-generated method stub
		this.adminService.supprimerFormation(string);
	}

	@GetMapping("/appreneurs")
	public List<Utilisateur> getDemandesDinscriptionAppreneurs() {
		return this.adminService.getDemandesDinscriptionsAppreneurs();
	}

	@GetMapping("/formatteurs")
	public List<Utilisateur> getDemandesDinscriptionFormatteurs() {
		return this.adminService.getDemandesDinscriptionsFormatteurs();
	}
	
	@GetMapping("/inscriptions")
	public List<Utilisateur> getDemandesDinscription() {
		return this.adminService.getDemandesDinscriptions();
	}

	@GetMapping("/messages")
	public List<Message> getMessages(@RequestParam String username) {
		return this.adminService.getMessages(username);
	}

	@PostMapping("/formation")
	public void accepterFormation(@RequestBody Map<String, String> params) {
		// TODO Auto-generated method stub
		String id = params.get("id");
		this.adminService.ajouterFormation(id);

	}

	@GetMapping("/messages/{id}")
	public Message getMessage(@PathVariable String id) {
		return this.adminService.getMessage(id);
	}
	
	@GetMapping("/messages/read/{id}")
	public void readMessage(@PathVariable String id) {
		this.adminService.readMessage(id);
	}
	
	@GetMapping("/users/{username}") 
	public  Utilisateur getUser(@PathVariable String username) {
		
		return this.adminService.getUser(username);
	}

}
