package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getAllSorted();
    DataResult<List<JobAdvertisement>> getAllByEmployer(String companyName);
    Result add(JobAdvertisement jobAdvertisement);

}
