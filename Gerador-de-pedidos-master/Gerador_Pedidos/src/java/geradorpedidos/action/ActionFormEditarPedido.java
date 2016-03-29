/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action;
import geradorpedidos.dao.PedidoDAO;
import geradorpedidos.model.Pedido;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabinho
 */
public class ActionFormEditarPedido implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
              String strId = request.getParameter("id");

        Pedido pedido = new Pedido();

        if (strId != null) {
            int id = Integer.parseInt(strId);
            PedidoDAO daopd = new PedidoDAO();
            pedido = daopd.getPedidoById(id);
        }

        request.setAttribute("pedido", pedido);

        return "/WEB-INF/jsp/adicionarPedidos.jsp";
    }
    
}
