package com.AluraHotel.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="huespedes")
@Getter
@Setter
@NoArgsConstructor
public class HuespedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id_huesped", nullable = false, length = 15)
    private int id;

    @Column(name = "id_reserva", nullable = false)
    private Integer id_reserva;

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

    @OneToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva", insertable = false, updatable = false)
    private ReservasEntity reservasEntity;


    public HuespedEntity(String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad, String telefono, Integer id_reserva) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.id_reserva = id_reserva;
    }

    public HuespedEntity(int id, Integer id_reserva, String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad, String telefono, ReservasEntity reservasEntity) {
        this.id = id;
        this.id_reserva = id_reserva;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.reservasEntity = reservasEntity;
    }

    @Override
    public String toString() {
        return "HuespedEntity{" +
                "id='" + id + '\'' +
                ", id_reserva=" + id_reserva +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}

