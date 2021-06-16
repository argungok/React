package kodlamaio.hrms.core.logger;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailLogger implements Logger {
	
    @Override
    public Result log(String message) {
        return new SuccessResult("Lütfen linke tıklayarak E-Posta adresinizi doğrulayın");
    }
	
}
