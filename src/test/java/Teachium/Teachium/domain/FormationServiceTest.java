package Teachium.Teachium.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Teachium.Teachium.database.TeachiumDatabase;

class FormationServiceTest {
	
	  TeachiumDatabase databaseMock;
	  FormationService service;

	  @BeforeEach
	  public void setUp() throws Exception {
	    databaseMock = mock(TeachiumDatabase.class);
	    service = new FormationServiceImpl(databaseMock);
	  }
	  
	  @Test
	  public void testCreateFormation() {
		  Formation formation = new Formation("Amazing Training", "IDUSER");
		  service.createFormation(formation);
		  verify(databaseMock).insertFormation(formation);
	  }

	  @Test
	  public void testGetFormation() {
		  Formation formation = service.getFormation("FORMATION_ID");
		  verify(databaseMock).findFormationById("FORMATION_ID");
	  }
	  
	  @Test
	  public void testAddFile() {
		  Formation formation = new Formation("Amazing", "ID");
		  service.addFile(formation, "/path/to/file");
		  assertTrue(formation.getFiles().contains("/path/to/file"));
	  }
	  @Test
	  public void updateFormation() {
		  Formation formation = new Formation("Amaizng", "da");
		  service.updateFormation(formation);
		  verify(databaseMock).updateFormation(formation);
	  }
	  
}
