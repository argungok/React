package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.core.logger.Logger;
import kodlamaio.hrms.core.utilities.messages.ErrorMessages;
import kodlamaio.hrms.core.utilities.messages.SuccessMessages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.services.mernisService.MernisCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerAuthService;

@Service
public class JobSeekerAuthManager implements JobSeekerAuthService {

    private JobSeekerDao jobSeekerDao;
    private UserDao userDao;
    private MernisCheckService mernisCheckService;
    private Logger logger;

    @Autowired
    public JobSeekerAuthManager(JobSeekerDao jobSeekerDao, UserDao userDao, MernisCheckService mernisCheckService,
            Logger logger) {
        this.jobSeekerDao = jobSeekerDao;
        this.userDao = userDao;
        this.mernisCheckService = mernisCheckService;
        this.logger = logger;
    }

    @Override
    public Result addJobSeekerAuth(JobSeeker jobSeeker) {

        if(jobSeeker.getName() == null || jobSeeker.getSurname() == null ||
                jobSeeker.getNationalId() == null || jobSeeker.getYearOfBirth() == null ||
                jobSeeker.getEmail() == null || jobSeeker.getPassword() == null){
            return new ErrorResult(false, ErrorMessages.nullRegisterForm);
        }

        if(!mernisCheckService.checkIfRealPerson(jobSeeker.getEmail(), jobSeeker.getPassword())){
            return new ErrorResult(false, ErrorMessages.invalidUser);
        }

        if(userDao.existsByEmail(jobSeeker.getEmail())){
            return new ErrorResult(false, ErrorMessages.usedEmail);
        }

        if(jobSeekerDao.existsByNationalId(jobSeeker.getNationalId())){
            return new ErrorResult(false, ErrorMessages.usedNationalId);
        }

        Result resultMail = logger.log(SuccessMessages.logEmail);

        if(!resultMail.isSuccess()){
            return new ErrorResult(false, ErrorMessages.notValidateMail);
        }

        return new SuccessResult(true);
    }
	
}
