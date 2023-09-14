package com.pesos.TP1JPA.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity  //Con esta etiqueta indico a la unidad de persistencia que esta entidad se debe guardar en la bd
@Table(name = "Cliente")
@Data
@AllArgsConstructor
@Builder


public class Cliente implements Serializable {

  //  @Column(name = "nombre") //Sirve para indentificar un name en la columna de la tabla, sino toma por defecto el del atributo

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Esto representa la clave principal
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Telefono")
    private String telefono;
   // @Column(name = "email", unique = true)  //Esto sirve para que no hayan 2 registros con el mismo email
    @Column(name = "Email")
    private String email;



    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<Domicilio>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public Cliente(){
   }

    public void addDomicilio(Domicilio domicilio) {
        domicilios.add(domicilio);
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

}