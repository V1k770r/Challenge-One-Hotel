package com.AluraHotel.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="huespedes")
@Getter
@Setter
@NoArgsConstructor
public class HuespedEntity {

    @Id
    @Column(name = "id_huesped", nullable = false, length = 15)
    private Integer id_huesped;

    @Column(nullable = false, length = 30, unique = true)
    private String nombre;

    @Column(nullable = false, length = 30, unique = true)
    private String apellido;

    @Column(name="fecha_de_nacimiento", nullable = false, columnDefinition = "DATE")
    private LocalDate fechaDeNacimiento;

    @Column(nullable = false, length = 40)
    private String nacionalidad;

    @Column(name="telefono", nullable = false, length = 15)
    private String telefono;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva", insertable = false, updatable = false)
    private ReservasEntity reservas;

    public HuespedEntity(String nombre, String apellido, LocalDate fechaDeNacimiento,
                         String nacionalidad, String telefono, Integer id_huesped) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.id_huesped = id_huesped;
    }

    public HuespedEntity(Integer id_huesped, String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad, String telefono, ReservasEntity reservas) {
        this.id_huesped = id_huesped;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "HuespedEntity{" +
                "id_huesped=" + id_huesped +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", reservas=" + reservas +
                '}';
    }
}

