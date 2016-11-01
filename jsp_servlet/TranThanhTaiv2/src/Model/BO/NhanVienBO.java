package Model.BO;

import java.util.ArrayList;

import Model.Bean.NhanVienBean;
import Model.DAO.NhanVienDAO;

public class NhanVienBO {
	NhanVienDAO nv = new NhanVienDAO();
	public ArrayList<NhanVienBean> layNhanVienTheoDonVi(String madv) throws Exception{
		return nv.layNhanVienTheoDonVi(madv);
	}
}
