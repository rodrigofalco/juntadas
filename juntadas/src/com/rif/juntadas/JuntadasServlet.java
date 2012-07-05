package com.rif.juntadas;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class JuntadasServlet extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(JuntadasServlet.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		log.severe(req.getRequestURI());
		/*
		PersistenceManager pm = PMF.get().getPersistenceManager();
        UserGroup group1 = new UserGroup("Roca2", "Grupo de roca 2");
        UserGroup group2 = new UserGroup("Psys2", "Grupo de psys 2");

        try {
            pm.makePersistent(group1);
            pm.makePersistent(group2);
        } finally {
            pm.close();
        }*/
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
