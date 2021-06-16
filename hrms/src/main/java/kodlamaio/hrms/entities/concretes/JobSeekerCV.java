package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_seeker_cv")
public class JobSeekerCV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne()
    @JoinColumn(name = "experience_id")
    private Experience experience;

    @ManyToOne()
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @Column(name = "github_link")
    private String gitHub;

    @Column(name = "linkedin_link")
    private String linkedIn;

    @Column(name = "know_technologies")
    private String knowTechnologies;

    @Column(name = "about_me")
    private String aboutMe;

}
