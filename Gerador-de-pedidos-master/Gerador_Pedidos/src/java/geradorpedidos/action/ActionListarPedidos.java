/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action;

import geradorpedidos.dao.PedidoDAO;
import geradorpedidos.model.Pedido;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabiano.eger
 */
public class ActionListarPedidos implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Pedido> pedidos = new PedidoDAO().getPedidos();
		
		request.setAttribute("pedidos", pedidos);
		
		return "/WEB-INF/jsp/listarPedidos.jsp";
    }
    
    
}
