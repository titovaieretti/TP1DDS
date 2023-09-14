package com.pesos.TP1JPA.Entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Rubro")
@Data
@NoArgsConstructor
@Builder

public class Rubro implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Denominacion")
    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "rubro_id")
    private List<Producto> productos = new ArrayList<Producto>();


    public Rubro(Long id, String denominacion, List<Producto> productos) {
        this.id = id;
        this.denominacion = denominacion;
        this.productos = productos;
    }

    public void addProducto(Producto producto) {
        if (this.productos == null) {
            this.productos = new ArrayList<>();
        }
        this.productos.add(producto);
    }
}


