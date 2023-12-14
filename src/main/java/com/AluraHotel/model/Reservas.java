package com.AluraHotel.model;

public class Reservas {

    private int id;
    private String fechaDeEntrada;
    private String fechaDeSalida;
    private Float valor;
    private String formaDePago;

    public Reservas() {
    }

    public Reservas(int id, String fechaDeEntrada, String fechaDeSalida, Float valor, String formaDePago) {
        this.id = id;
        this.fechaDeEntrada = fechaDeEntrada;
        this.fechaDeSalida = fechaDeSalida;
        this.valor = valor;
        this.formaDePago = formaDePago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaDeEntrada() {
        return fechaDeEntrada;
    }

    public void setFechaDeEntrada(String fechaDeEntrada) {
        this.fechaDeEntrada = fechaDeEntrada;
    }

    public String getFechaDeSalida() {
        return fechaDeSalida;
    }

    public void setFechaDeSalida(String fechaDeSalida) {
        this.fechaDeSalida = fechaDeSalida;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

}
