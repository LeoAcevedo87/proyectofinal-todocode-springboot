package com.leoacevedo.proyectofinal.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_producto;
    private String nombre; 
    private String marca; 
    private Double costo; 
    private Double cantidadDisponible;

    public Producto() {
    }
    
    
    public Producto(Long codigoProducto, String nombre, String marca, Double costo, Double cantidadDisponible) {
        this.codigo_producto = codigoProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidadDisponible = cantidadDisponible;
    }
       
    
}
