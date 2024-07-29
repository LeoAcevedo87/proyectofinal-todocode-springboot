package com.leoacevedo.proyectofinal.controller;

import com.leoacevedo.proyectofinal.model.Producto;
import com.leoacevedo.proyectofinal.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService produService;

    //C        
    @PostMapping("/productos/crear")
    public void crearCliente(@RequestBody Producto produ) {
        produService.createProducto(produ);
    }

    //R
    @GetMapping("/productos/{codigo_producto}")
    public Producto traerProducto(@PathVariable Long codigo_producto) {
        return produService.getProducto(codigo_producto);
    }

    //U    
    @PutMapping("/productos/editar/{codigo_producto}")
    public void editarCliente(@PathVariable Long codigo_producto, @RequestBody Producto produ) {
        produService.editProducto(codigo_producto, produ);
    }

    //D
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public void eliminarProducto(@PathVariable Long codigo_producto) {
        produService.deleteProducto(codigo_producto);
    }

    //List
    @GetMapping("/productos")
    public List<Producto> listarClientes() {
        return produService.getListProductos();
    }

    //4) Obtener todos los productos cuya cantidad_disponible sea menor a 5 
    @GetMapping("/productos/falta_stock")
    public List<Producto> faltaStock() {
        return produService.faltaStock();
    }

    //Extra: buscar y traer un producto ingresando un texto
    @GetMapping("/productos/buscar/{texto_producto}")
    public List<Producto> buscarTextoProducto(@PathVariable String texto_producto) {

        return produService.buscarTextoProductos(texto_producto);
    }
    
    //extra: buscar productos entre un costo minimo y un costo máximo
    @GetMapping("/productos/buscar_costo")
    public List<Producto> buscarCostoProducto(@RequestParam Double costo_minimo, @RequestParam Double costo_maximo) {

        return produService.buscarCostoProducto(costo_minimo, costo_maximo);
    }
}
