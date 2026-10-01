/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestiondeunrestaurante;

import java.sql.Connection;

/**
 *
 * @author Adminsena
 */
public class GestionDeUnRestaurante {

    public static void main(String[] args) {
        Connection conectar = Util.ConexioSQlite.conectar(); 
        Util.ConexioSQlite.crearTablas();
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Vista.VistaPrincipal().setVisible(true);
        }
    });
    }
}
