package edu.cibertec.capitulo10.ejercicio2.dao;

import edu.cibertec.capitulo10.ejercicio2.Conexion;
import edu.cibertec.capitulo10.ejercicio2.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public List<Producto> obtieneProductos() {
        List<Producto> lista = null;
        try {
            lista = new ArrayList<>();
            Connection cn = Conexion.getConexion();
            ResultSet rs = cn.prepareStatement("Select * from producto").
                    executeQuery();
            while (rs.next()) {
                Producto p = new Producto(rs.getInt("codigoProducto"),
                        rs.getString("nombre"), rs.getDouble("precio"));
                lista.add(p);
            }
            Conexion.cerrarResultSet(rs);
            Conexion.cerrarConexion(cn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insertarProducto(Producto p) {
        try {
            Connection cn = Conexion.getConexion();
            PreparedStatement st = cn.prepareStatement(
                    "insert into producto values (?, ?, ?)");
            st.setInt(1, p.getCodigoproducto());
            st.setString(2, p.getNombre());
            st.setDouble(3, p.getPrecio());
            st.execute();

            Conexion.cerrarConexion(cn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizarProducto(Producto p) {
        try {
            Connection cn = Conexion.getConexion();
            PreparedStatement st = cn.prepareStatement(
                    "update producto set nombre=?, precio=?"
                            + " where codigoproducto=?");
            st.setString(1, p.getNombre());
            st.setDouble(2, p.getPrecio());
            st.setInt(3, p.getCodigoproducto());
            st.execute();

            Conexion.cerrarConexion(cn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarProducto(int codigo) {
        try {
            Connection cn = Conexion.getConexion();
            PreparedStatement st = cn.prepareStatement(
                    "delete from producto where codigoproducto=?");
            st.setInt(1, codigo);
            st.execute();

            Conexion.cerrarConexion(cn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
