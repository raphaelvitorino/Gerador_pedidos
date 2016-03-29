/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.dao;


import geradorpedidos.model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    private final String INSERT = "INSERT INTO item (quantidade, idpedido) VALUES (?,?)";
    private final String UPDATE = "UPDATE item SET quantidade=?, idpedido=? WHERE iditem=?";
    private final String DELETE = "DELETE FROM item WHERE iditem=?";
    private final String LIST = "SELECT * FROM item";
    private final String LISTBYID = "SELECT * FROM item WHERE iditem=?";

    public void inserir(Item item) throws SQLException {
        if (item != null) {
            Connection conn = null;
            PreparedStatement pstm = null;
            try {
                conn = ConnectionManager.getConnection();
                pstm = conn.prepareStatement(INSERT);
                pstm.setInt(1, item.getQuantidade());
                pstm.setInt(2, item.getIdPedido());
                pstm.execute();

            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException("Não foi possível inserir o item");
            } finally {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            }
        } else {
            System.out.println("O item enviado por parâmetro está vazio");
        }
    }

    public void atualizar(Item item) throws SQLException {
        if (item != null) {
            Connection conn = null;
            PreparedStatement pstm = null;
            try {
                conn = ConnectionManager.getConnection();

                pstm = conn.prepareStatement(UPDATE);
                pstm.setInt(1, item.getQuantidade());
                pstm.setInt(2, item.getIdPedido());
                pstm.setInt(3, item.getIdItem());
                pstm.execute();
                throw new RuntimeException("Não foi possível atualizar o item");
            } catch (SQLException | ClassNotFoundException | RuntimeException e) {
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
            throw new RuntimeException("Não foi possível excluir o item");
        } finally {
            if (conn != null) {
                conn.close();

            }
            if (pstm != null) {
                pstm.close();
            }
        }
    }

    public List<Item> getItens() throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs;
        ArrayList<Item> itens = new ArrayList<>();
        try {
            conn = ConnectionManager.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                item.setIdItem(rs.getInt("iditem"));
                item.setQuantidade(rs.getInt("quantidade"));
                item.setIdPedido(rs.getInt("idpedido"));
                itens.add(item);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Não foi possível listar os items");
        } finally {
            if (conn != null) {
                conn.close();

            }
            if (pstm != null) {
                pstm.close();
            }
        }
        return itens;
    }

    public Item getItensById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs;
        Item item = null;
        try {
            conn = ConnectionManager.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                item = new Item();
                item.setIdItem(rs.getInt("iditem"));
                item.setQuantidade(rs.getInt("quantidade"));
                item.setIdPedido(rs.getInt("idpedido"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Não foi possível lista o item");
        } finally {
            if (conn != null) {
                conn.close();

            }
            if (pstm != null) {
                pstm.close();
            }
        }
        return item;
    }
}
