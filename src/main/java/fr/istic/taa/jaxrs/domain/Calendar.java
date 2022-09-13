package fr.istic.taa.jaxrs.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Calendar {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String days;
    private Date startHour;
    private Date endHour;
    private short timeOfConsultation;

}
