package Teachium.Teachium.api;

import Teachium.Teachium.Api.AdminApi;
import Teachium.Teachium.Api.AdminApiController;
import Teachium.Teachium.domain.AdminService;
import Teachium.Teachium.domain.Message;
import Teachium.Teachium.domain.Utilisateur;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AdminApiTest {

  @Test
  public void testGetMessagesApi() {
    AdminService adminService = mock(AdminService.class);
    Message[] mockList = { mock(Message.class), mock(Message.class) };
    when(adminService.getMessages()).thenReturn(mockList);

    AdminApi adminApi = new AdminApiController(adminService);
    Message[] messages = adminApi.getMessages();
    assertEquals(messages, mockList);
  }

  @Test
  public void testGetDemandesDinscriptionApi() {
    AdminService adminService = mock(AdminService.class);
    Utilisateur[] mockList = {
      mock(Utilisateur.class),
      mock(Utilisateur.class)
    };
    when(adminService.getDemandesDinscriptions()).thenReturn(mockList);

    AdminApi adminApi = new AdminApiController(adminService);
    Utilisateur[] users = adminApi.getDemandesDinscription();
    assertEquals(users, mockList);
  }

  @Test
  public void testGetDemandesDinscriptionFormatteurApi() {
    AdminService adminService = mock(AdminService.class);
    Utilisateur[] mockList = {
      mock(Utilisateur.class),
      mock(Utilisateur.class)
    };
    when(adminService.getDemandesDinscriptionsFormatteurs()).thenReturn(
      mockList
    );

    AdminApi adminApi = new AdminApiController(adminService);
    Utilisateur[] users = adminApi.getDemandesDinscriptionFormatteurs();
    assertEquals(users, mockList);
  }

  @Test
  public void testGetDemandesDinscriptionAppreneurApi() {
    AdminService adminService = mock(AdminService.class);
    Utilisateur[] mockList = {
      mock(Utilisateur.class),
      mock(Utilisateur.class)
    };
    when(adminService.getDemandesDinscriptionsAppreneurs()).thenReturn(
      mockList
    );

    AdminApi adminApi = new AdminApiController(adminService);
    Utilisateur[] users = adminApi.getDemandesDinscriptionAppreneurs();
    assertEquals(users, mockList);
  }

  @Test
  public void testAccepterUtilisateurApi() {
    AdminService adminService = mock(AdminService.class);
    AdminApi adminApi = new AdminApiController(adminService);

    adminApi.accepterUtilisateur("b11");

    verify(adminService).ajouterUtilisateur("b11");
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
    adminApi.accepterFormation("b11");

    verify(adminService).ajouterFormation("b11");
  }

  @Test
  public void testSupprimerFormationApi() {
    AdminService adminService = mock(AdminService.class);
    AdminApi adminApi = new AdminApiController(adminService);
    adminApi.supprimerFormation("b11");

    verify(adminService).supprimerFormation("b11");
  }
}

