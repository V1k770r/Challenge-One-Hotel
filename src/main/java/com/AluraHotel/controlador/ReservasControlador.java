package com.AluraHotel.controlador;

import com.AluraHotel.dao.ReservasDao;
import com.AluraHotel.entity.ReservasEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;


public class ReservasControlador{

    private ReservasDao reservasDao = new ReservasDao();


    public void guardar (ReservasEntity reservasEntity){
        this.reservasDao.guardar(reservasEntity);
    }





}
