package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DungChung.CDungChung;
import Model.Bean.NhanVienBean;


public class NhanVienDAO {
	Connection cn ;
	public void KetNoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		cn = DriverManager.getConnection(CDungChung.url, CDungChung.un, CDungChung.pass);
	}
	//hien thi nhan vien theo don vi
	public ArrayList<NhanVienBean> layNhanVienTheoDonVi(String madv) throws Exception{
		KetNoi();
		String sql = "SELECT * FROM NhanVien WHERE Madv = " + "'"+madv+"'";
		//String sql = "SELECT * FROM NhanVien";
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();

		ArrayList<NhanVienBean> ds = new ArrayList<NhanVienBean>();
		
		while(r.next()){
			String manv = r.getString("Manv");
			String tennv = r.getString("Tennv");
			String ngaysinh = r.getString("Ngaysinh");
			float hsl = r.getFloat("hsl");
			int phucap = r.getInt("Phucap");
			NhanVienBean s = new NhanVienBean(manv,tennv,ngaysinh,hsl,phucap,madv);
			ds.add(s);
		}
		r.close();
		return ds;
	}
	//String sql= "SELECT * FROM sach WHERE tensach LIKE N'%"+tukhoa+"%' OR tacgia LIKE N'%" +tukhoa+"%'";
	public ArrayList<NhanVienBean> timkiem(String tukhoa) throws Exception{
		KetNoi();
		String sql= "SELECT * FROM NhanVien WHERE Tennv LIKE N'%"+tukhoa+"%' OR Madv LIKE N'%" +tukhoa+"%'";
		//String sql = "SELECT * FROM NhanVien";
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();

		ArrayList<NhanVienBean> ds = new ArrayList<NhanVienBean>();
		
		while(r.next()){
			String manv = r.getString("Manv");
			String tennv = r.getString("Tennv");
			String ngaysinh = r.getString("Ngaysinh");
			float hsl = r.getFloat("hsl");
			int phucap = r.getInt("Phucap");
			String madv = r.getString("Madv");
			NhanVienBean s = new NhanVienBean(manv,tennv,ngaysinh,hsl,phucap,madv);
			ds.add(s);
		}
		r.close();
		return ds;
	}
	
	public void themnhanvien(String manv,String tennv,String ngaysinh,float hsl, int phucap,String madv) throws Exception{
		KetNoi();
		
		String sql = "INSERT INTO NhanVien VALUES ("
				+ "'" + manv+ "'"+","
				+ "'"+tennv+"'"+","
				+ "'"+ngaysinh+"'"+","
				+ hsl+","
				+ phucap+","
				+ "'"+madv+"'"
				+ ")";
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();
		r.close();

	}
}
