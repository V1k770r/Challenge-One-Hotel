package com.AluraHotel.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Date;

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

    @Column(nullable = false, columnDefinition = "DATE")
    private Date fechaE;

    @Column(nullable = false, columnDefinition = "DATE")
    private Date fechaS;

    @Column(nullable = false, columnDefinition = "Decimal(5,2)")
    private String valor;

    @Column(nullable = false, length = 150)
    private String formaDePago;

    @OneToOne
    @JoinColumn(name = "id_huesped", referencedColumnName = "id_huesped", insertable = false, updatable = false)
    private HuespedEntity huesped;


    public ReservasEntity(Date fechaE, Date fechaS, String valor, String formaDePago) {
        this.fechaE = fechaE;
        this.fechaS = fechaS;
        this.valor = valor;
        this.formaDePago = formaDePago;
    }

    public ReservasEntity(Integer idReserva, Date fechaE, Date fechaS, String valor, String formaDePago) {
        this.idReserva = idReserva;
        this.fechaE = fechaE;
        this.fechaS = fechaS;
        this.valor = valor;
        this.formaDePago = formaDePago;
    }
}
