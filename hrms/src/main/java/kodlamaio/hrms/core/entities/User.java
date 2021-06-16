package kodlamaio.hrms.core.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    @Email(message = "E-Posta adresiniz doğru formatta değil")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "email_confirm")
    private boolean emailConfirm;

}
