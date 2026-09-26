/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.com.gt.conexion;

import java.sql.Connection;         // Importamos Connection para representar una conexión activa con la base de datos.
import java.sql.DriverManager;      // Importamos DriverManager para abrir la conexión usando URL, usuario y contraseña.
import java.sql.SQLException;       // Importamos SQLException para capturar errores relacionados con SQL Server.
import javax.swing.JOptionPane;     // Importamos JOptionPane para mostrar mensajes sencillos al usuario.

/**
 *
 * @author ALVA
 */
public class Conexion {
    
    private static final String URL = 
            "jdbc:sqlserver://DESKTOP-T5K4RQ5:1433;"
            + "databaseName=TiendaDB;"
            + "encrypt=true;"
            + "trustServerCertificate=true;";

    // Usuario de SQL Server. Cambiarlo si tu usuario es diferente.
    private static final String USUARIO = "sa";

    // Contraseña de SQL Server. Cambiarla por la contraseña real de tu equipo.
    private static final String PASSWORD = "root";

    /**
     * Método getConexion.
     *
     * @return una conexión activa hacia SQL Server. Si falla, retorna null.
     */
    public static Connection getConexion() {
        // Variable donde guardaremos la conexión.
        Connection conexion = null;

        try {
            // Intentamos crear la conexión con SQL Server.
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (SQLException e) {
            // Si ocurre un error, mostramos el mensaje al usuario.
            JOptionPane.showMessageDialog(null,
                    "Error al conectar con SQL Server:\n" + e.getMessage());
        }

        // Retornamos la conexión.
        return conexion;
    }
}