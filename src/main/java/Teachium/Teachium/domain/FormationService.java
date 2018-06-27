package Teachium.Teachium.domain;

import java.util.List;

public interface FormationService {

	Formation createFormation(Formation formation);

	Formation getFormation(String string);

	void addFile(Formation formation, String filepath);

	void updateFormation(Formation formation);

	List<Formation> getFormations();

	List<Formation> getDemandesFormations();

}
