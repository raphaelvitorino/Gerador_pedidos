/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author fabiano.eger
 */
public class ActionFactory {

    public static Action getAction(HttpServletRequest request)
            throws ServletException {

        String parameter = request.getParameter("action");
        String className = "geradorpedidos.action." + parameter;

        try {

            Class<?> clazz = Class.forName(className);
            Action action = (Action) clazz.newInstance(); // Action action = (Action) new ActionListaContatos();

            return action;
        } catch (Exception e) {
            throw new ServletException("A ActionFactory causou uma exceção", e);
        }
    }

}
