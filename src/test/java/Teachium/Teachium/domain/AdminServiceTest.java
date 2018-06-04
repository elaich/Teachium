package Teachium.Teachium.domain;

import Teachium.Teachium.database.TeachiumDatabase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

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
    Message[] mockList = { mock(Message.class), mock(Message.class) };
    when(databaseMock.getAdminMessages()).thenReturn(mockList);

    Message[] messages = service.getMessages();
    assertEquals(messages, mockList);
  }

  @Test
  public void testGetDemandesDinscriptionFormatteurs() throws Exception {
    Utilisateur[] mockList = {
      mock(Utilisateur.class),
      mock(Utilisateur.class)
    };
    when(databaseMock.getDemandesDinscriptionsFormatteurs()).thenReturn(
      mockList
    );

    Utilisateur[] users = service.getDemandesDinscriptionsFormatteurs();
    assertEquals(users, mockList);
  }

  @Test
  public void testGetDemandesDinscriptionAppreneurs() throws Exception {
    Utilisateur[] mockList = {
      mock(Utilisateur.class),
      mock(Utilisateur.class)
    };
    when(databaseMock.getDemandesDinscriptionsAppreneurs()).thenReturn(
      mockList
    );

    Utilisateur[] users = service.getDemandesDinscriptionsAppreneurs();
    assertEquals(users, mockList);
  }

  @Test
  public void testAjouterUtilisateur() throws Exception {
    boolean success = service.ajouterUtilisateur("a12");
    assertTrue(success);
    verify(databaseMock).accepterUtilisateur("a12");
  }

  @Test
  public void testAjouterUtilisateurQuandDatabaseThrowsException()
    throws
      Exception {
    when(databaseMock.accepterUtilisateur("a12")).thenThrow(new Exception());
    boolean success = service.ajouterUtilisateur("a12");
    assertFalse(success, "Hadchi makhdamch");
  }

  @Test
  public void testSupprimerUtilisateur() throws Exception {
    boolean success = service.supprimerUtilisateur("a12");
    assertTrue(success, "it should be true");
    verify(databaseMock).supprimerUtilisateur("a12");
  }

  @Test
  public void testsupprimerUtilisateurQuandDatabaseThrowsException()
    throws
      Exception {
    when(databaseMock.supprimerUtilisateur("a12")).thenThrow(new Exception());
    boolean success = service.supprimerUtilisateur("a12");
    assertFalse(success);
  }

  @Test
  public void testAjouterFormation() throws Exception {
    boolean success = service.ajouterFormation("a11");
    assertTrue(success);
    verify(databaseMock).accepterFormation("a11");
  }

  @Test
  public void testAjouterFormationQuandDatabaseThrowsException()
    throws
      Exception {
    when(databaseMock.accepterFormation("a12")).thenThrow(new Exception());
    boolean success = service.ajouterFormation("a12");
    assertFalse(success);
  }

  @Test
  public void testSupprimerFormation() throws Exception {
    boolean success = service.supprimerFormation("a11");
    assertTrue(success);
    verify(databaseMock).supprimerFormation("a11");
  }

  @Test
  public void testSupprimerFormationQuandDatabaseThrowsException()
    throws
      Exception {
    when(databaseMock.supprimerFormation("a12")).thenThrow(new Exception());
    boolean success = service.supprimerFormation("a12");
    assertFalse(success);
  }

}

