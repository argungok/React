package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerAuthService;
import kodlamaio.hrms.core.utilities.messages.SuccessMessages;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerAuthService jobSeekerAuthService;
    private JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(@Lazy JobSeekerAuthService jobSeekerAuthService, JobSeekerDao jobSeekerDao) {
        this.jobSeekerAuthService = jobSeekerAuthService;
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<>(this.jobSeekerDao.findAll(), SuccessMessages.getJobSeekerList);
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        Result result = jobSeekerAuthService.addJobSeekerAuth(jobSeeker);

        if(!result.isSuccess()){
            return new ErrorResult(false, jobSeekerAuthService.addJobSeekerAuth(jobSeeker).getMessage());
        }
        else{
            this.jobSeekerDao.save(jobSeeker);
            return new SuccessResult(true, SuccessMessages.addedJobSeeker);
        }
    }
	
}
