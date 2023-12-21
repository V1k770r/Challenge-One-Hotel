package com.AluraHotel.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.ConnectionEvent;
import javax.sql.DataSource;
import java.sql.Connection;

public class ConexionBase {

    public DataSource dataSou;

    public ConexionBase(){
        ComboPooledDataSource comboPool = new ComboPooledDataSource();
        comboPool.setJdbcUrl();
        comboPool.setUser();
        comboPool.setPassword();

        this.dataSou = comboPool;

    }

    public Connection conectarBase(){
        try(){

        }catch (Exception e){

        }



    }



}
