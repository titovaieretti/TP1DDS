package com.pesos.TP1JPA.Entidades;

import com.pesos.TP1JPA.Enumeraciones.FormadePago;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "Factura")
@Builder
public class Factura implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Numero")
    private int numero;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Fecha")
    private Date fecha;
    @Column(name = "Descuento")
    private double descuento;
    @Column(name = "Total")
    private int total;
    @Enumerated(EnumType.STRING)
    private FormadePago formadePago;

    public Factura(){

    }

    public Factura(Long id, int numero, Date fecha, double descuento, int total, FormadePago formadePago, Pedido pedido) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
        this.descuento = descuento;
        this.total = total;
        this.formadePago = formadePago;
        this.pedido = pedido;
    }

    @OneToOne(mappedBy = "factura")
   // @JoinColumn(name = "pedido_id") // Asegúrate de que el nombre de la columna sea correcto
    private Pedido pedido;


}
