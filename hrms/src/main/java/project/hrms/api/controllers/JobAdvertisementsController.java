package project.hrms.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.JobAdvertisementService;
import project.hrms.core.converter.JobAdvertisementConverter;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobAdvertisement;
import project.hrms.entities.dtos.JobAdvertisementDto;


@RestController
@RequestMapping("/api/jobAdvertisements/")
public class JobAdvertisementsController {

	
	private JobAdvertisementService jobAdvertisementService;
	

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService,JobAdvertisementConverter jobAdvertisementsConverter) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
		
	} 
	
	@PostMapping("add")
 	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
 		
 		return this.jobAdvertisementService.add(jobAdvertisement);
 	}
	
	
	@GetMapping("getAll")
	public DataResult<List<JobAdvertisementDto>> getAll(){
		
		return  this.jobAdvertisementService.getAll();
		
		
	}
	
	@GetMapping("getByEmployerId")
	public DataResult<List<JobAdvertisement>> getByEmployerId(@RequestParam int id){
		return this.jobAdvertisementService.getByEmployerId(id);
		
	}
	
	@PutMapping("changeStatus")
	public Result changeStatus(@RequestParam int id,boolean status) {
		
		return this.jobAdvertisementService.changeStatus(id,status);
		
	}
	
	@GetMapping("getByStatusOfActive")
	public DataResult<List<JobAdvertisement>> getByStatusOfActive(boolean status){
		
		return this.jobAdvertisementService.getByStatusOfActive(status);
	}
	
	@GetMapping("getAllSortedBySalary")
	
	DataResult<List<JobAdvertisement>> getAllSortedBySalary(boolean sortType){
		
		return this.jobAdvertisementService.getAllSortedBySalary(sortType);
	}
	
	
	@GetMapping("getAllSortedByReleaseDate")
	
	public DataResult<List<JobAdvertisementDto>> getAllSortByDate(boolean sortByDate){
		
		return this.jobAdvertisementService.getAllSortByDate(sortByDate);
		
	}
	
}