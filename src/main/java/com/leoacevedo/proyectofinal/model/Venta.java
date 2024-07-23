package com.leoacevedo.proyectofinal.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Venta { //cada venta posee una lista de productos, y uno y solo un cliente asociado

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;

    @ManyToMany
    @JoinTable(
            name = "venta_producto", //nombre tabla intermedia 
            joinColumns = @JoinColumn(name = "cod_venta", //columnas que tendra: hace relacion a la clase venta o a la clave primaria de venta
                    referencedColumnName = "codigo_venta"), //va a referenciar a la columna de ventas "codigo_venta" 

            inverseJoinColumns = @JoinColumn(name = "cod_producto", //columnas que tendra: hace relacion a la clase venta o a la clave primaria de venta
                    referencedColumnName = "codigo_producto") //debemos poner el nombre del atributo primario de la clase producto
    )
    private List<Producto> listaProductos;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigoVenta, LocalDate fechaVenta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigoVenta;
        this.fecha_venta = fechaVenta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }

}
