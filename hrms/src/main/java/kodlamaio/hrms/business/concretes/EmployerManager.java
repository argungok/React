package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerAuthService;
import kodlamaio.hrms.core.utilities.messages.SuccessMessages;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
	
    private EmployerDao employerDao;
    private JobAdvertisementDao jobAdvertisementDao;
    private EmployerAuthService employerAuthService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmployerAuthService employerAuthService) {
        this.employerDao = employerDao;
        this.employerAuthService = employerAuthService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.employerDao.findAll(), SuccessMessages.getEmployerList);
    }

    @Override
    public Result add(Employer employer) {
        Result result = employerAuthService.addEmployerAuth(employer);

        if(!result.isSuccess()){
            return new ErrorResult(false, employerAuthService.addEmployerAuth(employer).getMessage());
        }
        else{
            this.employerDao.save(employer);
            return new SuccessResult(true, SuccessMessages.addedEmployer);
        }
    }

    @Override
    public Result deleteJobAdvertisement(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.delete(jobAdvertisement);
        return new SuccessResult(true, SuccessMessages.deletedJobAdvertisement);
    }
}
