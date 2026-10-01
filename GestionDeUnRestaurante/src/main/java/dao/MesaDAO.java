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
import modelo.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class MesaDAO {
    public boolean agregar(Mesa mesa) {
        String sql = "INSERT INTO Mesa(numero, estado) VALUES(?, ?)";
        
        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            
            ps.setInt(1, mesa.getNumero());      
            ps.setString(2, mesa.getEstadoMESA());   
            
            ps.executeUpdate();  
            conn.close();
            return true;         
            
        } catch (SQLException e) {
            System.out.println("Error al agregar mesa: " + e.getMessage());
            return false;
        }
    }

    
    public List<Mesa> listar() {
        List<Mesa> lista = new ArrayList<>();
        String sql = "SELECT * FROM Mesa";
        
        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Mesa mesa = new Mesa();
                mesa.setIDMesa(rs.getInt("id_mesa"));
                mesa.setNumero(rs.getInt("numero"));
                mesa.setEstadoMESA(rs.getString("estado"));
                
                lista.add(mesa);
            }
            
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("Error al listar mesas: " + e.getMessage());
        }
        
        return lista;
    }

    
    public boolean modificar(Mesa mesa) {
        String sql = "UPDATE Mesa SET numero=?, estado=? WHERE id_mesa=?";
        
        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, mesa.getNumero());
            ps.setString(2, mesa.getEstadoMESA());
            ps.setInt(3, mesa.getIDMesa());
            
            ps.executeUpdate();
            conn.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al modificar mesa: " + e.getMessage());
            return false;
        }
    }

    
    public boolean eliminar(int idMesa) {
        String sql = "DELETE FROM Mesa WHERE id_mesa=?";
        
        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, idMesa);
            ps.executeUpdate();
            conn.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar mesa: " + e.getMessage());
            return false;
        }
    }
    
}
