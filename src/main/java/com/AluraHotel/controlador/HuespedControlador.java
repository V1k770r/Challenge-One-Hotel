package com.AluraHotel.controlador;

import com.AluraHotel.dao.HuespedDao;
import com.AluraHotel.dao.ReservasDao;
import com.AluraHotel.entity.HuespedEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class HuespedControlador {

    private HuespedDao huespedDao = new HuespedDao();
    private EntityManager em = UtilEntity.getEntityManager();

    public void guardar(HuespedEntity huesped) {
        this.huespedDao.guardar(huesped);
    }

    public List<HuespedEntity> cargarHuespedes() {
        return huespedDao.listarHuespedes();
    }

    public List<HuespedEntity> buscarByApellido(String nApellido) {
            return huespedDao.consultarPorApellido(nApellido);
    }





}
