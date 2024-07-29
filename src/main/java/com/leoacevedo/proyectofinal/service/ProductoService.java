
package com.leoacevedo.proyectofinal.service;

import com.leoacevedo.proyectofinal.model.Producto;
import com.leoacevedo.proyectofinal.model.Venta;
import com.leoacevedo.proyectofinal.repository.IProductoRepository;
import com.leoacevedo.proyectofinal.repository.IVentaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired 
    private IProductoRepository produRepo;
    @Autowired
    private IVentaRepository ventaRepo;
    
    @Override
    public void createProducto(Producto produc) {
        produRepo.save(produc);
    }

    @Override
    public List<Producto> getListProductos() {
        return produRepo.findAll();
    }

    @Override
    public Producto getProducto(Long id) {
        return produRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteProducto(Long id) {
        produRepo.deleteById(id);
    }

//    @Override
//    public void editProducto(Producto produc) {
//        this.createProducto(produc);
//    }
    
    @Override
    public void editProducto(Long codigo_producto, Producto produ) {
        Producto productoExistente = produRepo.findById(codigo_producto).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        //Producto productoExistente = produRepo.findById(idProducto).orElse(null); PODRIA SER ASI TAMBIEN
        
        // Actualiza los campos necesarios del cliente existente
        productoExistente.setNombre(produ.getNombre());
        productoExistente.setMarca(produ.getMarca());
        productoExistente.setCosto(produ.getCosto());
        productoExistente.setCantidadDisponible(produ.getCantidadDisponible());
        
        //Guarda el producto editado
        produRepo.save(productoExistente);
    }

    @Override
    public List<Producto> faltaStock() {
        
        List<Producto> listaProductos = produRepo.findAll();
        List<Producto> prodSinStock = new ArrayList<>();
        
        for (Producto produ : listaProductos) {
            if(produ.getCantidadDisponible() < 5){
                prodSinStock.add(produ);
            }
        }
        return prodSinStock;
    }    
    
    @Override
    public List<Producto> productosDeVenta(Long id) {
        Venta venta = ventaRepo.findById(id).orElse(null);
        
        List<Producto> listaProduVenta = new ArrayList<>();
        listaProduVenta = venta.getListaProductos();
        return listaProduVenta;
    }
    
    //extra: buscar productos x texto ingresado
    @Override 
    public List<Producto> buscarTextoProductos(String texto) { //Muestra productos que contengan el texto a buscar
        
        List<Producto> listaProductos = produRepo.findAll();
        List<Producto> productosEncontrados = new ArrayList<>();
        
        for (Producto producto : listaProductos) {
            if(producto.getNombre().toLowerCase().contains(texto.toLowerCase())){
                productosEncontrados.add(producto);
            }
            
        }
        return productosEncontrados;
    }
    
    //extra: buscar productos entre un costo minimo y un costo máximo
    @Override
    public List<Producto> buscarCostoProducto(Double costo_minimo, Double costo_maximo) {
        
        List<Producto> listaProductos = produRepo.findAll();
        List<Producto> productosfiltrados = new ArrayList<>();
        
        for (Producto producto : listaProductos) {
            if(producto.getCosto() >= costo_minimo && producto.getCosto() <= costo_maximo ){
                productosfiltrados.add(producto);
            }            
        }        
        return productosfiltrados;
    }  
    
}
