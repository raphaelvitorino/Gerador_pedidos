/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.dao;

import geradorpedidos.model.Pedido;
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
public class PedidoDAO {

    private final String INSERT = "INSERT INTO pedido (idcliente, valorpedido, datapedido) VALUES (?,?,?)";
    private final String UPDATE = "UPDATE pedido SET idcliente=?, valorpedido=?, datapedido=? WHERE idpedido=?";
    private final String DELETE = "DELETE FROM pedido WHERE idpedido=?";
    private final String LIST = "SELECT * FROM pedido";
    private final String LISTBYID = "SELECT * FROM pedido WHERE idpedido=?";

    public void inserir(Pedido pedido) throws SQLException {
        if (pedido != null) {
            Connection conn = null;
            PreparedStatement pstm = null;
            try {
                conn = ConnectionManager.getConnection();
                pstm = conn.prepareStatement(INSERT);
                pstm.setInt(1, pedido.getIdCliente());
                pstm.setDouble(2, pedido.getValorPedido());
                pstm.setDate(3, pedido.getDataPedido());
                pstm.execute();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException("Não foi possível inserir o pedido");
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

    public void atualizar(Pedido pedido) throws SQLException {
        if (pedido != null) {
            Connection conn = null;
            PreparedStatement pstm = null;
            try {
                conn = ConnectionManager.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                pstm.setInt(1, pedido.getIdCliente());
                pstm.setDouble(2, pedido.getValorPedido());
                pstm.setDate(3, pedido.getDataPedido());
                pstm.setInt(4, pedido.getIdPedido());
                pstm.execute();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException("Não foi possível atualizar o pedido");
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
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Não foi possível remover o pedido");
        } finally {
            if (conn != null) {
                conn.close();

            }
            if (pstm != null) {
                pstm.close();
            }
        }
    }

    public List<Pedido> getPedidos() throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs;
        List<Pedido> pedidos = new ArrayList<>();
        try {
            conn = ConnectionManager.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idpedido"));
                pedido.setIdCliente(rs.getInt("idcliente"));
                pedido.setValorPedido(rs.getDouble("nr_telefone"));
                pedido.setDataPedido(rs.getDate("datapedido"));
                pedidos.add(pedido);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Não foi possível listar os pedidos");
        } finally {
            if (conn != null) {
                conn.close();

            }
            if (pstm != null) {
                pstm.close();
            }
        }
        return pedidos;
    }

    public Pedido getPedidoById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs;
        Pedido pedido = new Pedido();
        try {
            conn = ConnectionManager.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                pedido.setIdPedido(rs.getInt("idpedido"));
                pedido.setIdCliente(rs.getInt("idcliente"));
                pedido.setValorPedido(rs.getDouble("nr_telefone"));
                pedido.setDataPedido(rs.getDate("datapedido"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Não foi possível listar o pedido");
        } finally {
            if (conn != null) {
                conn.close();

            }
            if (pstm != null) {
                pstm.close();
            }
        }
        return pedido;
    }
}
