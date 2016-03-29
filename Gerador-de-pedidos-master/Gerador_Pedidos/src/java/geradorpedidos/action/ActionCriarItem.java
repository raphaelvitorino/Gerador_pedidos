package geradorpedidos.action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import geradorpedidos.dao.ItemDAO;
import geradorpedidos.model.Item;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabiano
 */
public class ActionCriarItem implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Item item = new Item();
        int idpedido = Integer.parseInt(request.getParameter("idpedido"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        item.setQuantidade(quantidade);
        item.setIdPedido(idpedido);

        ItemDAO dao = new ItemDAO();

        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            item.setIdItem(id);
            dao.atualizar(item);
            request.setAttribute("item", "alterado");

        } else {
            dao.inserir(item);
            request.setAttribute("item", "criado");
        }

        return "controller?action=ActionListarItens";
    }
}
