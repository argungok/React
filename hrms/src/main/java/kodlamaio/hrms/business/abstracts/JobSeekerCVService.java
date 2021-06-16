package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCV;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JobSeekerCVService {

    DataResult<List<JobSeekerCV>> getAll();
    DataResult<JobSeekerCV> findById(int id);
    Result uploadPhoto(MultipartFile file, int cvId);
    Result add(JobSeekerCV jobSeekerCV);

}
