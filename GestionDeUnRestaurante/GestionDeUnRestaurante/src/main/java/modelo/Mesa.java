/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Adminsena
 */
public class Mesa {

    private int IDMesa;
    private int Numero;
    private String EstadoMESA;

    public Mesa() {
    }

    public Mesa(int IDmesa, int Numero, String EstadoMESA) {
        this.IDMesa = IDmesa;
        this.Numero = Numero;
        this.EstadoMESA = EstadoMESA;
    }

    public int getIDMesa() {
        return IDMesa;
    }

    public void setIDMesa(int IDMesa) {
        this.IDMesa = IDMesa;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getEstadoMESA() {
        return EstadoMESA;
    }

    public void setEstadoMESA(String EstadoMESA) {
        this.EstadoMESA = EstadoMESA;
    }
    

}
