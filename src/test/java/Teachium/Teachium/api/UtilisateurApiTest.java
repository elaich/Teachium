package Teachium.Teachium.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Teachium.Teachium.Api.UtilisateurApi;
import Teachium.Teachium.Api.UtilisateurApiController;
import Teachium.Teachium.domain.AdminMessagesService;
import Teachium.Teachium.domain.Formation;
import Teachium.Teachium.domain.Message;
import Teachium.Teachium.domain.Utilisateur;
import Teachium.Teachium.domain.UtilisateurService;

class UtilisateurApiTest {

	Utilisateur utilisateur;
	UtilisateurService utilisateurService;
	UtilisateurApi utilisateurApi;
	AdminMessagesService adminMessagesService;

	@BeforeEach
	public void setUp() {
		utilisateur = new Utilisateur("Marouane", "ElAich", "APPRENEUR");
		utilisateurService = mock(UtilisateurService.class);
		adminMessagesService = mock(AdminMessagesService.class);
		utilisateurApi = new UtilisateurApiController(utilisateurService, adminMessagesService);
	}

	@Test
	public void testInsererUtilisateurApi() {
		Utilisateur response = utilisateurApi.insererUtilisateur(utilisateur);
		verify(utilisateurService).ajouterUtilisateur(utilisateur);
		assertEquals(response, utilisateur);
	}

	@Test
	public void testChoisirFormationApi() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("formationID", "formationID");
		when(utilisateurService.getUtilisateur("ID")).thenReturn(utilisateur);
		Utilisateur response = utilisateurApi.choisirFormation("ID", params);

		verify(utilisateurService).choisirFormation(utilisateur, "formationID");
	}
	
	@Test
	public void testContactAdminApi() {
		Message message = new Message("Text", "FROM", "TO");
		utilisateurApi.contactAdmin(message);
		
		verify(adminMessagesService).addMessage(message);
	}
	
	@Test
	public void testGetUser() {
		Utilisateur user = new Utilisateur("Ha", "ho", "hi");
		when(utilisateurService.getUtilisateur("ID")).thenReturn(user);
		
		Utilisateur utilisateur = utilisateurApi.getUser("ID");
		assertEquals(user, utilisateur);
	}
	
	@Test
	public void testChoisirFormationReturnUpdatedUser() {
		Map<String, String> params = new HashMap<String, String>();
		Utilisateur userWithFormation = new Utilisateur("Ha", "Ho", "Hi");
		List<String> formations = userWithFormation.getFormations();
		formations.add("HABI");
		userWithFormation.setFormations(formations);
		
		params.put("formationID", "formationID");
		when(utilisateurService.getUtilisateur("ID")).thenReturn(utilisateur);
		when(utilisateurService.choisirFormation(utilisateur, "formationID")).thenReturn(userWithFormation);
		Utilisateur response = utilisateurApi.choisirFormation("ID", params);

		assertEquals(response, userWithFormation);
	}
}
