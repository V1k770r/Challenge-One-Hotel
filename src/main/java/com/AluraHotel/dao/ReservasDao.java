package com.AluraHotel.dao;

import com.AluraHotel.entity.ReservasEntity;
import com.AluraHotel.util.UtilEntity;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class ReservasDao {

    private EntityManager em = UtilEntity.getEntityManager();

    public ReservasDao(){
        }

    public ReservasDao(EntityManager em) {
        this.em = em;
    }

    public void guardar(ReservasEntity reservas){
        this.em.getTransaction().begin();
        this.em.merge(reservas);
        this.em.getTransaction().commit();
    }

    public List<ReservasEntity> listarReservas(){
            List<ReservasEntity> reservas = em.createQuery
                    ("SELECT e FROM ReservasEntity e", ReservasEntity.class).getResultList();
           return reservas;
    }

    public ReservasEntity getById( Integer nReservas){
        ReservasEntity reservas;
        reservas = em.find(ReservasEntity.class, nReservas);
        return  reservas;
    }

    public void eliminar(Integer id){
        ReservasEntity reservas =  em.find(ReservasEntity.class, id);
        em.getTransaction().begin();
        em.remove(reservas);
        em.getTransaction().commit();
    }

    public List<ReservasEntity> buscar() {
            List<ReservasEntity> reservas = em.createQuery
                    ("SELECT e FROM ReservasEntity e", ReservasEntity.class).getResultList();
            return reservas;
        }

    public void editar(LocalDate  fechaE, LocalDate fechaS, String valor, String formaPago, Integer id) {
            ReservasEntity reservas = em.find(ReservasEntity.class, id);

        reservas.setId_reserva(id);
        reservas.setFechaE(fechaE);
        reservas.setFechaS(fechaS);
        reservas.setValor(valor);
        reservas.setFormaDePago(formaPago);

        em.getTransaction().begin();
        em.merge(reservas);
        System.out.println(reservas.toString());
        em.getTransaction().commit();

        }
}
