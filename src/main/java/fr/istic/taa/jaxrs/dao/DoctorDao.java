package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.dao.generic.IGenericDao;
import fr.istic.taa.jaxrs.domain.Doctor;

public class DoctorDao extends AbstractJpaDao<Long, Doctor> implements IGenericDao<Long, Doctor> {
    public DoctorDao() {
        super(Doctor.class);
    }
}
