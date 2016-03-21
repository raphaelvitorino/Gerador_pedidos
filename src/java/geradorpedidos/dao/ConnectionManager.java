/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author raphael.silva
 */
public class ConnectionManager {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE = "gerador_pedidos";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String STR_CONNECTION = "jdbc:mysql://localhost:3306/";
    private static Connection conn = null;

    public static Connection getConnection() throws SQLException,
            ClassNotFoundException {
        try {
            if (conn == null) {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(STR_CONNECTION + DATABASE, USERNAME,
                        PASSWORD);
            }
            //return conn;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver do banco não carregado", e);
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível abrir conexão com o banco", e);
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Fechada a conexão com o banco de dados");
            }
        } catch (Exception e) {
            System.out
                    .println("Não foi possível fechar a conexão com o banco de dados "
                            + e.getMessage());
        }
    }

}
