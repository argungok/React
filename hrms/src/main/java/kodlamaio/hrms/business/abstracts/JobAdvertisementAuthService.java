package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementAuthService {

    Result authJobAdvertisement(JobAdvertisement jobAdvertisement);

}
