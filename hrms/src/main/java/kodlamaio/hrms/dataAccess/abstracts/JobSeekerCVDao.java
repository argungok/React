package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeekerCV;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerCVDao extends JpaRepository<JobSeekerCV,Integer> {

    JobSeekerCV findById(int id);

}
