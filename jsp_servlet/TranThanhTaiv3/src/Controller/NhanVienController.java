package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.NhanVienBO;
import Model.Bean.NhanVienBean;

/**
 * Servlet implementation class NhanVienController
 */
@WebServlet("/NhanVienController")
public class NhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NhanVienController() {
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
				if(request.getParameter("timkiem") != null){
					String madv = request.getParameter("timkiem");
					
					NhanVienBO nv = new NhanVienBO();
					ArrayList<NhanVienBean> lstNhanVien = nv.timkiem(madv);
				
				
				//truyen bien sang tranthanhtai.jsp
					request.setAttribute("kt", "dung");
					request.setAttribute("lstNhanVien", lstNhanVien);
					RequestDispatcher rd = request.getRequestDispatcher("TranThanhTai.jsp");
					
					rd.forward(request, response);
				}
			} catch (Exception e) {
/*				request.setAttribute("kt", "sai");
RequestDispatcher rd = request.getRequestDispatcher("TranThanhTai.jsp");
				
				rd.forward(request, response);*/
				// TODO Auto-generated catch block
				//e.printStackTrace();
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
