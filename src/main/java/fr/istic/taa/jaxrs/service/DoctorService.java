package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.dao.DoctorDao;
import fr.istic.taa.jaxrs.dao.SpecialityDao;
import fr.istic.taa.jaxrs.domain.Doctor;
import fr.istic.taa.jaxrs.domain.Speciality;
import fr.istic.taa.jaxrs.dto.AddDoctorDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.print.Doc;
import javax.ws.rs.NotFoundException;
import java.util.*;

public class DoctorService {
    private DoctorDao doctorDao;
    private SpecialityDao specialityDao;

    public DoctorService() {
        this.doctorDao = new DoctorDao();
        this.specialityDao = new SpecialityDao();
    }

    public Doctor addDoctor(AddDoctorDTO doctorDTO) {
        Objects.nonNull(doctorDTO);
        Doctor doctor = new Doctor();
        doctor.setFirstName(doctorDTO.getFirstName());
        doctor.setLastName(doctorDTO.getLastName());
        doctor.setPhone(doctorDTO.getPhone());
        doctor.setNum_doctor(doctorDTO.getNum_doctor());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setAddress(doctorDTO.getAddress());
        doctor.setVisit_price(doctorDTO.getVisit_price());

        // get speciality
        Speciality speciality = specialityDao.getByName(doctorDTO.getName_speciality());
        if (speciality != null) {
            doctor.getSpecialities().add(speciality);
        }
        doctorDao.save(doctor);

        return doctor;
    }

    public List<Doctor> getAllDoctors() {
        return doctorDao.findAll();
    }

    public void deleteDoctor(Long id) {
        Objects.nonNull(id);
        doctorDao.deleteById(id);
    }

    public Doctor findDoctorById(Long id) {
        Objects.nonNull(id);
        Doctor doctor = doctorDao.findOne(id);
        if (doctor == null) {
            throw new NotFoundException();
        }
        return doctor;
    }
}
