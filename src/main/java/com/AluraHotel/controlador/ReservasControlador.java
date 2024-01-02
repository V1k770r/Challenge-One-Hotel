package com.AluraHotel.controlador;

import com.AluraHotel.dao.HuespedDao;
import com.AluraHotel.dao.ReservasDao;
import com.AluraHotel.entity.HuespedEntity;
import com.AluraHotel.entity.ReservasEntity;
import com.AluraHotel.util.UtilEntity;
import javax.persistence.EntityManager;
import java.net.Inet4Address;
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

    public void editarTablaReserva(Integer id, String valor2, String valor3, String valor4, String valor5) {
        this.reservasDao.editar(id, valor2,valor3,valor4,valor5);
    }
}
