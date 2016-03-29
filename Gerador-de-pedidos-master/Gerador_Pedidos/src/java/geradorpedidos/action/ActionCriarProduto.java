/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action;

import geradorpedidos.dao.ProdutoDAO;
import geradorpedidos.model.Produto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabiano
 */
public class ActionCriarProduto implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Produto produto = new Produto();
        int quantidade = Integer.parseInt(request.getParameter("quantidadeproduto"));
        double valorProduto = Double.parseDouble(request.getParameter("valorproduto"));
        produto.setNomeProduto(request.getParameter("nomeproduto"));
        produto.setQuantidade(quantidade);
        produto.setValorProduto(valorProduto);

        ProdutoDAO dao = new ProdutoDAO();

        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            produto.setIdProduto(id);
            dao.atualizar(produto);
            request.setAttribute("produto", "alterado");

        } else {
            dao.inserir(produto);
            request.setAttribute("produto", "criado");
        }

        return "controller?action=ActionListarProdutos";
    }
}
