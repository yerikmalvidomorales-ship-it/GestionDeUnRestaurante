/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDateTime;
/**
 *
 * @author Adminsena
 */
public class Factura {

    private int IDFactura;
     private int IDPedido;
     private LocalDateTime Fecha;
     private double Total;
     private String MetodoPago;

      public Factura(){}

    public Factura(int IDFactura, int IDPedido, LocalDateTime Fecha, double Total, String MetodoPago) {
        this.IDFactura = IDFactura;
        this.IDPedido = IDPedido;
        this.Fecha = Fecha;
        this.Total = Total;
        this.MetodoPago = MetodoPago;
    }

    public int getIDFactura() {
        return IDFactura;
    }

    public void setIDFactura(int IDFactura) {
        this.IDFactura = IDFactura;
    }

    public int getIDPedido() {
        return IDPedido;
    }

    public void setIDPedido(int IDPedido) {
        this.IDPedido = IDPedido;
    }

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDateTime Fecha) {
        this.Fecha = Fecha;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public String getMetodoPago() {
        return MetodoPago;
    }

    public void setMetodoPago(String MetodoPago) {
        this.MetodoPago = MetodoPago;
    }
    
  
}
