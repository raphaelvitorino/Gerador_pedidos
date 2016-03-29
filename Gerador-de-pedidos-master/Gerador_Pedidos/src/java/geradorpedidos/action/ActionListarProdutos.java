/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action;

import geradorpedidos.dao.ProdutoDAO;
import geradorpedidos.model.Produto;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raphael.silva
 */
public class ActionListarProdutos implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
     		List<Produto> produtos = new ProdutoDAO().getProdutos();
		
		request.setAttribute("produtos", produtos);
		
		return "/WEB-INF/jsp/listarProdutos.jsp";
    }
    
}
