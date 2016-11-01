package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BO.GioHangBO;
import Model.BO.SachBO;
import Model.Bean.HangBean;
import Model.Bean.SachBean;

/**
 * Servlet implementation class DatMuaHangController
 */
@WebServlet("/DatMuaHangController")
public class DatMuaHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatMuaHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String maSach =(String) request.getParameter("ID");
		
		boolean OK = true;
		int j = 0;
		
		SachBO s = new SachBO();
		GioHangBO gh = new GioHangBO();
		


		List<HangBean> lstHang = null;
		if(session.getAttribute("giohang") == null){
			session.setAttribute("giohang",gh);
		}

		try {

			SachBean sach = s.getID(maSach);
			
			gh = (GioHangBO)session.getAttribute("giohang");




			String action = request.getParameter("action");
			//Sua hang
			//session.setAttribute("kt", action);
			if(action != null){
				if(action.equals("sua")){
					
					long soluong = Long.parseLong(request.getParameter("soluong"));
					gh.Sua(maSach, soluong);
					
				}else if(action.equals("xoa")){
					gh.Xoa(maSach);
				}
			}else{

				for(int i = 0; i < gh.ds.size(); i++){
					if(gh.ds.get(i).getMahang().equals(maSach)){
						gh.ds.get(i).setSoluong(gh.ds.get(i).getSoluong() + 1);
						OK = false;
					}
				}
				
				if(OK){
					gh.Them(sach.getMasach(), sach.getTensach(), sach.getGia(), 1);				
				}
			}
			lstHang = gh.ds;


	
			session.setAttribute("giohang", gh);
			
			request.setAttribute("lstHang", lstHang);
			request.setAttribute("tongtien", gh.TongTien());
			
			RequestDispatcher rd = request.getRequestDispatcher("DatMuaHangView.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			session.setAttribute("giohang", "Sai cmnr");
		}
		
		response.sendRedirect("DatMuaHangView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
