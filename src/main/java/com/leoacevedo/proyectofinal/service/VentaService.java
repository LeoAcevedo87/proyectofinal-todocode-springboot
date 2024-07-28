
package com.leoacevedo.proyectofinal.service;



import com.leoacevedo.proyectofinal.dto.ClienteVentaProductoDTO;
import com.leoacevedo.proyectofinal.model.Producto;
import com.leoacevedo.proyectofinal.model.Venta;
import com.leoacevedo.proyectofinal.repository.IProductoRepository;
import com.leoacevedo.proyectofinal.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    
    @Autowired 
    private IVentaRepository ventaRepo;
    @Autowired 
    private IProductoRepository produRepo;
    
    @Override
    public void createVenta(Venta venta) {
        List<Producto> listaProductos = venta.getListaProductos();
        System.out.println(listaProductos.size());
        
        Double sumatoria = 0.0;
        
        for (Producto produ : listaProductos) {
            Long id =  produ.getCodigo_producto();
            Producto producto = produRepo.findById(id).orElse(null);
            sumatoria = sumatoria + producto.getCosto();            
        }
        
        System.out.println(sumatoria + "...");
        venta.setTotal(sumatoria);
        
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

//    @Override                             FORMA MAS SIMPLE DE HACERLO
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

    @Override
    public String montoVentasPorFecha(LocalDate fecha) { //Punto 6       
        List<Venta> ventas = ventaRepo.findAll();
        List<Venta> ventasDelDia = new ArrayList<>();
        
        Double montoDelDia = 0.0;                      
        
        for (Venta venta : ventas) {
            if(venta.getFecha_venta().equals(fecha) ){ //si concide la fehca pasada con la fecha de la venta:
                ventasDelDia.add(venta);
                montoDelDia = montoDelDia + venta.getTotal(); //acumulador
            }
        }        
          
        int cantVentasDia = ventasDelDia.size(); // mido la lista, que da la cantidad de ventas en esa fecha
        
        return "El día " + fecha + " se vendio $" + montoDelDia + " , por la cantidad de " + cantVentasDia + " ventas." ;
    }

    @Override
    public String getMayorVenta() {
        
        ClienteVentaProductoDTO cvpDTO = new ClienteVentaProductoDTO();
        
        List<Venta> listaVentas = ventaRepo.findAll();
        
        Double mayor_venta = 0.0;
        
        for (Venta venta : listaVentas) {
            if(venta.getTotal() > mayor_venta){
                mayor_venta = venta.getTotal();
                
                cvpDTO.setCodigo_venta(venta.getCodigo_venta());
                cvpDTO.setTotal(mayor_venta);
                cvpDTO.setCant_productos(venta.getListaProductos().size());
                cvpDTO.setNombre_cliente(venta.getUnCliente().getNombre());
                cvpDTO.setApellido_cliente(venta.getUnCliente().getApellido());
            }
        }
        
        
        return "DATOS DE LA MAYOR VENTA: -- Codigo venta: " + cvpDTO.getCodigo_venta() +
                                        " -- Total: " + cvpDTO.getTotal() + 
                                        " -- Cantidad de productos: " + cvpDTO.getCant_productos() +
                                        " -- Nombre Cliente: " + cvpDTO.getNombre_cliente() +
                                        " -- Apellido Cliente: " + cvpDTO.getApellido_cliente();
    }
}
