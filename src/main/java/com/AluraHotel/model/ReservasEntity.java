package com.AluraHotel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

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

    @Column(name="fecha_de_entrega", nullable = false, columnDefinition = "DATE")
    private String fechaDeEntrada;

    @Column(name="fecha_de_salida", nullable = false, columnDefinition = "DATE")
    private String fechaDeSalida;

    @Column(nullable = false, columnDefinition = "Decimal(5,2)")
    private Double valor;

    @Column(nullable = false, length = 150)
    private String formaDePago;

    @OneToOne
    @JoinColumn(name = "id_huesped", referencedColumnName = "id_huesped", insertable = false, updatable = false)
    private HuespedEntity huesped;

}
