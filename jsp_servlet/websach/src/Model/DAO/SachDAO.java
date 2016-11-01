package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DungChung.CDungChung;
import Model.Bean.SachBean;

public class SachDAO {
	Connection cn ;
	public void KetNoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		cn = DriverManager.getConnection(CDungChung.url, CDungChung.un, CDungChung.pass);
	}
	
	public ArrayList<SachBean> getSach() throws Exception{
		KetNoi();
		String sql = "SELECT * FROM sach";
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();

		ArrayList<SachBean> ds = new ArrayList<SachBean>();
		
		while(r.next()){
			String masach = r.getString("masach");
			String tensach = r.getString("tensach");
			String tacgia = r.getString("tacgia");
			long gia = r.getLong("gia");
			String anh = r.getString("anh");
			SachBean s = new SachBean(masach,tensach,tacgia,gia,anh);
			ds.add(s);
		}
		r.close();
		return ds;
	}
	
	public ArrayList<SachBean> getSachPhanTrang(int limit ,int start) throws Exception{
		KetNoi();
		String sql =  "SELECT * FROM sach LIMIT " + start +"," + limit;
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();

		ArrayList<SachBean> ds = new ArrayList<SachBean>();
		
		while(r.next()){
			String masach = r.getString("masach");
			String tensach = r.getString("tensach");
			String tacgia = r.getString("tacgia");
			long gia = r.getLong("gia");
			String anh = r.getString("anh");
			SachBean s = new SachBean(masach,tensach,tacgia,gia,anh);
			ds.add(s);
		}
		r.close();
		return ds;

		
	}
	
	public ArrayList<SachBean> TimKiemSach(String tukhoa) throws Exception{
		KetNoi();
		//String sql = "SELECT * FROM sach WHERE tensach LIKE N" + "'%"+tukhoa+"%' OR  tacgia LIKE N'%"+tukhoa+"%'";
		String sql= "SELECT * FROM sach WHERE tensach LIKE N'%"+tukhoa+"%' OR tacgia LIKE N'%" +tukhoa+"%'";
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();

		ArrayList<SachBean> ds = new ArrayList<SachBean>();
		
		while(r.next()){
			String masach = r.getString("masach");
			String tensach = r.getString("tensach");
			String tacgia = r.getString("tacgia");
			long gia = r.getLong("gia");
			String anh = r.getString("anh");
			SachBean s = new SachBean(masach,tensach,tacgia,gia,anh);
			ds.add(s);
		}
		r.close();
		return ds;
	}
	
	public ArrayList<SachBean> TimKiemSachTheoMaLoai(String tukhoa) throws Exception{
		KetNoi();

		String sql= "SELECT * FROM sach WHERE maloai LIKE N'%"+tukhoa+"%'";
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();

		ArrayList<SachBean> ds = new ArrayList<SachBean>();
		
		while(r.next()){
			String masach = r.getString("masach");
			String tensach = r.getString("tensach");
			String tacgia = r.getString("tacgia");
			long gia = r.getLong("gia");
			String anh = r.getString("anh");
			SachBean s = new SachBean(masach,tensach,tacgia,gia,anh);
			ds.add(s);
		}
		r.close();
		return ds;
	}
	
	public SachBean getID(String id) throws Exception{
		KetNoi();
		String sql = "SELECT * FROM sach WHERE masach = '"+id+"'";
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();
		SachBean s = null;
		while(r.next()){
			String masach = r.getString("masach");
			String tensach = r.getString("tensach");
			String tacgia = r.getString("tacgia");
			long gia = r.getLong("gia");
			String anh = r.getString("anh");
			s = new SachBean(masach,tensach,tacgia,gia,anh);
		}
		return s;
	}

}

