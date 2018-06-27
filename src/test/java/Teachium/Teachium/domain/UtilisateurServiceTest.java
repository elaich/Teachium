package Teachium.Teachium.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Teachium.Teachium.database.TeachiumDatabase;

public class UtilisateurServiceTest {
  TeachiumDatabase databaseMock;
  UtilisateurService service;

  @BeforeEach
  public void setUp() throws Exception {
    databaseMock = mock(TeachiumDatabase.class);
    service = new UtilisateurServiceImpl(databaseMock);
  }

  @Test
  public void testUtilisateurInscrire() {
    Utilisateur utilisateur = mock(Utilisateur.class);
    boolean success = service.ajouterUtilisateur(utilisateur);
    assertTrue(success);
    verify(databaseMock).insererUtilisateur(utilisateur);
  }

  @Test
  public void testChoisirFormation() throws Exception {
    Utilisateur utilisateur = new Utilisateur("Marouane", "El Aich", "APPRENEUR");
    Utilisateur result = service.choisirFormation(utilisateur, "IDFormation");
    result = service.choisirFormation(utilisateur, "IDHAMID");
    assertTrue(result.getFormations().contains("IDFormation"));
    assertTrue(result.getFormations().contains("IDHAMID"));
  }
  
  @Test
  public void testGetUtilisateur() {
	  Utilisateur user = new Utilisateur("MA", "HA", "HO");
	  when(databaseMock.getUtilisateur("ID")).thenReturn(user);
	  Utilisateur utilisateur = service.getUtilisateur("ID");
	  verify(databaseMock).getUtilisateur("ID");
	  assertEquals(utilisateur, user);
  }

}

