/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Adminsena
 */
public class Plato {
    private int IDPlato;
private String Nombre;
private double Precio;
private String Categoria;
private boolean Estado;

public Plato(){
}

    public Plato(int IDPlato, String Nombre, double Precio, String Categoria, boolean Estado) {
        this.IDPlato = IDPlato;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Categoria = Categoria;
        this.Estado = Estado;
    }

    public int getIDPlato() {
        return IDPlato;
    }

    public void setIDPlato(int IDPlato) {
        this.IDPlato = IDPlato;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
    

}
