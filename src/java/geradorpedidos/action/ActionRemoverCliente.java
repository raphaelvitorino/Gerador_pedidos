/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action;

import geradorpedidos.dao.ClienteDAO;
import geradorpedidos.model.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class ActionRemoverCliente implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("idcliente"));
		      Cliente cliente = new Cliente();
		cliente.setIdCliente(id);
		
		ClienteDAO daocl = new ClienteDAO();
		daocl.remover(id);
		
		System.out.println("Excluindo cliente ... ");
		
		request.setAttribute("mensagem", "Cliente removido com sucesso.");
		
		return "controller?action=ActionListarCliente";
    }
    
}
