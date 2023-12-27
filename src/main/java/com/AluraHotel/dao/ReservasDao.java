package com.AluraHotel.dao;

import com.AluraHotel.entity.ReservasEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;
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

    public List<ReservasEntity> listarReservas( ){
        try{
            List<ReservasEntity>  reservas = em.createQuery("SELECT e FROM ReservasEntity e", ReservasEntity.class).getResultList();
            return reservas;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }



}
