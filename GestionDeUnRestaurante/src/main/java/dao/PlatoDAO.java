/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Lenovo
 */

import Util.ConexioSQlite;          
import modelo.Plato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class PlatoDAO {
    public boolean agregar(Plato plato){
    String sql = "INSERT INTO Plato (nombre,precio,categoria,estado) VALUES(?,?,?,?)";
    try {
    Connection conn = ConexioSQlite.conectar();
    PreparedStatement ps  = conn.prepareStatement(sql);
    ps.setString(1, plato.getNombre());
                ps.setDouble(2, plato.getPrecio());  
                    ps.setString(3, plato.getCategoria());
                        ps.setBoolean(4, plato.isEstado());

        ps.executeUpdate();
        conn.close();
        return true;
               }catch(SQLException e ){
               System.out.println("Error al ingresar plato" + e.getMessage());
               return false;
               }
    
    }
     public List<Plato> listar() {
        List<Plato> lista = new ArrayList<>();
        String sql = "SELECT * FROM Plato";
        
        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Plato plato = new Plato();
                plato.setIDPlato(rs.getInt("id_plato"));
                plato.setNombre(rs.getString("nombre"));
                plato.setPrecio(rs.getDouble("precio"));
                plato.setCategoria(rs.getString("categoria"));
                plato.setEstado(rs.getBoolean("estado"));


                
                lista.add(plato);
            }
            
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("Error al listar Platos: " + e.getMessage());
        }
        
        return lista;
        
        
    }
     public boolean modificar(Plato plato){
     String sql = "UPDATE Plato  SET nombre=?, precio=? , categoria=?, estado=? WHERE id_plato=?";
        
        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, plato.getNombre());
            ps.setDouble(2, plato.getPrecio());
            ps.setString(3, plato.getCategoria());
            ps.setBoolean(4, plato.isEstado());
            ps.setInt(5, plato.getIDPlato());

            
            ps.executeUpdate();
            conn.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al modificar plato: " + e.getMessage());
            return false;
        }
    }
       
    public boolean eliminar(int IDPlato) {
        String sql = "DELETE FROM Plato WHERE id_plato=?";
        
        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, IDPlato);
            ps.executeUpdate();
            conn.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar plato: " + e.getMessage());
            return false;
        }
    }
}
             



