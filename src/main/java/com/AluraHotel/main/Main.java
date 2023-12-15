package com.AluraHotel.main;

import com.AluraHotel.model.Huespedes;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManager em = UtilEntity.getEntityManager();
        List<Huespedes> huespedes = em.createQuery("SELECT e FROM Huespedes e", Huespedes.class).getResultList();
        System.out.println("-------Listar TODOS---------");
        huespedes.forEach(System.out::println);



    }
}
