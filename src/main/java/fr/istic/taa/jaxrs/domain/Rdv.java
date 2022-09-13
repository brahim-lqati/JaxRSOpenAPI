package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@NamedQuery(
        name = "getRdvsByDoctor",
        query = "select r from Rdv r where r.doctor = :doctor"
)
public class Rdv {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String heureRdv;
    private LocalDate dateRdv;
    private Boolean isConfirmed;

    @ManyToOne(optional = false)
    @JsonBackReference
    private Doctor doctor;

    @ManyToOne(optional = false)
    @JsonBackReference
    private Patient patient;
}
