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
public class ActionFormEditarProduto implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String strId = request.getParameter("id");
        Produto produto = new Produto();

        if (strId != null) {
            int id = Integer.parseInt(strId);
            ProdutoDAO dao = new ProdutoDAO();
            produto = dao.getProdutoById(id);
        }
        request.setAttribute("produto", produto);
        return "/WEB-INF/jsp/adicionarProdutos.jsp";

    }

}
