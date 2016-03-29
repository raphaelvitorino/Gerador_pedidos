/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action;

import geradorpedidos.action.Action;
import geradorpedidos.dao.ProdutoDAO;
import geradorpedidos.model.Produto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabiano
 */
public class ActionRemoverProduto implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Produto produto = new Produto();
        produto.setIdProduto(id);

        ProdutoDAO dao = new ProdutoDAO();
        dao.remover(id);

        System.out.println("Excluindo cliente ... ");

        request.setAttribute("mensagem", "Produto removido com sucesso.");

        return "controller?action=ActionListarProdutos";
    }

}
