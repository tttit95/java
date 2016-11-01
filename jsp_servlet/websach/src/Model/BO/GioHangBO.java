package Model.BO;

import java.util.ArrayList;
import java.util.List;

import Model.Bean.HangBean;

public class GioHangBO {
	public  List<HangBean> ds;
	
	public GioHangBO(){
		ds = new ArrayList<HangBean>();
	}
	
	public void Them(String mahang, String tenhang,long gia,long soluong )
	{
		HangBean  h = new HangBean(mahang,tenhang,gia,soluong);
		
		ds.add(h);


	}
	
	public void Sua(String mahang,long soluong)
	{
		for(int i = 0;i< ds.size(); i++){
			if(ds.get(i).getMahang().equals(mahang)){
				ds.get(i).setSoluong(soluong);
			}
		}

	}
	public void Xoa(String mahang){
		for(int i = 0;i< ds.size(); i++){
			if(ds.get(i).getMahang().equals(mahang)){
				ds.remove(i);
			}
		}
	}
	
	public long TongTien(){
		long tongtien = 0;
		for(int i = 0;i< ds.size(); i++){
			tongtien = tongtien + ds.get(i).getGia() * ds.get(i).getSoluong();
		}	
		return tongtien;
	}
}
