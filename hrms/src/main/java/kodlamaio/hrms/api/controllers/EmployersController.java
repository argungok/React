package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.employerService.getAll());
    }

    @PostMapping("/addEmployer")
    public ResponseEntity<?> addEmployer(@Valid @RequestBody Employer employer){
        return ResponseEntity.ok(this.employerService.add(employer));
    }

    @PostMapping("/deleteJobAdvertisement")
    public ResponseEntity<?> deleteJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(this.employerService.deleteJobAdvertisement(jobAdvertisement));
    }

}