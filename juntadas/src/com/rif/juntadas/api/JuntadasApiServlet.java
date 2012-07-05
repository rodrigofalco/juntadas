package com.rif.juntadas.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rif.juntadas.jdo.PMF;
import com.rif.juntadas.model.UserGroup;
import com.rif.juntadas.util.FormatUtils;

@SuppressWarnings("serial")
public class JuntadasApiServlet extends HttpServlet {
	
	public static final String LIST_GROUPS = "groups/list";
	
	private static final Logger log = Logger.getLogger(JuntadasApiServlet.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String requestedUri = req.getRequestURI().substring(5);
		log.severe(requestedUri);
		
		resp.setContentType("text/plain");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		if (LIST_GROUPS.equals(requestedUri)) {
			log.info("listing groups..");
			Query query = pm.newQuery(UserGroup.class);
			query.setOrdering("creationDate desc");

			List<GroupResult> result = new ArrayList<GroupResult>();
			try {
				@SuppressWarnings("unchecked")
				List<UserGroup> groups = (List<UserGroup>) query.execute();
				if (!groups.isEmpty()) {
					for (UserGroup g : groups) {
						result.add(new GroupResult(g.getName(), g.getDescription(), FormatUtils.shortDate(g.getCreationDate())));
					}
				}
			} finally {
				query.closeAll();
			}
			
			ApiResponse response = new ApiResponse(ApiResponse.Status.OK, result);
			resp.getWriter().println(response.toJson());
		} else {
			resp.getWriter().println("Hello, world");

		}

	}
	
	class GroupResult {
		public String name;
		public String description;
		public String creationDate;
		
		GroupResult(String name, String description, String creationDate) {
			this.name = name;
			this.description = description;
			this.creationDate = creationDate;
		}
	}
}
