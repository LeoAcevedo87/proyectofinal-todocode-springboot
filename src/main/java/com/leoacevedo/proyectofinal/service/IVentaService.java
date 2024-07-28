
package com.leoacevedo.proyectofinal.service;

import com.leoacevedo.proyectofinal.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    
    public void createVenta(Venta venta);
    
    public List<Venta> getListVentas();
    
    public Venta getVenta(Long id);
    
    public void deleteVenta(Long id);
    
    public void editVenta(Long codigo_venta, Venta venta);
    
    public String montoVentasPorFecha(LocalDate fecha);
    
    public String getMayorVenta();
}
