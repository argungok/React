package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementAuthService;
import kodlamaio.hrms.core.utilities.messages.ErrorMessages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.stereotype.Service;

@Service
public class JobAdvertisementAuthManager implements JobAdvertisementAuthService {

    @Override
    public Result authJobAdvertisement(JobAdvertisement jobAdvertisement) {
        if(jobAdvertisement.getPublishedAt() == jobAdvertisement.getApplicationDeadline()){
            return new ErrorResult(false, ErrorMessages.falseDateTime);
        }

        if(jobAdvertisement.getPublishedAt().getYear() > jobAdvertisement.getApplicationDeadline().getYear()){
            return new ErrorResult(false, ErrorMessages.falseDate);
        }

        if(jobAdvertisement.getPublishedAt().getYear() == jobAdvertisement.getApplicationDeadline().getYear()){
            if(jobAdvertisement.getPublishedAt().getMonthValue() > jobAdvertisement.getApplicationDeadline().getMonthValue()){
                return new ErrorResult(false, ErrorMessages.falseDate);
            }
        }

        if(jobAdvertisement.getPublishedAt().getYear() == jobAdvertisement.getApplicationDeadline().getYear()){
            if(jobAdvertisement.getPublishedAt().getMonthValue() == jobAdvertisement.getApplicationDeadline().getMonthValue()){
                if(jobAdvertisement.getPublishedAt().getDayOfMonth() > jobAdvertisement.getApplicationDeadline().getDayOfMonth()){
                    return new ErrorResult(false, ErrorMessages.falseDate);
                }
            }
        }

        return new SuccessResult(true);
    }

}
