package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KadaiDAO;
import dto.Kadai;
import util.GenerateHashedPw;

/**
 * Servlet implementation class KadaiLoginServlet
 */
@WebServlet("/KadaiLoginServlet")
public class KadaiLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KadaiLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String mail = request.getParameter("mail");
		String pw = request.getParameter("pw");
		
		String salt = KadaiDAO.getSalt(mail);
		
		if(salt == null) {
			String path = "WEB-INF/view/kadai-login.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
		
		String hashedPw = GenerateHashedPw.getSafetyPassword(pw, salt);
		
		Kadai kadai = KadaiDAO.login(mail, hashedPw);
		String path = "";
		if(kadai == null) {
			path = "WEB-INF/view/kadai-login.jsp";
		} else {
			path = "WEB-INF/view/sample-menu.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
