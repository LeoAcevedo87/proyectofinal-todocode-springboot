package com.leoacevedo.proyectofinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter 
public class Venta { //cada venta posee una lista de productos y uno y solo un cliente asociado
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    
    @Temporal(TemporalType.DATE)
    private LocalDate fechaVenta;
    
    private Double total; 
    
    @OneToMany //1 venta a M productos
    @JoinColumn(name = "venta_id", referencedColumnName = "codigo_venta") 
    //La columna venta_id (tabla Producto) referirá a la columna codigo_venta (tabla Venta)
    private List<Producto> listaProductos;
    
    @ManyToOne //M ventas a 1 cliente
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    //La columna id_cliente (tabla Venta) referirá a la columna id_cliente (tabla Cliente)
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigoVenta, LocalDate fechaVenta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigoVenta;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }
    
    
}
