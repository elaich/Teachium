package Teachium.Teachium.domain;

import Teachium.Teachium.database.TeachiumDatabase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

}

