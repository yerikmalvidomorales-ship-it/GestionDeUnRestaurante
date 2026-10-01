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
import modelo.DetallePedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetallePedidoDAO {

    public boolean agregar(DetallePedido detalle) {
        String sql = "INSERT INTO DetallePedido (id_pedido,id_plato,cantidad,subtotal) VALUES(?,?,?,?)";
        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, detalle.getIDPedido());
            ps.setInt(2, detalle.getIDPlato());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getSubTotal());

            ps.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al ingresar detalle de pedido: " + e.getMessage());
            return false;
        }
    }

    public List<DetallePedido> listarPorPedido(int IDPedido) {
        List<DetallePedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM DetallePedido WHERE id_pedido=?";

        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, IDPedido);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DetallePedido detalle = new DetallePedido();
                detalle.setIDDetallePedido(rs.getInt("id_detalle"));
                detalle.setIDPedido(rs.getInt("id_pedido"));
                detalle.setIDPlato(rs.getInt("id_plato"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setSubTotal(rs.getDouble("subtotal"));

                lista.add(detalle);
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("Error al listar detalles del pedido: " + e.getMessage());
        }

        return lista;
    }

    public double totalPorPedido(int IDPedido) {
        double total = 0.0;
        String sql = "SELECT SUM(subtotal) AS total FROM DetallePedido WHERE id_pedido=?";

        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, IDPedido);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getDouble("total");
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("Error al calcular total del pedido: " + e.getMessage());
        }

        return total;
    }

    public boolean eliminarPorPedido(int IDPedido) {
        String sql = "DELETE FROM DetallePedido WHERE id_pedido=?";

        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, IDPedido);

            ps.executeUpdate();
            conn.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar detalles del pedido: " + e.getMessage());
            return false;
        }
    }
}