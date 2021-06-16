package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForJobSeekerDto {

    private String email;
    private String password;
    private boolean emailConfirm;
    private String name;
    private String surname;
    private String nationalId;
    private LocalDate yearOfBirth;

}
