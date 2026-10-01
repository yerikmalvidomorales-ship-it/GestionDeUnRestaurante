/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Adminsena
 */
public class DetallePedido {
private int IDDetallePedido;
private int IDPedido;
private int IDPlato;
private int Cantidad;
private double SubTotal;

public DetallePedido(){
}
public DetallePedido(int IDDetallePedido, int IDPedido, int IDPlato, int Cantidad, double SubTotal) {
this.IDDetallePedido = IDDetallePedido;
this.IDPedido = IDPedido;
this.IDPlato = IDPlato;
this.Cantidad = Cantidad;
this.SubTotal = SubTotal;
}
public int getIDDetallePedido() {
return IDDetallePedido;
}
public void setIDDetallePedido(int IDDetallePedido) {
this.IDDetallePedido = IDDetallePedido;
}
public int getIDPedido() {
return IDPedido;
}
public void setIDPedido(int IDPedido) {
this.IDPedido = IDPedido;
}
public int getIDPlato() {
return IDPlato;
}
public void setIDPlato(int IDPlato) {
this.IDPlato = IDPlato;
}
public int getCantidad() {
return Cantidad;
}
public void setCantidad(int Cantidad) {
this.Cantidad = Cantidad;
}
public double getSubTotal() {
return SubTotal;
}
public void setSubTotal(double SubTotal) {
this.SubTotal = SubTotal;
}
}
