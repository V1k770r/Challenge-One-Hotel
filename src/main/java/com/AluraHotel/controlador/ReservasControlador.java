package com.AluraHotel.controlador;

import com.AluraHotel.dao.HuespedDao;
import com.AluraHotel.dao.ReservasDao;
import com.AluraHotel.entity.HuespedEntity;
import com.AluraHotel.entity.ReservasEntity;
import com.AluraHotel.util.UtilEntity;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ReservasControlador{

    private ReservasDao reservasDao = new ReservasDao();
    private EntityManager em = UtilEntity.getEntityManager();
    private ReservasEntity reservas;


    public void guardar (ReservasEntity reservas){
        this.reservasDao.guardar(reservas);
    }

    public List<ReservasEntity> cargarReservas(){
        return reservasDao.listarReservas();
    }

    public List<ReservasEntity> buscarById (ReservasEntity reservas, Integer nReservas){
            return Collections.singletonList(reservasDao.getById(reservas, nReservas));
    }

}
