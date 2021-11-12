package edu.cibertec.capitulo10.ejercicio2.modelo;

public class Producto {

    private int codigoproducto;
    private String nombre;
    private double precio;

    public Producto() {
    }

    public Producto(int codigoproducto, String nombre, double precio) {
        this.codigoproducto = codigoproducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoproducto=" + codigoproducto + ", nombre=" 
                + nombre + ", precio=" + precio + '}';
    }
    
    public int getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(int codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
