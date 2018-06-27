package Teachium.Teachium.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

import Teachium.Teachium.Api.FormationApi;
import Teachium.Teachium.Api.FormationApiController;
import Teachium.Teachium.domain.Formation;
import Teachium.Teachium.domain.FormationService;
import Teachium.Teachium.storage.StorageService;

class FormationApiTest {

	FormationService formationService;
	FormationApi formationApi;
	StorageService storageService;
	
	@BeforeEach
	void setUp() {
		storageService = mock(StorageService.class);
		formationService = mock(FormationService.class);
		formationApi = new FormationApiController(formationService, storageService);
	}
	
	@Test
	void testCreateNewFormation() {
		Formation formation = new Formation("Amazing", "IDUSER");
		Formation sample = new Formation("hahaha", "hahaha");	
        when(formationService.createFormation(formation)).thenReturn(sample);

		Formation result = formationApi.createNewFormation(formation);
		
		verify(formationService).createFormation(formation);
		assertEquals(result, sample);
	}
	
	@Test
	void testUploadFileToFormation() {
		Formation formation = new Formation("Amazing", "IDUSER");
		MultipartFile file = mock(MultipartFile.class);

		when(storageService.store(file)).thenReturn("/path/to/file");
		when(formationService.getFormation("FormationID")).thenReturn(formation);
		
		formationApi.uploadFileToFormation("FormationID", file);
		
		verify(storageService).store(file);
		verify(formationService).getFormation("FormationID");
		verify(formationService).addFile(formation, "/path/to/file");
		verify(formationService).updateFormation(formation);
	}
	
	@Test
	void testGetAllFormations() {
		Formation formation_1 = new Formation("Amazing", "IDIDID");
		Formation formation_2 = new Formation("Awesome", "IDey");
		
		List<Formation> formations = new ArrayList<Formation>();
		formations.add(formation_1);
		formations.add(formation_2);

		when(formationService.getFormations()).thenReturn(formations);
		List<Formation> results = formationApi.getAllFormations();
		verify(formationService).getFormations();
		assertEquals(formations, results);
	}
	
	@Test
	void testGetDemandesFormations() {
		Formation formation_1 = new Formation("Amazing", "IDIDID");
		Formation formation_2 = new Formation("Awesome", "IDey");
		
		List<Formation> formations = new ArrayList<Formation>();
		formations.add(formation_1);
		formations.add(formation_2);

		when(formationService.getDemandesFormations()).thenReturn(formations);
		List<Formation> results = formationApi.getDemandesFormations();
		verify(formationService).getDemandesFormations();
		assertEquals(formations, results);
	}
	
	@Test
	void testGetFormation() {
		Formation formation = new Formation("Amazing", "IDIDID");
		
		when(formationService.getFormation("ID")).thenReturn(formation);
		
		Formation result = formationApi.getFormation("ID");
		
		verify(formationService).getFormation("ID");
		
		assertEquals(formation, result);
	}

}
