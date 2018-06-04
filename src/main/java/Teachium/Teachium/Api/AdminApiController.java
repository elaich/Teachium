package Teachium.Teachium.Api;

import Teachium.Teachium.domain.AdminService;
import Teachium.Teachium.domain.Message;
import Teachium.Teachium.domain.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminApiController implements AdminApi {
  private AdminService adminService;

  public AdminApiController(AdminService adminService) {
    this.adminService = adminService;
  }

  @RequestMapping("/utilisateur")
  public void accepterUtilisateur(String string) {
    // TODO Auto-generated method stub
    this.adminService.ajouterUtilisateur(string);
  }

  public void supprimerUtilisateur(String string) {
    // TODO Auto-generated method stub
    this.adminService.supprimerUtilisateur(string);
  }

  public void accepterFormation(String string) {
    // TODO Auto-generated method stub
    this.adminService.ajouterFormation(string);
  }

  public void supprimerFormation(String string) {
    // TODO Auto-generated method stub
    this.adminService.supprimerFormation(string);
  }

  public Utilisateur[] getDemandesDinscription(

  ) {// TODO Auto-generated method stub

    return this.adminService.getDemandesDinscriptions();
  }

  public Utilisateur[] getDemandesDinscriptionAppreneurs(

  ) {// TODO Auto-generated method stub

    return this.adminService.getDemandesDinscriptionsAppreneurs();
  }

  public Utilisateur[] getDemandesDinscriptionFormatteurs(

  ) {// TODO Auto-generated method stub

    return this.adminService.getDemandesDinscriptionsFormatteurs();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/messages")
  public Message[] getMessages() {// TODO Auto-generated method stub

    return this.adminService.getMessages();
  }

}

