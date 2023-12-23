package com.AluraHotel.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "reservas")
@Getter
@Setter
@NoArgsConstructor
public class ReservasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva", nullable = false)
    private Integer idReserva;

    @Column(name = "id_huesped", nullable = false, length = 15)
    private String id;

    @Column(name = "fecha_de_entrada", nullable = false, columnDefinition = "DATE")
    private LocalDate fechaE;

    @Column(name = "fecha_de_salida", nullable = false, columnDefinition = "DATE")
    private LocalDate fechaS;

    @Column(nullable = false, columnDefinition = "Decimal(5,2)")
    private String valor;

    @Column(name = "forma_de_pago", nullable = false, length = 150)
    private String formaDePago;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_huesped", referencedColumnName = "id_huesped", insertable = false, updatable = false)
    private HuespedEntity huesped;


    public ReservasEntity(LocalDate fechaE, LocalDate fechaS, String valor, String formaDePago) {
        this.fechaE = fechaE;
        this.fechaS = fechaS;
        this.valor = valor;
        this.formaDePago = formaDePago;
    }

    public ReservasEntity(Integer idReserva, LocalDate fechaE, LocalDate fechaS, String valor, String formaDePago) {
        this.idReserva = idReserva;
        this.fechaE = fechaE;
        this.fechaS = fechaS;
        this.valor = valor;
        this.formaDePago = formaDePago;
    }

    @Override
    public String toString() {
        return "ReservasEntity{" +
                "fechaE=" + fechaE +
                ", fechaS=" + fechaS +
                ", valor='" + valor + '\'' +
                ", formaDePago='" + formaDePago + '\'' +
                '}';
    }
}
