package tn.zeros.template.controllers.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.zeros.template.entities.Adress;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistrationDTO {
    String code;
    String email;
    String password;
    String firstName;
    String lastName;
    String phoneNumber;
    String mf;
    String ville;
    Adress adress;
}
