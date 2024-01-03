package com.AluraHotel.controlador;

import com.AluraHotel.dao.HuespedDao;
import com.AluraHotel.entity.HuespedEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class HuespedControlador {

    private HuespedDao huespedDao = new HuespedDao();
    private EntityManager em = UtilEntity.getEntityManager();


    public void guardar(HuespedEntity huespedes) {
        this.huespedDao.guardar(huespedes);
    }

    public List<HuespedEntity> cargarHuespedes() {
        return huespedDao.listarHuespedes();
    }

    public List<HuespedEntity> buscarByApellido(String nApellido) {
            return huespedDao.consultarPorApellido(nApellido);
    }

    public void EliminarHuespedById(Integer id) {
        this.huespedDao.eliminar(id);
    }

    public void editarTablaHuesped(Integer id_huesped, String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad,  String telefono,  Integer id_reserva) {
        this.huespedDao.editar(id_huesped, nombre, apellido,fechaNacimiento,nacionalidad,telefono, id_reserva);
    }
}
