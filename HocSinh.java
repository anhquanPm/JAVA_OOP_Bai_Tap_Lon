package bai_tap_lon;

import java.io.Serializable;
import java.util.Scanner;

import bai_tap_lon_2.DiemKhaoSat;

public class HocSinh extends DiemKhaoSat implements Serializable {
	transient Scanner sc = new Scanner(System.in);
	
	private String maHocSinh, hoTen, gioiTinh, ngaySinh, lop;
	public HocSinh(float diemToan, float diemVan, float diemAnh, String maHocSinh, String hoTen, String gioiTinh,
			String ngaySinh, String lop) {
		super(diemToan, diemVan, diemAnh);
		this.maHocSinh = maHocSinh;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.lop = lop;
	}
	public HocSinh() {
	}
	
	public String getMaHocSinh() {
		return maHocSinh;
	}
	
	void setMaHocSinh(String maHocSinh) {
		this.maHocSinh = maHocSinh;
	}
	
	public String getHoTen() {
		return hoTen;
	}
	
	void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	String getGioiTinh() {
		return gioiTinh;
	}
	
	void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
	String getNgaySinh() {
		return ngaySinh;
	}
	
	void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	String getLop() {
		return lop;
	}
	
	void setLop(String lop) {
		this.lop = lop;
	}
	
	public void nhap() {
		int lc = 0;
		System.out.print("Nhập mã học sinh: ");
		maHocSinh = sc.nextLine();
		System.out.print("Nhập họ và tên: ");
		hoTen = sc.nextLine();
		System.out.print("Nhập giới tính:  ");
		gioiTinh = sc.nextLine();
		System.out.print("Nhập ngày tháng năm sinh: ");
		ngaySinh = sc.nextLine(); 
		System.out.print("Nhập lớp: ");
		lop = sc.nextLine();
		super.nhap();
	}
	
	public void xuat() {
		System.out.printf("%10s", maHocSinh);
		System.out.printf("%20s", hoTen);
		System.out.printf("%20s", gioiTinh);
		System.out.printf("%21s", ngaySinh);
		System.out.printf("%10s", lop);
		super.xuat();
	}
}
