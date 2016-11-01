package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.NhanVienBO;

/**
 * Servlet implementation class ThemController
 */
@WebServlet("/ThemController")
public class ThemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		try {
			String manv = request.getParameter("manv");
			String tennv = request.getParameter("tennv");
			String ngaysinh = request.getParameter("ngaysinh");
			float hsl = Float.parseFloat(request.getParameter("hsl"));
			int phucap = Integer.parseInt(request.getParameter("phucap"));
			String madv = request.getParameter("madv");
			NhanVienBO nv = new NhanVienBO();
			nv.themnhanvien(manv, tennv, ngaysinh, hsl, phucap, madv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.getWriter().println("<html><body>"+e.getMessage()+"</body><html>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
