package VetHome.com.veterinaria.DTO;


import VetHome.com.veterinaria.entity.Pet;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDTO {


    @Column
    @NotBlank(message = "Name cant be null")
    private String name;
    @Column
    @NotBlank(message = "LastName cant be null")
    private String lastName;
    @Column
    @NotBlank(message = "Address cant be null")
    private String address;
    @Column
    @Email(message = "Email must be valid")
    @NotBlank(message = "Email cant be null")
    private String email;
    @Column
    @NotBlank(message = "Contactnumber cant be null")
    @Min(1)
    private String contactNumber;
    @Column
    @NotBlank(message = "Password cant be null")
    private String password;

    private Long roleId;
    @NotEmpty(message = "Pets cant be null")
    private List<Pet> pets;

}
