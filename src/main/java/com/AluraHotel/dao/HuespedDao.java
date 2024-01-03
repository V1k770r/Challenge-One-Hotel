package com.AluraHotel.dao;

import com.AluraHotel.entity.HuespedEntity;
import com.AluraHotel.entity.ReservasEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class HuespedDao {

    private EntityManager em = UtilEntity.getEntityManager();

    public HuespedDao() {
    }


    public HuespedDao(EntityManager em) {
        this.em = em;
    }

    public void guardar(HuespedEntity huesped) {
        this.em.getTransaction().begin();
        this.em.merge(huesped);
        this.em.getTransaction().commit();
    }

    public List<HuespedEntity> listarHuespedes() {
        List<HuespedEntity> huespedes = em.createQuery
                ("SELECT e FROM HuespedEntity e", HuespedEntity.class).getResultList();
        return huespedes;
    }

    public List<HuespedEntity> consultarPorApellido(String nApellido) {
            String jpql = "SELECT P FROM HuespedEntity AS P WHERE P.apellido =: apellido";
            return em.createQuery(jpql, HuespedEntity.class).setParameter("apellido", nApellido).getResultList();
    }

    public List<HuespedEntity> buscar() {
        List<HuespedEntity> huespedes = em.createQuery
                ("SELECT e FROM ReservasEntity e", HuespedEntity.class).getResultList();
        return huespedes;
        }

    public void eliminar(Integer id) {
        HuespedEntity huesped =  em.find(HuespedEntity.class, id);
        em.getTransaction().begin();
        em.remove(huesped);
        em.getTransaction().commit();
    }

    public void editar(Integer id_huesped, String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad,  String telefono, Integer id_reserva) {
        HuespedEntity huespedes = em.find(HuespedEntity.class, id_huesped);

        huespedes.setNombre(nombre);
        huespedes.setApellido(apellido);
        huespedes.setFechaDeNacimiento(fechaNacimiento);
        huespedes.setNacionalidad(nacionalidad);
        huespedes.setTelefono(telefono);
        huespedes.getReservas().setId_reserva(id_reserva);

        em.getTransaction().begin();
        em.merge(huespedes);
        System.out.println(huespedes.toString());
        em.getTransaction().commit();

    }
}