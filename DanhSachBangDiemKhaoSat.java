package bai_tap_lon;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class DanhSachBangDiemKhaoSat implements Serializable  {
	private ArrayList<BangDiemKhaoSat> dsbd;
	transient Scanner sc = new Scanner(System.in);

	
	
	public DanhSachBangDiemKhaoSat() {
	}

	public void nhapDsbd() {
		int n;
		System.out.print("Nhập số lượng bảng điểm: ");
		n = sc.nextInt();
		dsbd = new ArrayList<BangDiemKhaoSat>();
		for (int i = 0; i < n; i++) {
			BangDiemKhaoSat bd = new BangDiemKhaoSat();
			bd.nhap();
			dsbd.add(bd);
		}
	}
	
	public void inDsbd() {
		System.out.println("\nIN DANH SÁCH BẢNG ĐIỂM");
		for (BangDiemKhaoSat bangDiemKhaoSat : dsbd) {
			bangDiemKhaoSat.xuat();
			System.out.println();
		}
	}
	
	public void soLuongHocSinhQuaVaTruotKhaoSat() {
		int tong = 0;
		for (BangDiemKhaoSat bangDiemKhaoSat : dsbd) {
			tong = tong + bangDiemKhaoSat.soLuongHocSinhTruotKhaoSat();
		}
		System.out.println("Số lượng học sinh trượt khảo sát là: "+tong);
		System.out.println("Số lượng học sinh vượt qua khảo sát là: "+(laySoLuongHocSinhTrongDanhSach()-tong));
		
	}
	
	public int laySoLuongHocSinhTrongDanhSach() {
		int tong = 0;
		for (BangDiemKhaoSat bangDiemKhaoSat : dsbd) {
			tong =  tong + bangDiemKhaoSat.laySoLuongHocSinh();
		}
		return tong;
	}
	
	public void danhSachHocSinhTruotKhaoSat() {
		for (BangDiemKhaoSat bangDiemKhaoSat : dsbd) {
			bangDiemKhaoSat.tenHocSinhTruotKhaoSat();
		}
	}
	
	public void themHocSinhVaoDanhSach() {
		sc.nextLine();
		int dem = 0;
		System.out.print("Học sinh cần thêm thuộc khối nào: ");
		String khoi = sc.nextLine();
		for (BangDiemKhaoSat bangDiemKhaoSat : dsbd) {
			if (bangDiemKhaoSat.getTenKhoi().equals(khoi) == true) {
				bangDiemKhaoSat.themHocSinh();
				dem++;
				break;
			}
		}
		if (dem == 0) {
			System.out.println("Không có khối nào thỏa mãn khối bạn đã nhập");
		}
	}

	public void sapXepHocSinhTheoGiamDanTheoDiemTrungBinh() {
		for (BangDiemKhaoSat bangDiemKhaoSat : dsbd) {
			bangDiemKhaoSat.sapXepHocSinhGiamDanTheoDiemTrungBinh();
		}
	}
	
	public void lamRongToanBoDanhSach() {
		this.dsbd.removeAll(dsbd);
	}
	
	public void xoaHocSinhTheoMaHocSinh() {
		sc.nextLine();
		System.out.print("Nhập khối của học sinh cần xóa: ");
		String khoi = sc.nextLine();
		int dem = 0;
		for (BangDiemKhaoSat bangDiemKhaoSat : dsbd) {
			if(bangDiemKhaoSat.getTenKhoi().equals(khoi)==true) {
			bangDiemKhaoSat.xoaHocSinhTheoMaHocSinh();
			dem++;
			break;
			}
		}
		if(dem==0) {
			System.out.println("Không có khối nào thỏa mãn khối bạn vừa nhập");
			System.out.println();
		}
	}
	
	public void suaThongTinHocSinhTheoMaHocSinh() {
		sc.nextLine();
		System.out.print("Nhập khối của học sinh cần sửa: ");
		String khoi = sc.nextLine();
		int dem = 0;
		for (BangDiemKhaoSat bangDiemKhaoSat : dsbd) {
			if(bangDiemKhaoSat.getTenKhoi().equals(khoi)==true) {
			bangDiemKhaoSat.suaThongTinHocSinhTheoMaHocSinh();
			dem++;
			break;
			}
		}
		if(dem==0) {
			System.out.println("Không có khối nào thỏa mãn khối bạn vừa nhập");
			System.out.println();
		}
	}
	
	public void timKiemhHocSinhTheoTenVaKhoi() {
		sc.nextLine();
		System.out.print("Nhập khối của học sinh cần tìm: ");
		String khoi = sc.nextLine();
		int dem = 0;
		for (BangDiemKhaoSat bangDiemKhaoSat : dsbd) {
			if (bangDiemKhaoSat.getTenKhoi().equals(khoi) == true) {
				bangDiemKhaoSat.timKiemHocSinhTheoTen();
				dem++;
				break;
			}
		}
		if(dem==0) {
			System.out.println("Không có khối nào thỏa mãn khối bạn vừa nhập");
			System.out.println();
		}

	}
	
	public  void ghiFile() throws IOException {
		File f =  new File("danhsachbangdiem.dat");
		FileOutputStream fout = new FileOutputStream(f);
		ObjectOutputStream objout = new ObjectOutputStream(fout);
		objout.writeObject(dsbd);
		objout.close();
		fout.close();
	}
	
	public void docFile() throws ClassNotFoundException, IOException {
		dsbd = new ArrayList<BangDiemKhaoSat>();
		File f = new File("danhsachbangdiem.dat");
		FileInputStream fin = new FileInputStream(f);
		ObjectInputStream objin = new ObjectInputStream(fin);
		dsbd = (ArrayList<BangDiemKhaoSat>) objin.readObject();
		objin.close();
		fin.close();
	}
}
