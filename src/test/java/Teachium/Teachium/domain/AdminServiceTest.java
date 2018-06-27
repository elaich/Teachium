package Teachium.Teachium.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Teachium.Teachium.database.TeachiumDatabase;

public class AdminServiceTest {
  TeachiumDatabase databaseMock;
  AdminService service;

  @BeforeEach
  public void setUp() throws Exception {
    databaseMock = mock(TeachiumDatabase.class);
    service = new AdminServiceImpl(databaseMock);
  }

  @Test
  public void testGetMessages() {
	  List<Message> mockList = new ArrayList<Message>();
	  mockList.add(new Message("text", "from", "to"));
	  mockList.add(new Message("text is very long", "Marouane", "admin"));
    when(databaseMock.getAdminMessages()).thenReturn(mockList);

    List<Message> messages = service.getMessages(null);
    assertEquals(messages, mockList);
  }

  @Test
  public void testGetDemandesDinscriptionFormatteurs() throws Exception {
	    List<Utilisateur> mockList = new ArrayList<Utilisateur>();
	    mockList.add(mock(Utilisateur.class));
	    mockList.add(mock(Utilisateur.class));
    when(databaseMock.getDemandesDinscriptionsFormatteurs()).thenReturn(
      mockList
    );

    List<Utilisateur> users = service.getDemandesDinscriptionsFormatteurs();
    assertEquals(users, mockList);
  }

  @Test
  public void testGetDemandesDinscriptionAppreneurs() throws Exception {
	    List<Utilisateur> mockList = new ArrayList<Utilisateur>();
	    mockList.add(mock(Utilisateur.class));
	    mockList.add(mock(Utilisateur.class));
    when(databaseMock.getDemandesDinscriptionsAppreneurs()).thenReturn(
      mockList
    );

    List<Utilisateur> users = service.getDemandesDinscriptionsAppreneurs();
    assertEquals(users, mockList);
  }

  @Test
  public void testAjouterUtilisateur() {
    service.ajouterUtilisateur("a12");
    verify(databaseMock).accepterUtilisateur("a12");
  }

  @Test
  public void testSupprimerUtilisateur() throws Exception {
    boolean success = service.supprimerUtilisateur("a12");
    assertTrue(success, "it should be true");
    verify(databaseMock).supprimerUtilisateur("a12");
  }


  @Test
  public void testAjouterFormation() throws Exception {
    boolean success = service.ajouterFormation("a11");
    assertTrue(success);
    verify(databaseMock).accepterFormation("a11");
  }

  @Test
  public void testSupprimerFormation() throws Exception {
    boolean success = service.supprimerFormation("a11");
    assertTrue(success);
    verify(databaseMock).supprimerFormation("a11");
  }

}

