package it.beije.oort.service;

import it.beije.oort.database.DatabaseController;
import it.beije.oort.model.IBibliotecaModel;
import it.beije.oort.utils.ListManagerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class AddService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void add(IBibliotecaModel obj,
                       HttpSession session,
                       Model model){
        log.info("Oggetto da aggiungere: " + obj);
        try{
            DatabaseController.insert(obj);
            model.addAttribute("added", true);
        } catch (Exception e){
            model.addAttribute("added", false);
            e.printStackTrace();
        }
        session.removeAttribute("addType");
    }

    public void preparePage(HttpSession session, HttpServletRequest request){
        request.getSession().removeAttribute("add");
        String type = request.getParameter("add");

        if (type != null && !type.equalsIgnoreCase("")) {
            request.getSession().setAttribute("add", type);
            ListManagerUtils.updateLists(session);
        }
    }


}
