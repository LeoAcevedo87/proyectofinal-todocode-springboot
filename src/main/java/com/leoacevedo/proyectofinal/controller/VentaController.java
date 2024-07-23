
package com.leoacevedo.proyectofinal.controller;


import com.leoacevedo.proyectofinal.model.Venta;
import com.leoacevedo.proyectofinal.service.IVentaService;
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
}
