package it.beije.oort.utils;

import it.beije.oort.database.DatabaseController;

import javax.servlet.http.HttpSession;

public class ListManagerUtils {
    public static void updateLists(HttpSession session){
        session.setAttribute("autori", DatabaseController.getAllAutori());
        session.setAttribute("editori", DatabaseController.getAllEditori());
        session.setAttribute("utenti", DatabaseController.getAllUtenti());
        session.setAttribute("libri", DatabaseController.getAllLibri());
    }
}
