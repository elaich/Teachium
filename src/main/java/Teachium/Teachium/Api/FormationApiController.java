package Teachium.Teachium.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Teachium.Teachium.domain.Formation;
import Teachium.Teachium.domain.FormationService;
import Teachium.Teachium.storage.StorageService;

@RestController
@RequestMapping("/formations")
public class FormationApiController implements FormationApi {

	private FormationService formationService;
	private StorageService storageService;
	
	@Autowired
	public FormationApiController(FormationService formationService, StorageService storageService) {
		// TODO Auto-generated constructor stub
		this.formationService = formationService;
		this.storageService = storageService;
	}

	@PostMapping
	public Formation createNewFormation(@RequestBody Formation formation) {
		// TODO Auto-generated method stub
		return this.formationService.createFormation(formation);
	}

	@PostMapping("/file")
	public Formation uploadFileToFormation(String formationID, @RequestParam("file") MultipartFile file) {
		// TODO Auto-generated method stub
		Formation formation = this.formationService.getFormation(formationID);
		String filepath = this.storageService.store(file);
		formationService.addFile(formation, filepath);
		formationService.updateFormation(formation);
		return formation;
	}

	@GetMapping
	public List<Formation> getAllFormations() {
		return this.formationService.getFormations();
	}

	@GetMapping("/demandes")
	public List<Formation> getDemandesFormations() {
		return this.formationService.getDemandesFormations();
	}

	@GetMapping("/{id}")
	public Formation getFormation(@PathVariable String id) {
		return this.formationService.getFormation(id);		
	}

}
