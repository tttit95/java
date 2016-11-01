package Model.BO;

import java.util.ArrayList;

import Model.Bean.LoaiBean;
import Model.Bean.SachBean;
import Model.DAO.LoaiDAO;
import Model.DAO.SachDAO;

public class LoaiBO {
	LoaiDAO l = new LoaiDAO();
	public ArrayList<LoaiBean> getLoai() throws Exception{
		return l.getLoai();
	}
	
	
	
}
