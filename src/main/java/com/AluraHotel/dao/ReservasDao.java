package com.AluraHotel.dao;

import com.AluraHotel.entity.ReservasEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;

public class ReservasDao {

    private EntityManager em;

    public ReservasDao(EntityManager em) {
        this.em = em;
    }

    public void guardar(ReservasEntity reservasEntity){

        this.em.persist(reservasEntity);

}












}
