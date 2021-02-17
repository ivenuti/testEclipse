package it.davincifascetti.quintainfa.venuti;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletController
 */
@WebServlet({ "/ServletController", "/index.jsp" })
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomePagina = "sceltaLingua.jsp";
		String lingua = null;
		Cookie[] c = request.getCookies();
		if (c!=null) {
			for(int i=0; i<c.length; i++) {
				if (c[i].getName().equals("lingua")) {
					lingua = c[i].getValue();
				}
			}
		}
		if (request.getParameter("lingua")!=null) {
			lingua = request.getParameter("lingua");
		}
		if (lingua!=null) {
			
			if(lingua.equals("i")) {
				nomePagina = "italiano.jsp";
			}else {
				nomePagina = "english.jsp";
			}
			Cookie linguaScelta = new Cookie("lingua", lingua);
			response.addCookie( linguaScelta );
		}
		if (request.getParameter("pagina")!=null) {
			nomePagina = request.getParameter("pagina")+".jsp";
		}
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/"+nomePagina);
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
