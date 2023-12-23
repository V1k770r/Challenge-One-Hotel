package com.AluraHotel.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="huespedes")
@Getter
@Setter
@NoArgsConstructor
public class HuespedEntity {

    @Id
    @Column(name = "id_huesped", nullable = false, length = 15)
    private String id;

    @Column(name = "id_reserva", nullable = false)
    private String id_reserva;

    @Column(nullable = false, length = 30, unique = true)
    private String nombre;

    @Column(nullable = false, length = 30, unique = true)
    private String apellido;

    @Column(name="fecha_de_nacimiento", nullable = false, columnDefinition = "DATE")
    private Date fechaDeNacimiento;

    @Column(nullable = false, length = 40)
    private String nacionalidad;

    @Column(name="telefono", nullable = false, length = 15)
    private String telefono;

    @OneToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva", insertable = false, updatable = false)
    private ReservasEntity reservasEntity;


    @Override
    public String toString() {
        return "HuespedEntity{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}

