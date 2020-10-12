package it.beije.oort.service;

import it.beije.oort.database.DatabaseController;
import it.beije.oort.model.IBibliotecaModel;
import it.beije.oort.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class AddService {
    public void add(IBibliotecaModel obj,
                       HttpSession session,
                       Model model){
        try{
            DatabaseController.insert(obj);
            model.addAttribute("added", true);
        } catch (Exception e){
            model.addAttribute("added", false);
            e.printStackTrace();
        }
        session.removeAttribute("addType");
    }

    public void preparePage(HttpSession session, HttpServletRequest request, Model model){
        request.getSession().removeAttribute("add");
        String type = request.getParameter("add");

        if (type != null && !type.equalsIgnoreCase("")) {
            request.getSession().setAttribute("add", type);
            updateLists(session);
        }
    }

    public void updateLists(HttpSession session){
        session.setAttribute("autori", DatabaseController.getAllAutori());
        session.setAttribute("editori", DatabaseController.getAllEditori());
        session.setAttribute("utenti", DatabaseController.getAllUtenti());
        session.setAttribute("libri", DatabaseController.getAllLibri());
    }
}
