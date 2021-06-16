package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.jobAdvertisementService.getAll());
    }

    @GetMapping("/getAllByDate")
    public ResponseEntity<?> getAllSorted(){
        return ResponseEntity.ok(this.jobAdvertisementService.getAllSorted());
    }

    @GetMapping("/getAllByEmployer")
    public ResponseEntity<?> getAllEmployer(String companyName){
        return ResponseEntity.ok(this.jobAdvertisementService.getAllByEmployer(companyName));
    }

    @PostMapping("/addJobAdvertisement")
    public ResponseEntity<?> add(@RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
    }

}
