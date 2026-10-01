/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Adminsena
 */
public class Cliente {
private int IDCliente;
private String Nombre;
private String Telefono;
public Cliente() {
}
public Cliente(int IDCliente, String Nombre, String Telefono) {
this.IDCliente = IDCliente;
this.Nombre = Nombre;
this.Telefono = Telefono;
}
public int getIDCliente() {
return IDCliente;
}
public void setIDCliente(int IDCliente) {
this.IDCliente = IDCliente;
}
public String getNombre() {
    return Nombre;
}
public void setNombre(String Nombre) {
this.Nombre = Nombre;
}
public String getTelefono() {
return Telefono;
}
public void setTelefono(String Telefono) {
this.Telefono = Telefono;
}
}
