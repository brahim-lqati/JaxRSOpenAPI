package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.dao.generic.IGenericDao;
import fr.istic.taa.jaxrs.domain.Pet;


public class PetDao extends AbstractJpaDao<Long, Pet> implements IGenericDao<Long, Pet> {

    public PetDao(){
        super(Pet.class);
    }
}
