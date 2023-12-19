package com.AluraHotel.main;

import com.AluraHotel.entity.HuespedEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        EntityManager em = UtilEntity.getEntityManager();
//        List<HuespedEntity> huespedes = em.createQuery("SELECT e FROM HuespedEntity e",
//             HuespedEntity.class).getResultList();
//        System.out.println("-------Listar TODOS---------");
//        huespedes.forEach(System.out::println);


//        System.out.println("----CREAR UNO-------");
//
//        HuespedEntity newHuesped = new HuespedEntity();
//        newHuesped.setId("456789998");
//        newHuesped.setNombre("Karla2");
//        newHuesped.setApellido("Perez2");
//        newHuesped.setNacionalidad("Uruguaya");
//        newHuesped.setFechaDeNacimiento(new Date(86, Calendar.FEBRUARY,10));
//        newHuesped.setTelefono("1111111");
//
//        em.getTransaction().begin();
//        em.persist(newHuesped);
//        em.getTransaction().commit();
//
//        System.out.println("Nuevo empleado creado:" + newHuesped);



       /*
        System.out.println("-----BUSCAR UNO-----------");
        int employeeId = 1;
        Employee employee = em.find(Employee.class, employeeId);
        System.out.println("Empleado encontrado" + employee);*/



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
