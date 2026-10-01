/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Util.ConexioSQlite;          
import modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ClienteDAO {
    public boolean agregar(Cliente cliente){
    String sql= "INSERT INTO Cliente (nombre, telefono) VALUES (?,?)";
    
     try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
     ps.setString(1, cliente.getNombre());      
            ps.setString(2, cliente.getTelefono());   
            
            ps.executeUpdate();  
            conn.close();
            return true;         
            
        } catch (SQLException e) {
            System.out.println("Error al agregar Cliente: " + e.getMessage());
            return false;
        }
     
     }
    
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        
        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIDCliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                
                lista.add(cliente);
            }
            
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("Error al listar Clientes: " + e.getMessage());
        }
        
        return lista;
    }
    public boolean modificar(Cliente cliente) {
        String sql = "UPDATE Cliente SET nombre=?, telefono=? WHERE id_cliente=?";
        
        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setInt(3, cliente.getIDCliente());
            
            ps.executeUpdate();
            conn.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al modificar cliente: " + e.getMessage());
            return false;
        }
    }

    
    public boolean eliminar(int IDCliente) {
        String sql = "DELETE FROM Cliente WHERE id_cliente=?";
        
        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, IDCliente);
            ps.executeUpdate();
            conn.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }
    
}
