
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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService produService;
            
    //C        
    @PostMapping("/productos/crear")
    public void crearCliente(@RequestBody Producto produ){
        produService.createProducto(produ);
    }
    
    //R
    @GetMapping("/productos/{codigo_producto}")
    public Producto traerProducto(@PathVariable Long codigo_producto){
        return produService.getProducto(codigo_producto);
    }
    
    //U    
    @PutMapping("/productos/editar/{codigo_producto}")
    public void editarCliente(@PathVariable Long codigo_producto, @RequestBody Producto produ) {
        produService.editProducto(codigo_producto, produ);
    }
    
//    @PutMapping("/productos/editar/{codigo_producto}")
//    public void editarCliente(@PathVariable("codigo_producto") Long idProducto, @RequestBody Producto produ) {
//        produService.editProducto(idProducto, produ);
//    }
    
    
    //D
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public void eliminarProducto(@PathVariable Long codigo_producto){
        produService.deleteProducto(codigo_producto);
    }
    
    //List
    @GetMapping("/productos")    
    public List<Producto> listarClientes(){
        return produService.getListProductos();
    }
}
