package kodlamaio.hrms.services.mernisService;

import org.springframework.stereotype.Service;

@Service
public class MernisCheckManager implements MernisCheckService {

    @Override
    public boolean checkIfRealPerson(String eMail, String password) {
        return true;
    }

}
