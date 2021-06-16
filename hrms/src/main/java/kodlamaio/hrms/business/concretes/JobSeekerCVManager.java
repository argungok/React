package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.adapters.abstracts.CloudinaryAdapterService;
import kodlamaio.hrms.business.abstracts.JobSeekerCVService;
import kodlamaio.hrms.core.utilities.messages.SuccessMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCVDao;
import kodlamaio.hrms.entities.concretes.JobSeekerCV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class JobSeekerCVManager implements JobSeekerCVService {

    private JobSeekerCVDao jobSeekerCVDao;
    private CloudinaryAdapterService cloudinaryAdapterService;

    @Autowired
    public JobSeekerCVManager(JobSeekerCVDao jobSeekerCVDao ,CloudinaryAdapterService cloudinaryAdapterService) {
        this.jobSeekerCVDao = jobSeekerCVDao;
        this.cloudinaryAdapterService = cloudinaryAdapterService;
    }

    @Override
    public DataResult<List<JobSeekerCV>> getAll() {
        return new SuccessDataResult<List<JobSeekerCV>>(this.jobSeekerCVDao.findAll(), SuccessMessages.getCVsList);
    }

    @Override
    public DataResult<JobSeekerCV> findById(int id) {
        return new SuccessDataResult<JobSeekerCV>(this.jobSeekerCVDao.findById(id), SuccessMessages.findCvById);
    }

    @Override
    public Result uploadPhoto(MultipartFile file, int cvId) {
        Map<String, String> uploader = (Map<String, String>)
                cloudinaryAdapterService.uploadPhoto(file).getData();
        String imageUrl= uploader.get("url");
        JobSeekerCV jobSeekerCV = jobSeekerCVDao.getOne(cvId);
        jobSeekerCV.setProfilePhoto(imageUrl);
        jobSeekerCVDao.save(jobSeekerCV);
        return new SuccessResult(SuccessMessages.addedProfilePhoto);
    }

    @Override
    public Result add(JobSeekerCV jobSeekerCV) {
        this.jobSeekerCVDao.save(jobSeekerCV);
        return new SuccessResult(true, SuccessMessages.addedCV);
    }

}
