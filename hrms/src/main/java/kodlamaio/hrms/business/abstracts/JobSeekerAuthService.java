package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerAuthService {

	Result addJobSeekerAuth(JobSeeker jobSeeker);
	
}
