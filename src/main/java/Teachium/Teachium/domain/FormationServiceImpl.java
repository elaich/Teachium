package Teachium.Teachium.domain;

import java.util.List;

import org.springframework.stereotype.Component;

import Teachium.Teachium.database.TeachiumDatabase;

@Component
public class FormationServiceImpl implements FormationService {
	
	private TeachiumDatabase teachiumDatabase;

	public FormationServiceImpl(TeachiumDatabase teachiumDatabase) {
		// TODO Auto-generated constructor stub
		this.teachiumDatabase = teachiumDatabase;
	}

	@Override
	public Formation createFormation(Formation formation) {
		// TODO Auto-generated method stub
		return this.teachiumDatabase.insertFormation(formation);
		
	}

	@Override
	public Formation getFormation(String formationID) {
		// TODO Auto-generated method stub
		Formation formation = this.teachiumDatabase.findFormationById(formationID);
		return formation;
	}

	@Override
	public void addFile(Formation formation, String filepath) {
		formation.getFiles().add(filepath);
	}

	@Override
	public void updateFormation(Formation formation) {
		// TODO Auto-generated method stub
		this.teachiumDatabase.updateFormation(formation);
		
	}

	@Override
	public List<Formation> getFormations() {
		return this.teachiumDatabase.findAllFormations();
	}

	@Override
	public List<Formation> getDemandesFormations() {
		return this.teachiumDatabase.findDemandesFormations();
	}

}
