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
import modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    /**
     * Inserta un pedido y devuelve el ID generado (-1 si falla).
     */
    public int agregar(Pedido pedido) {
        String sql = "INSERT INTO Pedido (fecha,id_mesa,id_cliente,estado) VALUES(?,?,?,?)";
        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pedido.getFecha().toString());
            ps.setInt(2, pedido.getIDMesa());
            ps.setInt(3, pedido.getIDCliente());
            ps.setString(4, pedido.getEstado());

            ps.executeUpdate();

            int idGenerado = -1;
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
            conn.close();
            return idGenerado;
        } catch (SQLException e) {
            System.out.println("Error al ingresar pedido: " + e.getMessage());
            return -1;
        }
    }

    public List<Pedido> listar() {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM Pedido";

        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIDPedido(rs.getInt("id_pedido"));
                pedido.setFecha(LocalDateTime.parse(rs.getString("fecha")));
                pedido.setIDMesa(rs.getInt("id_mesa"));
                pedido.setIDCliente(rs.getInt("id_cliente"));
                pedido.setEstado(rs.getString("estado"));

                lista.add(pedido);
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("Error al listar Pedidos: " + e.getMessage());
        }

        return lista;
    }

    public boolean modificar(Pedido pedido) {
        String sql = "UPDATE Pedido SET id_mesa=?, id_cliente=?, estado=? WHERE id_pedido=?";

        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, pedido.getIDMesa());
            ps.setInt(2, pedido.getIDCliente());
            ps.setString(3, pedido.getEstado());
            ps.setInt(4, pedido.getIDPedido());

            ps.executeUpdate();
            conn.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al modificar pedido: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarEstado(int IDPedido, String estado) {
        String sql = "UPDATE Pedido SET estado=? WHERE id_pedido=?";

        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, estado);
            ps.setInt(2, IDPedido);

            ps.executeUpdate();
            conn.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar estado del pedido: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int IDPedido) {
        String sql = "DELETE FROM Pedido WHERE id_pedido=?";

        try {
            Connection conn = ConexioSQlite.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, IDPedido);
            ps.executeUpdate();
            conn.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar pedido: " + e.getMessage());
            return false;
        }
    }
}