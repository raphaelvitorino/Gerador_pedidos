/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.dao;

import geradorpedidos.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author raphael.silva
 */
public class ProdutoDAO {

    private final String INSERT = "INSERT INTO produto (nomeproduto, quantidade, valorproduto) VALUES (?,?,?)";
    private final String UPDATE = "UPDATE produto SET nomeproduto=?, quantidade=?, valorproduto=? WHERE idproduto=?";
    private final String DELETE = "DELETE FROM produto WHERE idproduto=?";
    private final String LIST = "SELECT * FROM produto";
    private final String LISTBYID = "SELECT * FROM produto WHERE idproduto=?";

    public void inserir(Produto produto) throws SQLException {
        if (produto != null) {
            Connection conn = null;
            PreparedStatement pstm = null;
            try {
                conn = ConnectionManager.getConnection();
                pstm = conn.prepareStatement(INSERT);
                pstm.setString(1, produto.getNomeProduto());
                pstm.setInt(2, produto.getQuantidade());
                pstm.setDouble(3, produto.getValorProduto());
                pstm.execute();

            } catch (Exception e) {
                throw new RuntimeException("Não foi possível inserir o produto");
            } finally {
                if (conn != null) {
                    conn.close();

                }
                if (pstm != null) {
                    pstm.close();
                }

            }

        } else {
            System.out.println("O produto enviado por parâmetro está vazio");
        }
    }

    public void atualizar(Produto produto) throws SQLException {
        if (produto != null) {
            Connection conn = null;
            PreparedStatement pstm = null;
            try {
                conn = ConnectionManager.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                pstm.setString(1, produto.getNomeProduto());
                pstm.setInt(2, produto.getQuantidade());
                pstm.setDouble(3, produto.getValorProduto());
                pstm.setInt(4, produto.getIdProduto());
                pstm.execute();
            } catch (Exception e) {
                throw new RuntimeException("Não foi possível atualizar o produto");
            } finally {
                if (conn != null) {
                    conn.close();

                }
                if (pstm != null) {
                    pstm.close();
                }
            }
            
        } else {
            throw new RuntimeException("Produto enviado por paramêtro está vazio");
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
            throw new RuntimeException("Não foi possível excluir o produto");
        } finally {
            if (conn != null) {
                conn.close();

            }
            if (pstm != null) {
                pstm.close();
            }
        }
    }

    public List<Produto> getProdutos() throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try {
            conn = ConnectionManager.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idproduto"));
                produto.setNomeProduto(rs.getString("nomeproduto"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setValorProduto(rs.getDouble("valorproduto"));
                produtos.add(produto);
            }

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível listar os produtos");
        } finally {
            if (conn != null) {
                conn.close();

            }
            if (pstm != null) {
                pstm.close();
            }
        }
        return produtos;
    }

    public Produto getProdutoById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            conn = ConnectionManager.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                produto = new Produto();
                produto.setIdProduto(rs.getInt("idproduto"));
                produto.setNomeProduto(rs.getString("nomeproduto"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setValorProduto(rs.getDouble("valorproduto"));
            }

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível listar o produto");
        } finally {
            if (conn != null) {
                conn.close();

            }
            if (pstm != null) {
                pstm.close();
            }
        }
        return produto;
    }
}
