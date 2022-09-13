package fr.istic.taa.jaxrs.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Doctor extends User implements Serializable {
    @Column(unique = true)
    private String num_doctor;
    private String phone;
    private Long visit_price;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<Rdv> rdvs = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Set<Speciality> specialities = new HashSet<>();
}
