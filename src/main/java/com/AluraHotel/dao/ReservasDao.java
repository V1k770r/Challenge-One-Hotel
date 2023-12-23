package com.AluraHotel.dao;

import com.AluraHotel.entity.ReservasEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;

public class ReservasDao {

    private EntityManager em = UtilEntity.getEntityManager();

    public ReservasDao(){
        }

    public ReservasDao(EntityManager em) {
        this.em = em;
    }

    public void guardar(ReservasEntity reservas){
        this.em.getTransaction().begin();
        this.em.merge(reservas);
        this.em.getTransaction().commit();
}












}
