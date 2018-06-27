package Teachium.Teachium.Api;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Teachium.Teachium.domain.AdminMessagesService;
import Teachium.Teachium.domain.Message;
import Teachium.Teachium.domain.Utilisateur;
import Teachium.Teachium.domain.UtilisateurService;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurApiController implements UtilisateurApi {
	private UtilisateurService utilisateurService;
	private AdminMessagesService adminMessagesService;

	public UtilisateurApiController(UtilisateurService utilisateurService, AdminMessagesService adminMessagesService) {
		this.utilisateurService = utilisateurService;
		this.adminMessagesService = adminMessagesService;
	}

	@PostMapping
	public Utilisateur insererUtilisateur(@RequestBody Utilisateur utilisateur) {
		this.utilisateurService.ajouterUtilisateur(utilisateur);
		return utilisateur;
	}

	@Override
	@PostMapping("/formation/{id}")
	public Utilisateur choisirFormation(@PathVariable String id, @RequestBody Map<String, String> params) {
		Utilisateur user = this.utilisateurService.getUtilisateur(id);
		return this.utilisateurService.choisirFormation(user, params.get("formationID"));
	}

	@Override
	@PostMapping("/contact")
	public void contactAdmin(@RequestBody Message message) {
		this.adminMessagesService.addMessage(message);	
	}

	@Override
	@GetMapping("/{id}")
	public Utilisateur getUser(@PathVariable String id) {
		return this.utilisateurService.getUtilisateur(id);
	}

}
