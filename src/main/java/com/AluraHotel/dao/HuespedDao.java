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

    public void editar(Integer id, String valor2, String valor3, String valor4, String valor5, String valor6,
                       Integer valor7) {
        HuespedEntity huespedes = em.find(HuespedEntity.class, id);

        huespedes.setId_huesped(id);
        huespedes.setNombre(valor2);
        huespedes.setApellido(valor3);
        huespedes.setFechaDeNacimiento(LocalDate.parse(valor4));
        huespedes.setNacionalidad(valor5);
        huespedes.setTelefono(valor6);
        huespedes.getReservas().setId_reserva(valor7);


        em.getTransaction().begin();
        em.merge(huespedes);
        em.getTransaction().commit();

    }
}