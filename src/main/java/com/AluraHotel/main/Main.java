package com.AluraHotel.main;

import com.AluraHotel.controlador.ReservasControlador;
import com.AluraHotel.dao.ReservasDao;
import com.AluraHotel.entity.HuespedEntity;
import com.AluraHotel.entity.ReservasEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//            EntityManager em = UtilEntity.getEntityManager();
//
//
//        ReservasControlador qwe = new ReservasControlador();
//        qwe.cargarReservas();



//        List<HuespedEntity> huespedes = em.createQuery("SELECT e FROM HuespedEntity e",
//             HuespedEntity.class).getResultList();
//        System.out.println("-------Listar TODOS---------");
    //        huespedes.forEach(System.out::println);

//        List<ReservasEntity> reservas = em.createQuery("SELECT e FROM ReservasEntity e",
//                ReservasEntity.class).getResultList();
//        System.out.println("-------Listar TODOS---------");
//        reservas.forEach(System.out::println);


//        System.out.println("----CREAR UNO-------");
//
//        HuespedEntity newHuesped = new HuespedEntity();
//        newHuesped.setId("2222222222");
//        newHuesped.setNombre("Jimena");
//        newHuesped.setApellido("Correa");
//        newHuesped.setNacionalidad("Mexicana");
//        newHuesped.setFechaDeNacimiento(new Date(89, Calendar.APRIL,10));
//        newHuesped.setTelefono("45789623");
//
//        em.getTransaction().begin();
//        em.merge(newHuesped);
//        em.getTransaction().commit();
//
//        System.out.println("Nuevo empleado creado:" + newHuesped);



//        System.out.println("crear una reserva");
//        ReservasEntity reservas = new ReservasEntity();
//
//        reservas.setFechaE(LocalDate.of(2000, 6, 2));
//        reservas.setFechaS(LocalDate.of(2000, 5, 5));
//        reservas.setValor("700");
//        reservas.setFormaDePago("Pago en efectivo");
//
//        em.getTransaction().begin();
//        em.merge(reservas); // al haber varias tablas usar merge en vez de persist
//        em.getTransaction().commit();
//
//        System.out.println("Nueva reserva creada:" + reservas);


//        System.out.println("-----BUSCAR UNO-----------");
//        String apellidoo = "bellido";
//        HuespedEntity huespedes = new HuespedEntity();
//       String jpql =  "SELECT P FROM HuespedEntity P WHERE P.apellido =: apellido";
//       var q =  em.createQuery(jpql, HuespedEntity.class).setParameter("apellido",apellidoo).getResultList();
//        System.out.println(q);



        /*System.out.println("----ACTUALIZAR------");
        int employeeToUpdateId = 2;
        Employee employeeToUpdate = em.find(Employee.class, employeeToUpdateId);
        System.out.println("Empleado a modificar" + employeeToUpdate);

        employeeToUpdate.setFirstName("Irving");
        employeeToUpdate.setPaSurname("Juarez");
        employeeToUpdate.setSalary(97000F);

        em.getTransaction().begin();
        em.merge(employeeToUpdate);
        em.getTransaction().commit();

        System.out.println("Empleado actualizado" + employeeToUpdate);*/

        /*System.out.println("----ELIMINAR-----");
        int employeeToDeleteId = 1;
        Employee employeeToDelete = em.find(Employee.class, employeeToDeleteId);
        System.out.println("Empleado a eliminar" + employeeToDelete);

        em.getTransaction().begin();
        em.remove(employeeToDelete);
        em.getTransaction().commit();
        em.close();*/





    }
}
