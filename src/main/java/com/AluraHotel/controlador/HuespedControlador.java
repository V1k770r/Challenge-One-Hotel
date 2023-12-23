package com.AluraHotel.controlador;

import com.AluraHotel.dao.HuespedDao;
import com.AluraHotel.dao.ReservasDao;
import com.AluraHotel.entity.HuespedEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;

public class HuespedControlador {

    private HuespedDao huespedDao = new HuespedDao();
    private EntityManager em = UtilEntity.getEntityManager();

    public void guardar(HuespedEntity huesped) {
        this.huespedDao.guardar(huesped);
    }
}
