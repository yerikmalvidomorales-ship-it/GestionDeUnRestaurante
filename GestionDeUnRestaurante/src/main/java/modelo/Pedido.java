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
public class Pedido {
 private int IDPedido;
private LocalDateTime Fecha;
private int IDMesa;
private int IDCliente;
private String Estado;

public Pedido(){
}

    public Pedido(int IDPedido, LocalDateTime Fecha, int IDMesa, int IDCliente, String Estado) {
        this.IDPedido = IDPedido;
        this.Fecha = Fecha;
        this.IDMesa = IDMesa;
        this.IDCliente = IDCliente;
        this.Estado = Estado;
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

    public int getIDMesa() {
        return IDMesa;
    }

    public void setIDMesa(int IDMesa) {
        this.IDMesa = IDMesa;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    

}
