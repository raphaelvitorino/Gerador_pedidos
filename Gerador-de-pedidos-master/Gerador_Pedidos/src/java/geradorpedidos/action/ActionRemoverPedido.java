/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action;
import geradorpedidos.action.Action;
import geradorpedidos.dao.PedidoDAO;
import geradorpedidos.model.Pedido;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabinho
 */
public class ActionRemoverPedido implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      int id = Integer.parseInt(request.getParameter("id"));
		      Pedido pedido = new Pedido();
		pedido.setIdPedido(id);
		
		PedidoDAO pddao = new PedidoDAO();
		pddao.remover(id);
		
		System.out.println("Excluindo pedido ... ");
		
		request.setAttribute("mensagem", "Pedido removido com sucesso.");
		
		return "controller?action=ActionListarPedidos";
    }
    
}
