package com.AluraHotel.dao;

import com.AluraHotel.entity.ReservasEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;

public class ReservasDao {

    EntityManager em;

    public ReservasDao(EntityManager em) {
        UtilEntity.getEntityManager();
        this.em = em;
    }

    public void guardar(ReservasEntity reservas){
        em.getTransaction().begin();
        this.em.persist(reservas);
        em.getTransaction().commit();

    }












}
