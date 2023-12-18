package com.AluraHotel.model;

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

    @Column(nullable = false, length = 30, unique = true)
    private String nombre;

    @Column(nullable = false, length = 30, unique = true)
    private String apellido;

    @Column(name="fecha_de_nacimiento", nullable = false, columnDefinition = "DATE")
    private Date fechaDeNacimiento;

    @Column(nullable = false, length = 40)
    private String nacionalidad;

    @Column(name="teléfono", nullable = false, length = 15)
    private String telefono;

}

