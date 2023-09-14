package com.pesos.TP1JPA.Entidades;

import com.pesos.TP1JPA.Enumeraciones.EstadoPedido;
import com.pesos.TP1JPA.Enumeraciones.TipoEnvio;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name = "Pedido")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido implements Serializable {

        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "desc_aplicado")
        private Double descAplicado;

        @Column(name = "estado")
        @Enumerated(EnumType.STRING)
        private EstadoPedido estado;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "fecha")
        private Date fecha;

        @Column(name = "tipo_envio")
        @Enumerated(EnumType.STRING)
        private TipoEnvio tipoEnvio;
        private double total;

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
        @JoinColumn(name = "Pedido_id")
        @Builder.Default
        private List<DetallePedido> detallePedidos = new ArrayList<DetallePedido>();


        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "fk_Factura")
        private Factura factura;

        public void agregarDetallePedido (DetallePedido deta){
                detallePedidos.add(deta);
        }
}
