package fr.istic.taa.jaxrs.dto;

import lombok.Data;

@Data
public class AddDoctorDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String num_doctor;
    private String phone;
    private Long visit_price;
    private String name_speciality;
}
