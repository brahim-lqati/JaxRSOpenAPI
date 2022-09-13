package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.dao.generic.EntityManagerHelper;
import fr.istic.taa.jaxrs.dao.generic.IGenericDao;
import fr.istic.taa.jaxrs.domain.Speciality;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Objects;

public class SpecialityDao extends AbstractJpaDao<Long, Speciality>implements IGenericDao<Long, Speciality> {
    private EntityManager entityManager;
    public SpecialityDao() {
        super(Speciality.class);
        this.entityManager = EntityManagerHelper.getEntityManager();
    }

    public Speciality getByName(String name) {
        Objects.nonNull(name);
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Speciality> criteriaQuery = builder.createQuery(Speciality.class);
        Root<Speciality> root = criteriaQuery.from(Speciality.class);

        criteriaQuery.where(
                builder.equal(root.get("name"), name)
        );

        return entityManager.createQuery(criteriaQuery).getResultList().get(0);
    }
}
