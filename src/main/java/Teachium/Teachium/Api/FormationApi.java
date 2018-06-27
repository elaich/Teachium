package Teachium.Teachium.Api;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import Teachium.Teachium.domain.Formation;

public interface FormationApi {

	Formation createNewFormation(Formation formation);

	Formation uploadFileToFormation(String formationID, MultipartFile file);

	List<Formation> getAllFormations();

	List<Formation> getDemandesFormations();

	Formation getFormation(String formationID);

}
