package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DungChung.CDungChung;
import Model.Bean.SachBean;

public class DangNhapDAO {
	Connection cn ;
	public void KetNoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		cn = DriverManager.getConnection(CDungChung.url, CDungChung.un, CDungChung.pass);
	}
	
	public boolean KTDangNhap(String email, String pass) throws Exception{
		KetNoi();
		String sql = "SELECT * FROM KhachHang WHERE Tendn = '" + email + "' AND Pass = '"+ pass +"'";
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();


		boolean kq = r.next();
		r.close();
		return kq;
	}
}
