package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForEmployerDto {

    private String email;
    private String password;
    private boolean emailConfirm;
    private String companyName;
    private String webAddress;
    private String telephoneNumber;

}
