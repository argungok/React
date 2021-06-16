package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobSeekerCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobSeekerCV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/jobSeekerCV")
public class JobSeekerCVsController {

    private JobSeekerCVService jobSeekerCVService;

    @Autowired
    public JobSeekerCVsController(JobSeekerCVService jobSeekerCVService) {
        this.jobSeekerCVService = jobSeekerCVService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.jobSeekerCVService.getAll());
    }

    @GetMapping("getById")
    public ResponseEntity<?> findById(int id){
        return ResponseEntity.ok(this.jobSeekerCVService.findById(id));
    }

    @PutMapping("/uploadProfilePhoto")
    public ResponseEntity<?> uploadPhoto(@RequestBody MultipartFile file, @RequestParam int cvId) {
        return ResponseEntity.ok(this.jobSeekerCVService.uploadPhoto(file, cvId));
    }

    @PostMapping("addCV")
    public ResponseEntity<?> add(@RequestBody JobSeekerCV jobSeekerCV){
        return ResponseEntity.ok(jobSeekerCVService.add(jobSeekerCV));
    }

}
