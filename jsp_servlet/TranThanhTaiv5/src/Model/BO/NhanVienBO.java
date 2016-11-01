package Model.BO;

import java.util.ArrayList;

import Model.Bean.NhanVienBean;
import Model.DAO.NhanVienDAO;

public class NhanVienBO {
	NhanVienDAO nv = new NhanVienDAO();
	public ArrayList<NhanVienBean> layNhanVienTheoDonVi(String madv) throws Exception{
		return nv.layNhanVienTheoDonVi(madv);
	}
	public ArrayList<NhanVienBean> timkiem(String tukhoa) throws Exception{
		return nv.timkiem(tukhoa);
	}
	public void themnhanvien(String manv,String tennv,String ngaysinh,float hsl, int phucap,String madv) throws Exception{
		 nv.themnhanvien(manv, tennv, ngaysinh, hsl, phucap, madv);
	}
}
