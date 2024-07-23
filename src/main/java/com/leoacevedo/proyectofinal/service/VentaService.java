
package com.leoacevedo.proyectofinal.service;

import com.leoacevedo.proyectofinal.model.Venta;
import com.leoacevedo.proyectofinal.repository.IVentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    
    @Autowired 
    private IVentaRepository ventaRepo;
    
    @Override
    public void createVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public List<Venta> getListVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public Venta getVenta(Long id) {
        return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepo.deleteById(id);
    }

//    @Override
//    public void editVenta(Venta venta) {
//        this.createVenta(venta);
//    }

    @Override
    public void editVenta(Long codigo_venta, Venta venta) {
        Venta ventaExistente = ventaRepo.findById(codigo_venta).orElse(null);
        
        // Actualiza los campos necesarios de la venta existente
        ventaExistente.setFecha_venta(venta.getFecha_venta());
        ventaExistente.setTotal(venta.getTotal());
        ventaExistente.setListaProductos(venta.getListaProductos());
        ventaExistente.setUnCliente(venta.getUnCliente());
        
        //Guarda el producto editado
        ventaRepo.save(ventaExistente);
    }

}
