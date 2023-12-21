package com.AluraHotel.dao;

import com.AluraHotel.entity.ReservasEntity;
import com.AluraHotel.util.UtilEntity;

import javax.persistence.EntityManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ReservaDao {

     private EntityManager em = UtilEntity.getEntityManager();


     public void guardar (ReservasEntity reservas){
        try(){
            String sql = "INSERT INTO reservas (fecha_de_entrada, fecha_de_salida,valor,forma_de_pago)"
                            +  "VALUES (?,?,?,?)";

            try (PreparedStatement pstm = em.preparedStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            }


        }


     }









}
