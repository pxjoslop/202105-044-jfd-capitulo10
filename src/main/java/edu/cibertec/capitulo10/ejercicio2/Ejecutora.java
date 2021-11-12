package edu.cibertec.capitulo10.ejercicio2;

import edu.cibertec.capitulo10.ejercicio2.dao.ProductoDAO;
import edu.cibertec.capitulo10.ejercicio2.modelo.Producto;
import java.util.List;

public class Ejecutora {

    public static void main(String[] args) {
        ProductoDAO pdao = new ProductoDAO();
        List<Producto> lista = pdao.obtieneProductos();
        lista.stream().forEach(System.out::println);
        
        System.out.println(" ----- CREANDO UNO NUEVO ------");
        Producto nuevo = new Producto(99, "Radio FM", 258.36);
        pdao.insertarProducto(nuevo);
        lista = pdao.obtieneProductos();
        lista.stream().forEach(System.out::println);

        System.out.println(" ----- ACTUALIZANDO EL NUEVO ------");
        nuevo = new Producto(99, "Radio AM-FM", 398.52);
        pdao.actualizarProducto(nuevo);
        lista = pdao.obtieneProductos();
        lista.stream().forEach(System.out::println);

        System.out.println(" ----- ELIMINANDO EL NUEVO ------");
        pdao.eliminarProducto(nuevo.getCodigoproducto());
        lista = pdao.obtieneProductos();
        lista.stream().forEach(System.out::println);
        
    }
}
