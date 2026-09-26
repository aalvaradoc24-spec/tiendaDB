/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.com.gt.dao;

import edu.com.gt.conexion.Conexion;
import edu.com.gt.producto.Producto;
//importar las utilidades de SQL
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//importar las utilidades de java swing
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author ALVA
 */
public class ProductoDAO {
    
    //Guarda un producto nuevo en la base de datos.
    //@param producto objeto con los datos escritos en el formulario.
    //@return true si guardó correctamente, false si ocurrió un error.
    
    public boolean guardar(Producto producto) {
        // Consulta SQL para insertar. Los signos ? evitan concatenar datos directamente.
        String sql = "INSERT INTO Producto (codigo, nombre, categoria, precio, stock) VALUES (?, ?, ?, ?, ?)";
 
        // try-with-resources cierra automáticamente la conexión y el PreparedStatement.
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
 
            // Validamos que la conexión no sea null.
            if (con == null) {
                return false;
            }
 
            // Asignamos cada dato del producto al signo ? correspondiente.
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getCategoria());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getStock());
 
            // Ejecutamos el INSERT.
            ps.executeUpdate();
 
            // Retornamos true porque sí se guardó.
            return true;
 
        } catch (SQLException e) {
            // Mostramos el error si algo falla.
            JOptionPane.showMessageDialog(null, "Error al guardar producto:\n" + e.getMessage());
            return false;
        }
    }
 
    /**
     * Lista todos los productos de la base de datos.
     *
     * @return lista de productos registrados.
     */
    public List<Producto> listar() {
        // Lista donde guardaremos los productos que vengan desde SQL Server.
        List<Producto> lista = new ArrayList<>();
 
        // Consulta para seleccionar todos los productos.
        String sql = "codigo, nombre, categoria, precio, stock";
 
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
 
            if (con == null) {
                return lista;
            }
 
            // Mientras existan filas en el resultado, se crea un producto.
            while (rs.next()) {
                Producto producto = new Producto();
 
                // Se toman los datos de cada columna.
                producto.setCodigo(rs.getString("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
 
                // Se agrega el producto a la lista.
                lista.add(producto);
            }
 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar productos:\n" + e.getMessage());
        }
 
        // Devolvemos la lista, aunque esté vacía.
        return lista;
    }
 
    /**
     * Modifica un producto existente.
     *
     * @param producto objeto con el id y los nuevos datos.
     * @return true si modificó correctamente.
     */
    public boolean modificar(Producto producto) {
        // Consulta SQL para actualizar por id.
        String sql = "UPDATE Producto SET codigo=?, nombre=?, categoria=?, precio=?, stock=? WHERE id=?";
 
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
 
            if (con == null) {
                return false;
            }
 
            // Datos nuevos.
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getCategoria());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getStock());
 
            // ID del producto que se va a modificar.
            ps.setInt(6, producto.getId());
 
            // Ejecutamos el UPDATE.
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar producto:\n" + e.getMessage());
            return false;
        }
    }
 
    /**
     * Elimina un producto por su id.
     *
     * @param id identificador del producto.
     * @return true si eliminó correctamente.
     */
    public boolean eliminar(int id) {
        // Consulta SQL para eliminar por id.
        String sql = "DELETE FROM Producto WHERE id=?";
 
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
 
            if (con == null) {
                return false;
            }
 
            // Asignamos el id al signo ?.
            ps.setInt(1, id);
 
            // Ejecutamos el DELETE.
            ps.executeUpdate();
            return true;
 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar producto:\n" + e.getMessage());
            return false;
        }
    }

    
}
