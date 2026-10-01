/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexioSQlite {
   private static  final String URL = "jdbc:sqlite:Restaurante.db";
   
   public static Connection conectar(){
   Connection  conexion = null;
   try {
       conexion = DriverManager.getConnection(URL);
       System.out.println("conexion a sql exitosa ");
   }
   catch(SQLException e){
              System.out.println("ERROR Al CONECTAR "+ e.getMessage());

   }
   return conexion;
   }
   public static void crearTablas() {

        String sqlMesa = "CREATE TABLE IF NOT EXISTS Mesa ("
                + "id_mesa INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "numero INTEGER NOT NULL,"
                + "estado TEXT NOT NULL);";

        String sqlCliente = "CREATE TABLE IF NOT EXISTS Cliente ("
                + "id_cliente INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nombre TEXT NOT NULL,"
                + "telefono TEXT);";

        String sqlPlato = "CREATE TABLE IF NOT EXISTS Plato ("
                + "id_plato INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nombre TEXT NOT NULL,"
                + "precio REAL NOT NULL,"
                + "categoria TEXT,"
                + "estado INTEGER NOT NULL);";

        String sqlPedido = "CREATE TABLE IF NOT EXISTS Pedido ("
                + "id_pedido INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "fecha TEXT NOT NULL,"
                + "id_mesa INTEGER,"
                + "id_cliente INTEGER,"
                + "estado TEXT NOT NULL,"
                + "FOREIGN KEY (id_mesa) REFERENCES Mesa(id_mesa),"
                + "FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente));";

        String sqlDetallePedido = "CREATE TABLE IF NOT EXISTS DetallePedido ("
                + "id_detalle INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "id_pedido INTEGER,"
                + "id_plato INTEGER,"
                + "cantidad INTEGER NOT NULL,"
                + "subtotal REAL NOT NULL,"
                + "FOREIGN KEY (id_pedido) REFERENCES Pedido(id_pedido),"
                + "FOREIGN KEY (id_plato) REFERENCES Plato(id_plato));";

        String sqlFactura = "CREATE TABLE IF NOT EXISTS Factura ("
                + "id_factura INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "id_pedido INTEGER,"
                + "fecha TEXT NOT NULL,"
                + "total REAL NOT NULL,"
                + "metodo_pago TEXT NOT NULL,"
                + "FOREIGN KEY (id_pedido) REFERENCES Pedido(id_pedido));";

        try {
            Connection conn = conectar();
            if (conn != null) {
                conn.createStatement().execute(sqlMesa);
                conn.createStatement().execute(sqlCliente);
                conn.createStatement().execute(sqlPlato);
                conn.createStatement().execute(sqlPedido);
                conn.createStatement().execute(sqlDetallePedido);
                conn.createStatement().execute(sqlFactura);
                System.out.println("Tablas creadas correctamente");
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("Error al crear las tablas: " + e.getMessage());
        }
    }

       }
   

