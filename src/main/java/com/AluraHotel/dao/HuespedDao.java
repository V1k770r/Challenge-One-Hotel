package com.AluraHotel.dao;

import com.AluraHotel.entity.HuespedEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class HuespedDao {
    private EntityManager em = UtilEntity.getEntityManager();

    public HuespedDao(){
    }
    public HuespedDao(EntityManager em) {
        this.em = em;
    }

    public void guardar(HuespedEntity huesped){
        this.em.getTransaction().begin();
        this.em.merge(huesped);
        this.em.getTransaction().commit();
    }

    public List<HuespedEntity> listarHuespedes() {
        List<HuespedEntity> huespedes = em.createQuery
                ("SELECT e FROM HuespedEntity e", HuespedEntity.class).getResultList();
        return huespedes;

    }

//    public static void main(String[] args) {
//        HuespedDao hdao = new HuespedDao();
//        Huesped huesped = new Huesped();
//        huesped.setId("222222");
//        huesped.setNombre("Camila");
//        huesped.setApellido("Gomez");
//        huesped.setNacionalidad("Argentinca");
//        huesped.setFechaDeNacimiento(new Date(91, Calendar.APRIL,6));
//        huesped.setTelefono("333333");
//        hdao.insertarHuesped(huesped);
//    }



}
