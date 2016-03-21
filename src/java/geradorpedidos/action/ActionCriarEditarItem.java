/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action;

import geradorpedidos.dao.ItemDAO;
import geradorpedidos.model.Item;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raphael
 */
public class ActionCriarEditarItem implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Item item = new Item();
        int idpedido = Integer.parseInt(request.getParameter("idpedido"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        item.setIdPedido(idpedido);
        item.setQuantidade(quantidade);

        ItemDAO dao = new ItemDAO();

        if (request.getParameter("iditem") != null) {
            int id = Integer.parseInt(request.getParameter("iditem"));
            item.setIdItem(id);
            dao.atualizar(item);
            request.setAttribute("item", "alterado");

        } else {
            dao.inserir(item);
            request.setAttribute("item", "criado");
        }

        return "controller?action=ActionListarItem"; // aqui pode dar erro, SE DER ERRO, coloque:
        //   geradorpedido.action?action=ActionListarItem
        // e faça o mesmo com as outras actions
    }
}
