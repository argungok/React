package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.core.logger.Logger;
import kodlamaio.hrms.core.utilities.messages.ErrorMessages;
import kodlamaio.hrms.core.utilities.messages.SuccessMessages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.services.hrmsService.HrmsCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerAuthService;

@Service
public class EmployerAuthManager implements EmployerAuthService {
	
    private Logger logger;
    private HrmsCheckService hrmsCheckService;
    private UserDao userDao;

    @Autowired
    public EmployerAuthManager(Logger logger, HrmsCheckService hrmsCheckService, UserDao userDao) {
        this.logger = logger;
        this.hrmsCheckService = hrmsCheckService;
        this.userDao = userDao;
    }

    @Override
    public Result addEmployerAuth(Employer employer) {
        if(employer.getCompanyName() == null || employer.getWebAddress() == null ||
                employer.getTelephoneNumber() == null || employer.getEmail() == null ||
                employer.getPassword() == null){
            return new ErrorResult(false, ErrorMessages.nullRegisterForm);
        }

        if(!hrmsCheckService.checkIfHrmsUser(employer.getEmail(), employer.getPassword())){
            return new ErrorResult(false, ErrorMessages.invalidUser);
        }

        if(userDao.existsByEmail(employer.getEmail())){
            return new ErrorResult(false, ErrorMessages.usedEmail);
        }

        Result resultMail = logger.log(SuccessMessages.logEmail);

        if(!resultMail.isSuccess()){
            return new ErrorResult(false, ErrorMessages.notValidateMail);
        }

        return new SuccessResult(true);
    }
	
}
