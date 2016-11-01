package Model.BO;

import Model.DAO.DangNhapDAO;

public class DangNhapBO {
	DangNhapDAO dn = new DangNhapDAO();
	
	public boolean KTDangNhap(String email,String pass) throws Exception
	{
		return dn.KTDangNhap(email, pass);
	}
}
