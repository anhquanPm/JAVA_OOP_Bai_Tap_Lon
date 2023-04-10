package bai_tap_lon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class BangDiemKhaoSat implements Serializable {
	transient Scanner sc = new Scanner(System.in);
	
	private String tenKhoi, hocKi, ngayThi, giaoVien; 
	static String kiThi = "Khảo sát chất lượng 3 môn toán văn anh";
	private String namHoc;
	private ArrayList<HocSinh>dshs;
	
	public BangDiemKhaoSat(String tenKhoi, String hocKi, String ngayThi, String giaoVien, String namHoc,
			ArrayList<HocSinh> hs) {
		this.tenKhoi = tenKhoi;
		this.hocKi = hocKi;
		this.ngayThi = ngayThi;
		this.giaoVien = giaoVien;
		this.namHoc = namHoc;
		this.dshs = hs;
	}

	public BangDiemKhaoSat() {
	}

	public String getTenKhoi() {
		return tenKhoi;
	}

	void setTenKhoi(String tenKhoi) {
		this.tenKhoi = tenKhoi;
	}

	String getHocKi() {
		return hocKi;
	}

	void setHocKi(String hocKi) {
		this.hocKi = hocKi;
	}

	String getNgayThi() {
		return ngayThi;
	}
	void setNgayThi(String ngayThi) {
		this.ngayThi = ngayThi;
	}

	String getGiaoVien() {
		return giaoVien;
	}
	
	void setGiaoVien(String giaoVien) {
		this.giaoVien = giaoVien;
	}

	static String getKiThi() {
		return kiThi;
	}

	static void setKiThi(String kiThi) {
		BangDiemKhaoSat.kiThi = kiThi;
	}

	String getNamHoc() {
		return namHoc;
	}

	void setNamHoc(String namHoc) {
		this.namHoc = namHoc;
	}
	
	public void nhap() {
		int n;
		System.out.print("Nhập tên khối: ");
		tenKhoi = sc.nextLine();
		System.out.print("Nhập học kì: ");
		hocKi = sc.nextLine();
		System.out.print("Nhập ngày thi: ");
		ngayThi = sc.nextLine();
		System.out.print("Nhập năm học: ");
		namHoc = sc.nextLine();
		sc.nextLine();
		System.out.print("Nhập tên giáo viên coi phòng thi: ");
		giaoVien = sc.nextLine();
		System.out.print("Nhập số lượng học sinh: ");
		n = sc.nextInt();
		dshs =  new ArrayList<HocSinh>();
		for(int i = 0; i < n; i++) {
			HocSinh hs = new HocSinh();
			hs.nhap();
			dshs.add(hs);
		}
	}
	
	public void xuat() {
		System.out.printf("\n Tên khối:%2s - Học kì:%2s", tenKhoi, hocKi);
		System.out.printf("\n Ngày thi:%10s - Năm học:%5s", ngayThi, namHoc);
		System.out.printf("\n Kì thi:%10s", kiThi);
		System.out.printf("\n Giáo viên coi thi:%10s", giaoVien);
		System.out.println();
		System.out.printf("%10s","MÃ HỌC SINH");
		System.out.printf("%20s", "HỌ VÀ TÊN");
		System.out.printf("%20s", "GIỚI TÍNH");
		System.out.printf("%20s", "NGÀY SINH");
		System.out.printf("%10s", "LỚP");
		System.out.printf("%15s", "Toán");
		System.out.printf("%15s", "Văn");
		System.out.printf("%15s","TAnh");
		System.out.printf("%15s","Điểm TB");
		System.out.println();
		for (HocSinh hocSinh : dshs) {
			hocSinh.xuat();
			System.out.println();
		}
	}
	
	public int soLuongHocSinhTruotKhaoSat() {
		int dem = 0;
		for (HocSinh hocSinh : dshs) {
			if(hocSinh.tinhDiemTrungBinh() < 5) {
				dem++;
			}
		}
		return dem;
	}
	
	public int laySoLuongHocSinh() {
		return dshs.size();
	}
	
	public void tenHocSinhTruotKhaoSat() {
		for (HocSinh hocSinh : dshs) {
			if(hocSinh.tinhDiemTrungBinh() < 5) {
				System.out.println(hocSinh.getHoTen());
				
			}
		}
	}
	
	public void themHocSinh() {
		HocSinh hs = new HocSinh();
		hs.nhap();
		dshs.add(hs);
	}
	
	public void sapXepHocSinhGiamDanTheoDiemTrungBinh() {
		Collections.sort(this.dshs, new Comparator<HocSinh>() {

			@Override
			public int compare(HocSinh hs1, HocSinh hs2) {
				if(hs1.tinhDiemTrungBinh() < hs2.tinhDiemTrungBinh()) {
					return 1;
				}else if (hs1.tinhDiemTrungBinh()>hs2.tinhDiemTrungBinh()){
					return -1;
				}else {
					return 0;
				}
			}
		});
	}
	
	public void xoaHocSinhTheoMaHocSinh() {
		sc.nextLine();
		System.out.print("Nhập mã học sinh cần xóa: ");
		String maHs = sc.nextLine();
		int dem = 0;
		for (HocSinh hocSinh : dshs) {
			if(hocSinh.getMaHocSinh().equals(maHs)==true) {
				dem++;
				dshs.remove(hocSinh);
				break;
			}
		}
		if(dem==0) {
			System.out.println("Không có mã học sinh: "+maHs+" trong danh sách!!!");
		}
	}
	
	public void suaThongTinHocSinhTheoMaHocSinh() {
		sc.nextLine();
		System.out.print("Nhập mã học sinh cần sửa: ");
		String maHs = sc.nextLine();
		int dem = 0;
		for (HocSinh hocSinh : dshs) {
			if(hocSinh.getMaHocSinh().equals(maHs)==true) {
				hocSinh.nhap();
				dem++;
				break;
			}
		}
		if(dem==0) {
			System.out.println("Không có mã học sinh: "+maHs+" trong danh sách!!!");
		}
	}
	
	public void timKiemHocSinhTheoTen() {
		sc.nextLine();
		System.out.print("Nhập tên học sinh cần tìm: ");
		String ten = sc.nextLine();
		int dem=0;
		System.out.printf("%10s","MÃ HỌC SINH");
		System.out.printf("%20s", "HỌ VÀ TÊN");
		System.out.printf("%20s", "GIỚI TÍNH");
		System.out.printf("%20s", "NGÀY SINH");
		System.out.printf("%10s", "LỚP");
		System.out.printf("%15s", "Toán");
		System.out.printf("%15s", "Văn");
		System.out.printf("%15s","TAnh");
		System.out.printf("%15s","Điểm TB");
		System.out.println();
		for (HocSinh hocSinh : dshs) {
			if(hocSinh.getHoTen().indexOf(ten)>=0) {
				hocSinh.xuat();
				System.out.println();
				dem++;
				break;
			}
		}
			
			if (dem==0) {
				System.out.println("Không tìm thấy học sinh nào");
				System.out.println();
			}
	}
}

