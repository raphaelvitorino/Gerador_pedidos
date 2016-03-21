/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action;

import geradorpedidos.dao.ItemDAO;
import geradorpedidos.model.Item;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raphael
 */
public class ActionListarItem implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Item> itens = new ItemDAO().getItens();
        request.setAttribute("item", itens);
        return "/WEB-INF/jsp/listarItens.jsp";
    }

}
