package com.AluraHotel.controlador;

import com.AluraHotel.dao.ReservasDao;
import com.AluraHotel.entity.ReservasEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;


public class ReservasControlador{

    private ReservasDao reservasDao = new ReservasDao();
    private EntityManager em = UtilEntity.getEntityManager();

    public void guardar (ReservasEntity reservas){
        this.reservasDao.guardar(reservas);
    }





}
