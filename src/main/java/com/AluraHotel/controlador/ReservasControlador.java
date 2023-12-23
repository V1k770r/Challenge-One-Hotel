package com.AluraHotel.controlador;

import com.AluraHotel.dao.ReservasDao;
import com.AluraHotel.entity.ReservasEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;


public class ReservasControlador implements Serializable {

    private ReservasDao reservasDao;
    private EntityManager em;


    public ReservasControlador(ReservasDao reservasDao, EntityManager em) {
        this.reservasDao = reservasDao;
        this.em = em;
    }

    public ReservasControlador (){
        em = UtilEntity.getEntityManager();
    }


    public void guardar (ReservasEntity reservasEntity){
        this.reservasDao.guardar(reservasEntity);
    }





}
