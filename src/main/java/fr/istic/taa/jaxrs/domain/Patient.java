package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@NamedQuery(name = "findAll", query = "select p from Patient p")
public class Patient extends User {
    @Column(unique = true)
    private String numSecu;
    private LocalDate birthday;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Collection<Rdv> rdvs = new ArrayList<>();
}
