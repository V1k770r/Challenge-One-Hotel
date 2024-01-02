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

    public void editar(Integer id, String valor2, String valor3, String valor4, String valor5, String valor6, Integer valor7) {
        HuespedEntity huespedToUpdate = em.find(HuespedEntity.class, id);
        ReservasEntity reservas = new ReservasEntity();

        huespedToUpdate.setId_huesped(id);
        huespedToUpdate.setNombre(valor2);
        huespedToUpdate.setApellido(valor3);
        huespedToUpdate.setFechaDeNacimiento(LocalDate.parse(valor4));
        huespedToUpdate.setNacionalidad(valor5);
        huespedToUpdate.setTelefono(valor6);
        huespedToUpdate.getReservas().setId_reserva(valor7);


        em.getTransaction().begin();
        em.merge(huespedToUpdate);
        em.getTransaction().commit();

    }
}