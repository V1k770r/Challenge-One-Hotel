package com.AluraHotel.dao;

import com.AluraHotel.entity.HuespedEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Queue;

public class HuespedDao {

    private EntityManager em = UtilEntity.getEntityManager();

    public HuespedDao() {
    }


    public HuespedDao(EntityManager em) {
        this.em = em;
    }

    public void guardar(HuespedEntity huesped) {
        this.em.getTransaction().begin();
        this.em.merge(huesped);
        this.em.getTransaction().commit();
    }

    public List<HuespedEntity> listarHuespedes() {
        List<HuespedEntity> huespedes = em.createQuery
                ("SELECT e FROM HuespedEntity e", HuespedEntity.class).getResultList();
        return huespedes;
    }

    public List<HuespedEntity> consultarPorApellido(String nApellido) {
            String jpql = "SELECT P FROM HuespedEntity AS P WHERE P.apellido =: apellido";
            return em.createQuery(jpql, HuespedEntity.class).setParameter("apellido", nApellido).getResultList();
    }

}