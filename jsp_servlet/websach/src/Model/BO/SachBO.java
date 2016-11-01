package Model.BO;

import java.util.ArrayList;

import Model.Bean.SachBean;
import Model.DAO.SachDAO;

public class SachBO {
	SachDAO s = new SachDAO();
	public ArrayList<SachBean> getSach() throws Exception{
		return s.getSach();
	}
	public ArrayList<SachBean> TimKiemSach(String tukhoa) throws Exception{
		return s.TimKiemSach(tukhoa);
	}
	
	public ArrayList<SachBean> TimKiemSachTheoMaLoai(String tukhoa) throws Exception{
		return s.TimKiemSachTheoMaLoai(tukhoa);
	}
	
	public SachBean getID(String id) throws Exception{
		return s.getID(id);
	}
	
	public ArrayList<SachBean> getSachPhanTrang(int limit, int start) throws Exception{
		return s.getSachPhanTrang(limit, start);
	}

}
