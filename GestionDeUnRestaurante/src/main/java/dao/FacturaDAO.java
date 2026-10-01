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
import modelo.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {

    public boolean agregar(Factura factura) {
        String sql = "INSERT INTO Factura (id_pedido,fecha,total,metodo_pago) VALUES(?,?,?,?)";
        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, factura.getIDPedido());
            ps.setString(2, factura.getFecha().toString());
            ps.setDouble(3, factura.getTotal());
            ps.setString(4, factura.getMetodoPago());

            ps.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al ingresar factura: " + e.getMessage());
            return false;
        }
    }

    public List<Factura> listar() {
        List<Factura> lista = new ArrayList<>();
        String sql = "SELECT * FROM Factura";

        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Factura factura = new Factura();
                factura.setIDFactura(rs.getInt("id_factura"));
                factura.setIDPedido(rs.getInt("id_pedido"));
                factura.setFecha(LocalDateTime.parse(rs.getString("fecha")));
                factura.setTotal(rs.getDouble("total"));
                factura.setMetodoPago(rs.getString("metodo_pago"));

                lista.add(factura);
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("Error al listar Facturas: " + e.getMessage());
        }

        return lista;
    }

    public boolean eliminar(int IDFactura) {
        String sql = "DELETE FROM Factura WHERE id_factura=?";

        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, IDFactura);
            ps.executeUpdate();
            conn.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar factura: " + e.getMessage());
            return false;
        }
    }
}