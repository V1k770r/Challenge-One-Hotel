package com.AluraHotel.controlador;

import com.AluraHotel.dao.ReservasDao;
import com.AluraHotel.entity.ReservasEntity;


public class ReservasControlador {

    private ReservasDao reservasDao;

    public ReservasControlador(ReservasDao reservasDao) {
        this.reservasDao = reservasDao;
    }

    public void guardar (ReservasEntity reservas){
        this.reservasDao.guardar(reservas);
    }





}
