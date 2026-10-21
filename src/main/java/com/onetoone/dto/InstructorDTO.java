package com.onetoone.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InstructorDTO {
    private Integer id;
    @NotBlank(message = "{InstructorDTO.firstName}")
    private String firstName;
    @NotBlank(message = "{InstructorDTO.lastName}")
    private String lastName;
    @Email(message = "{InstructorDTO.email.invalid}")
    @NotBlank(message = "{InstructorDTO.email.blank}")
    private String email;
    @Valid
    private InstructorDetailDTO instructorDetail;

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public InstructorDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
