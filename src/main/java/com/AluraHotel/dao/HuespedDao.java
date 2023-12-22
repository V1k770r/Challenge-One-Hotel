package com.AluraHotel.dao;

import com.AluraHotel.entity.HuespedEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;

public class HuespedDao {

    public void insertarHuesped(HuespedEntity huesped){
        EntityManager em = UtilEntity.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(huesped);
            em.getTransaction().commit();
            System.out.println("Guardado correctamente");
        }catch (Exception e){
            System.out.println("Error al guardar: " + e.getMessage());
        }finally {
            if(em != null){
                em.close();
            }
        }
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
