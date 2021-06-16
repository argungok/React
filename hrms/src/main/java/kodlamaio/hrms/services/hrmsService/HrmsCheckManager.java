package kodlamaio.hrms.services.hrmsService;

import org.springframework.stereotype.Service;

@Service
public class HrmsCheckManager implements HrmsCheckService {

    @Override
    public boolean checkIfHrmsUser(String eMail, String password) {
        return true;
    }

}
