
package com.leoacevedo.proyectofinal.service;

import com.leoacevedo.proyectofinal.model.Producto;
import java.util.List;

public interface IProductoService {
    
    public void createProducto(Producto produc);
    
    public List<Producto> getListProductos();
    
    public Producto getProducto(Long id);
    
    public void deleteProducto(Long id);
    
    //public void editProducto(Producto produc);
    
    public void editProducto(Long idProducto, Producto produ);
}
