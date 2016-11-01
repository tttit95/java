package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BO.DangNhapBO;
import Model.BO.LoaiBO;
import Model.BO.SachBO;
import Model.Bean.LoaiBean;
import Model.Bean.SachBean;

/**
 * Servlet implementation class SachServlet
 */
@WebServlet("/SachServlet")
public class SachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SachServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("utf-8");
			
			SachBO s = new SachBO();
			ArrayList<SachBean> sach = s.getSach();
			
			LoaiBO l = new LoaiBO();
			ArrayList<LoaiBean> loai = l.getLoai();
			
			DangNhapBO dn = new DangNhapBO();
			
			//phantrang
			
			int current_page;
			if(request.getParameter("page") == null)
				current_page = 1;
			else
				current_page = Integer.parseInt(request.getParameter("page"));
				
			int total_record;
			int limit = 12;
			int start = (current_page - 1) * limit;
			
			
			//end phan trang
			
			
			
			
			
			//tim kiem
			String tukhoa = (String) request.getParameter("search");
			String theloai = (String) request.getParameter("ml");
			if(request.getParameter("search") != null)
			{
				sach = s.TimKiemSach(tukhoa);
			}else if(request.getParameter("ml") != null)
			{
				//request.setAttribute("hienthi", request.getParameter("search"));
				sach = s.TimKiemSachTheoMaLoai(theloai);
			}else{
				sach = s.getSach();
			}

			total_record = sach.size();
			int total_page = (int) Math.ceil(total_record/limit);
			int config[] = {total_record,total_page,current_page,start,limit};
			
			
			 //dang nhap
			HttpSession session = request.getSession();
			String email = request.getParameter("Email");
			String pass = request.getParameter("Password");
			if(email != null && pass != null){
				if(dn.KTDangNhap(email, pass)){
					session.setAttribute("info", email);
				}
				
			}
			
			if(request.getParameter("DangXuat") != null){
				session.removeAttribute("info");
				response.sendRedirect("SachServlet");
			}
			
			
			//ket thuc dang nhap
			
			
			//truyen bien sang trang sjp
			request.setAttribute("config",config );
			request.setAttribute("lstSach", sach);
			request.setAttribute("lstLoai", loai);

	
			RequestDispatcher rd = request.getRequestDispatcher("Sach.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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
