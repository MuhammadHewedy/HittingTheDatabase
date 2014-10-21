package com.me.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.me.model.users.User;
import com.me.service.InventoryService;
import com.me.service.UserService;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletContext());

		UserService userService = context.getBean("userService",
				UserService.class);
		InventoryService inventoryService = context.getBean("inventoryService",
				InventoryService.class);

		String name = request.getParameter("name");
		if (name != null && !name.isEmpty()) {

			User user = new User();
			user.setName(name);
			userService.addUser(user);

			List<User> users = userService.listUsers();

			for (User u : users) {
				response.getWriter().println(u);
			}

			inventoryService.incrementUsersCount();
			response.getWriter().println(
					"*************************************");
			response.getWriter().println(
					"Total Users count: "
							+ inventoryService.getTotalUsersCount());

		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,
					"name parameter required.");
		}
	}

}
