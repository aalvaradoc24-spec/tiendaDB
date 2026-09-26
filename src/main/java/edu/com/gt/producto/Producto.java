/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.com.gt.producto;

/**
 *
 * @author ALVA
 */
public class Producto {
    
    private int id;          // id del producto, por ejemplo (1) asignado automaticamen por 
    private String codigo;      // Código del producto, por ejemplo: P001.
    private String nombre;      // Nombre del producto, por ejemplo: Mouse USB.
    private String categoria;   // Categoría del producto, por ejemplo: Tecnología o Papelería.
    private double precio;      // Precio unitario del producto.
    private int stock;          // Cantidad disponible del producto.

   /**
     * Constructor vacío.
     * Sirve para crear un producto y llenarlo después con métodos set.
     */
    // Constructor vacío necesario para new Producto()
    public Producto() {
    }

    
    //Constructor con datos. Sirve para crear un producto con todos sus valores.
    public Producto(int id, String codigo, String nombre, String categoria, double precio, int stock) {
    
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;

    }
    
    // Métodos get y set.
    // get: devuelve el valor de una variable.
    // set: asigna o cambia el valor de una variable.

    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    
    public String getCodigo() {
        return codigo;
    }
 
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getCategoria() {
        return categoria;
    }
 
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
 
    public double getPrecio() {
        return precio;
    }
 
    public void setPrecio(double precio) {
        this.precio = precio;
    }
 
    public int getStock() {
        return stock;
    }
 
    public void setStock(int stock) {
        this.stock = stock;
    }


    
}
