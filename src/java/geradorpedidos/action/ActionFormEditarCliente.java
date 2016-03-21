package geradorpedidos.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import geradorpedidos.dao.ClienteDAO;
import geradorpedidos.model.Cliente;

public class ActionFormEditarCliente implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String strId = request.getParameter("idcliente");

        Cliente cliente = new Cliente();

        if (strId != null) {
            int id = Integer.parseInt(strId);
            ClienteDAO dao = new ClienteDAO();
            cliente = dao.getClienteById(id);
        }

        request.setAttribute("cliente", cliente);

        return "/WEB-INF/jsp/adicionarClientes.jsp";

    }

}
