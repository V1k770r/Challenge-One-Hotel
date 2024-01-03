package com.AluraHotel.controlador;

import com.AluraHotel.dao.HuespedDao;
import com.AluraHotel.dao.ReservasDao;
import com.AluraHotel.entity.HuespedEntity;
import com.AluraHotel.entity.ReservasEntity;
import com.AluraHotel.util.UtilEntity;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.net.Inet4Address;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class ReservasControlador{

    private ReservasDao reservasDao = new ReservasDao();


    public void guardar (ReservasEntity reservas){
        this.reservasDao.guardar(reservas);
    }

    public List<ReservasEntity> cargarReservas(){
        return reservasDao.listarReservas();
    }

    public List<ReservasEntity> buscarById ( Integer nReservas){
            return Collections.singletonList(reservasDao.getById( nReservas));
    }

    public void eliminarRowbyId( Integer id ){
        this.reservasDao.eliminar( id);
    }

    public List<ReservasEntity> buscar() {
                return this.reservasDao.buscar();
    }

    public void editarTablaReserva(LocalDate fechaE, LocalDate fechaS, String valor, String formaPago, Integer id) {
        this.reservasDao.editar(fechaE, fechaS, valor, formaPago,id);
    }
}
