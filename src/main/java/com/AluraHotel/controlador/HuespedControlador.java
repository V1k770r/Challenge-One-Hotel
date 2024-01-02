package com.AluraHotel.controlador;

import com.AluraHotel.dao.HuespedDao;
import com.AluraHotel.entity.HuespedEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;
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

    public void EliminarHuespedById(Integer id) {
        this.huespedDao.eliminar(id);

    }

    public List<HuespedEntity> buscarHuespedes () {
        return this.huespedDao.buscar();

    }


    public void editarTablaHuesped(Integer id, String valor2, String valor3, String valor4, String valor5, String valor6, Integer valor7) {
        this.huespedDao.editar(id, valor2,valor3,valor4,valor5,valor6,valor7);
    }
}
