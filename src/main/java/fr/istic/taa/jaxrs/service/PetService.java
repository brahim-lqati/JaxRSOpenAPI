package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.dao.PetDao;
import fr.istic.taa.jaxrs.domain.Pet;

import java.util.Collections;
import java.util.List;

public class PetService {
   private PetDao petDao;
    public PetService() {
      this.petDao = new PetDao();
    }

    public List<Pet> getAll() {
       // return petDaoImp.findAll();
        return Collections.emptyList();
    }
}
