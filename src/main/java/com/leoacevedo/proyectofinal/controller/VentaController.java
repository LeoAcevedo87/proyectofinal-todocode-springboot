
package com.leoacevedo.proyectofinal.controller;


import com.leoacevedo.proyectofinal.model.Producto;
import com.leoacevedo.proyectofinal.model.Venta;
import com.leoacevedo.proyectofinal.service.IProductoService;
import com.leoacevedo.proyectofinal.service.IVentaService;
import java.time.LocalDate;
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
public class VentaController {
    
    @Autowired
    private IVentaService ventaService;
     @Autowired
    private IProductoService produService;
    //C
    @PostMapping("/ventas/crear")
    public void crearVenta(@RequestBody Venta venta){
        ventaService.createVenta(venta);
    }
    
    //R
    @GetMapping("/ventas/{codigo_venta}")
    public Venta traerVenta(@PathVariable Long codigo_venta){
        return ventaService.getVenta(codigo_venta);
    }
    
    //U
    @PutMapping("/ventas/editar/{codigo_venta}")
    public void editarVenta(@PathVariable Long codigo_venta, @RequestBody Venta venta){
        ventaService.editVenta(codigo_venta, venta);
    }
    
    //D
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public void eliminarVenta(@PathVariable Long codigo_venta){
        ventaService.deleteVenta(codigo_venta);
    }
    
    //List
    @GetMapping("/ventas")
    public List<Venta> listarVentas(){
        return ventaService.getListVentas();
    }
    
    //5) Obtener la lista de productos de una determinada venta
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> productosDeVenta(@PathVariable Long codigo_venta){
        return produService.productosDeVenta(codigo_venta);
    }
    
    //6) Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día
    @GetMapping("/ventas/fecha/{fecha_venta}")
    public String montoVentasPorFecha(@PathVariable LocalDate fecha_venta) {
        return ventaService.montoVentasPorFecha(fecha_venta);
        
    }
    
    //7) Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el apellido del cliente de la venta con el monto más alto de todas.
    @GetMapping("/ventas/mayor_venta")
    public String mayor_venta(){
        return ventaService.getMayorVenta();        
    }
}
