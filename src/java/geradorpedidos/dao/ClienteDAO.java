/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.dao;

import geradorpedidos.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raphael.silva
 */
public class ClienteDAO {

    private final String INSERT = "INSERT INTO cliente (nomecliente, email) VALUES (?,?)";
    private final String UPDATE = "UPDATE cliente SET nomecliente=?, email=? WHERE idcliente=?";
    private final String DELETE = "DELETE FROM cliente WHERE idcliente=?";
    private final String LIST = "SELECT * FROM cliente";
    private final String LISTBYID = "SELECT * FROM cliente WHERE idcliente=?";

    public void inserir(Cliente cliente) throws SQLException {
        if (cliente != null) {
            Connection conn = null;
            PreparedStatement pstm = null;
            try {

                conn = ConnectionManager.getConnection();

                pstm = conn.prepareStatement(INSERT);
                pstm.setString(1, cliente.getNomeCliente());
                pstm.setString(2, cliente.getEmail());
                pstm.execute();

            } catch (Exception e) {
                throw new RuntimeException("Não foi possível inserir o cliente");
            } finally {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            }
        } else {
            System.out.println("O cliente enviado por parâmetro está vazio");
        }
    }

    public void atualizar(Cliente cliente) throws SQLException {
        if (cliente != null) {
            Connection conn = null;
            PreparedStatement pstm = null;
            try {
                conn = ConnectionManager.getConnection();

                pstm = conn.prepareStatement(UPDATE);
                pstm.setString(1, cliente.getNomeCliente());
                pstm.setString(2, cliente.getEmail());
                pstm.setInt(3, cliente.getIdCliente());
                pstm.execute();
                throw new RuntimeException("Não foi possível atualizar o cliente");
            } catch (Exception e) {
            } finally {
                if (conn != null) {
                    conn.close();

                }
                if (pstm != null) {
                    pstm.close();
                }
            }
        } 
    }

    public void remover(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionManager.getConnection();

            pstm = conn.prepareStatement(DELETE);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível excluir o cliente");
        } finally {
            if (conn != null) {
                conn.close();

            }
            if (pstm != null) {
                pstm.close();
            }
        }
    }

    public List<Cliente> getClientes() throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            conn = ConnectionManager.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setNomeCliente(rs.getString("nomecliente"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível listar os clientes");
        } finally {
            if (conn != null) {
                conn.close();

            }
            if (pstm != null) {
                pstm.close();
            }
        }
        return clientes;
    }

    public Cliente getClienteById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cliente cliente = null;
        try {
            conn = ConnectionManager.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setNomeCliente(rs.getString("nomecliente"));
                cliente.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível lista o cliente");
        } finally {
            if (conn != null) {
                conn.close();

            }
            if (pstm != null) {
                pstm.close();
            }
        }
        return cliente;
    }
}
