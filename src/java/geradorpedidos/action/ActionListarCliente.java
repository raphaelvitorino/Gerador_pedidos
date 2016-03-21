/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action;

import geradorpedidos.dao.ClienteDAO;
import geradorpedidos.model.Cliente;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class ActionListarCliente implements Action{
    
    @Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Cliente> clientes = new ClienteDAO().getClientes();
		
		request.setAttribute("cliente", clientes);
		
		return "/WEB-INF/jsp/listarClientes.jsp";
	}
    
}
