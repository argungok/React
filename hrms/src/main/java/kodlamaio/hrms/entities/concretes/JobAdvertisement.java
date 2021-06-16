package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_advertisements")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "position_id")
    @NotBlank(message = "İş Pozisyonu Zorunludur")
    @NotNull(message = "İş Pozisyonu Zorunludur")
    private JobPosition jobPosition;

    @Column(name = "description")
    @NotBlank(message = "Açıklama Zorunludur")
    @NotNull(message = "Açıklama Zorunludur")
    private String Description;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    @NotBlank(message = "Şehir Bilgisi Zorunludur")
    @NotNull(message = "Şehir Bilgisi Zorunludur")
    private City city;

    @Column(name = "min_salary")
    private double minSalary;

    @Column(name = "max_salary")
    private double maxSalary;

    @Column(name = "open_position_count")
    @NotBlank(message = "Açık Pozisyon Adedi Zorunludur")
    @NotNull(message = "Açık Pozisyon Adedi Zorunludur")
    private int openPositionCount;

    @Column(name = "published_at")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate publishedAt;

    @Column(name = "application_deadline")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate applicationDeadline;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Employer employer;

}
