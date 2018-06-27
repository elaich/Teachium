package Teachium.Teachium.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Teachium.Teachium.Api.AdminApi;
import Teachium.Teachium.Api.AdminApiController;
import Teachium.Teachium.domain.AdminService;
import Teachium.Teachium.domain.Message;
import Teachium.Teachium.domain.Utilisateur;

public class AdminApiTest {
	AdminService adminService;
	AdminApi adminApi;
	
	@BeforeEach
	public void setUp() {
		  adminService = mock(AdminService.class);
		  adminApi = new AdminApiController(adminService);
	}

  @Test
  public void testGetDemandesDinscriptionFormatteurApi() {
    AdminService adminService = mock(AdminService.class);
    List<Utilisateur> mockList = new ArrayList<Utilisateur>();
    mockList.add(mock(Utilisateur.class));
    mockList.add(mock(Utilisateur.class));
    
    when(adminService.getDemandesDinscriptionsFormatteurs()).thenReturn(
      mockList
    );

    AdminApi adminApi = new AdminApiController(adminService);
    List<Utilisateur> users = adminApi.getDemandesDinscriptionFormatteurs();
    assertEquals(users, mockList);
  }

  @Test
  public void testGetDemandesDinscriptionAppreneurApi() {
    AdminService adminService = mock(AdminService.class);
    List<Utilisateur> mockList = new ArrayList<Utilisateur>();
    mockList.add(mock(Utilisateur.class));
    mockList.add(mock(Utilisateur.class));
    
    when(adminService.getDemandesDinscriptionsAppreneurs()).thenReturn(
      mockList
    );

    AdminApi adminApi = new AdminApiController(adminService);
    List<Utilisateur> users = adminApi.getDemandesDinscriptionAppreneurs();
    assertEquals(users, mockList);
  }

  @Test
  public void testAccepterUtilisateurApi() {
    AdminService adminService = mock(AdminService.class);
    AdminApi adminApi = new AdminApiController(adminService);
    Utilisateur expected = new Utilisateur("Marouane", "Elaich", "APPRENEUR");
    when(adminService.ajouterUtilisateur("b11")).thenReturn(expected);
    
    Map<String, String> params = new HashMap<String, String>();
    params.put("id", "b11");
    Utilisateur utilisateur = adminApi.accepterUtilisateur(params);
    
    assertEquals(utilisateur, expected);
  }

  @Test
  public void testSupprimerUtilisateurApi() {
    AdminService adminService = mock(AdminService.class);
    AdminApi adminApi = new AdminApiController(adminService);
    adminApi.supprimerUtilisateur("b11");

    verify(adminService).supprimerUtilisateur("b11");
  }

  @Test
  public void testAccepterFormationApi() {
    AdminService adminService = mock(AdminService.class);
    AdminApi adminApi = new AdminApiController(adminService);
    Map<String, String> params = new HashMap<String, String>();
    params.put("id", "b11");
    adminApi.accepterFormation(params);

    verify(adminService).ajouterFormation("b11");
  }

  @Test
  public void testSupprimerFormationApi() {
    AdminService adminService = mock(AdminService.class);
    AdminApi adminApi = new AdminApiController(adminService);
    adminApi.supprimerFormation("b11");

    verify(adminService).supprimerFormation("b11");
  }
  
  @Test
  public void testGetMessagesApi() {
	  List<Message> mockMessages = new ArrayList<Message>();
	  mockMessages.add(new Message("text", "from", "to"));
	  mockMessages.add(new Message("text is very long", "Marouane", "admin"));

	  when(adminService.getMessages(null)).thenReturn(mockMessages);
	  List<Message> messages = adminApi.getMessages("username");
	  assertEquals(mockMessages, messages);
  }
  
  @Test 
  public void testGetMessageApi() {
	  Message message = new Message("text", "from", "to");
	  when(adminService.getMessage("ID")).thenReturn(message);
	  Message result = adminApi.getMessage("ID");
	  
	  verify(adminService).getMessage("ID");
	  assertEquals(result, message);

  }

}

