package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.core.utilities.messages.ErrorMessages;
import kodlamaio.hrms.core.utilities.messages.SuccessMessages;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), SuccessMessages.getJobPositionsList);
    }

    @Override
    public DataResult<JobPosition> getByName(String PositionsName) {
        return new SuccessDataResult<>(this.jobPositionDao.getByPositionsName(PositionsName));
    }

    @Override
    public Result add(JobPosition jobPosition) {
        if(getByName(jobPosition.getPositionsName()).getData() != null){
            return new ErrorResult(ErrorMessages.invalidJobPositions);
        }

        this.jobPositionDao.save(jobPosition);
        return new SuccessResult(SuccessMessages.addedJobPositions);
    }
	
}
