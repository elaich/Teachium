package Teachium.Teachium.api;

import Teachium.Teachium.Api.UtilisateurApi;
import Teachium.Teachium.Api.UtilisateurApiController;
import Teachium.Teachium.domain.Utilisateur;
import Teachium.Teachium.domain.UtilisateurService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class UtilisateurApiTest {

  @Test
  public void testInsererUtilisateurApi() {
    Utilisateur utilisateur = mock(Utilisateur.class);
    UtilisateurService utilisateurService = mock(UtilisateurService.class);

    UtilisateurApi utilisateurApi = new UtilisateurApiController(
      utilisateurService
    );

    Utilisateur response = utilisateurApi.insererUtilisateur(utilisateur);
    verify(utilisateurService).ajouterUtilisateur(utilisateur);
    assertEquals(response, utilisateur);
  }

}

