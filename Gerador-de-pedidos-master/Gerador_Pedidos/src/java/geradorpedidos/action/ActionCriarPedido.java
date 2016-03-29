/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action;

import geradorpedidos.dao.PedidoDAO;
import geradorpedidos.model.Pedido;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabiano.eger
 */
public class ActionCriarPedido implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Pedido pedido = new Pedido();
        
        pedido.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
        pedido.setValorPedido(Double.parseDouble(request.getParameter("valorPedido")));

        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataPedido"));

        pedido.setDataPedido(data);
        PedidoDAO daopedido = new PedidoDAO();

        if (request.getParameter("id") != null) {
            int idPedido = Integer.parseInt(request.getParameter("id"));
            pedido.setIdPedido(idPedido);
            daopedido.atualizar(pedido);
            request.setAttribute("mensagem", "Pedido alterado com sucesso.");

        } else {
            daopedido.inserir(pedido);
            request.setAttribute("mensagem", "Pedido criado com sucesso");
        }

        return "controller?action=ActionListarPedidos";
    }

}
