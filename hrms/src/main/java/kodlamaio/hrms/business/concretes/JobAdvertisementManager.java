package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementAuthService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.messages.SuccessMessages;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;
    private JobAdvertisementAuthService jobAdvertisementAuthService;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, JobAdvertisementAuthService jobAdvertisementAuthService) {
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.jobAdvertisementAuthService = jobAdvertisementAuthService;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<>(this.jobAdvertisementDao.findAll(), SuccessMessages.getJobAdvertisementsList);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.ASC, "publishedAt");

        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort), SuccessMessages.getJobAdvertisementsList);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByEmployer(String companyName) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_CompanyName(companyName));
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        Result result = jobAdvertisementAuthService.authJobAdvertisement(jobAdvertisement);

        if(!result.isSuccess()){
            return new ErrorResult(false, jobAdvertisementAuthService.authJobAdvertisement(jobAdvertisement).getMessage());
        }
        else{
            this.jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult(true, SuccessMessages.addedJobAdvertisement);
        }
    }

}
