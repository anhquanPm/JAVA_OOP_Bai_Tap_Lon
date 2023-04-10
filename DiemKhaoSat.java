package bai_tap_lon;

import java.io.Serializable;
import java.util.Scanner;

public class DiemKhaoSat implements Serializable  {
	transient Scanner sc = new Scanner(System.in);
	private float diemToan, diemVan, diemAnh;

	public DiemKhaoSat(float diemToan, float diemVan, float diemAnh) {
		this.diemToan = diemToan;
		this.diemVan = diemVan;
		this.diemAnh = diemAnh;
	}

	public DiemKhaoSat() {
	}

	float getDiemToan() {
		return diemToan;
	}

	void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}

	float getDiemVan() {
		return diemVan;
	}

	void setDiemVan(float diemVan) {
		this.diemVan = diemVan;
	}

	float getDiemAnh() {
		return diemAnh;
	}

	void setDiemAnh(float diemAnh) {
		this.diemAnh = diemAnh;
	}
	
	public void nhap() {
		System.out.print("Nhập điểm toán: ");
		diemToan = sc.nextFloat();
		while(diemToan < 0 || diemToan > 10) {
			System.err.println("Lỗi, vui lòng nhập điểm có giá trị từ 0 đến 10");
			sc.nextLine();
			System.out.print("Nhập điểm toán: ");
			diemToan = sc.nextFloat();
		}
		System.out.print("Nhập điểm tiếng anh: ");
		diemAnh = sc.nextFloat();
		while(diemAnh < 0 || diemAnh > 10) {
			System.err.println("Lỗi, vui lòng nhập điểm có giá trị từ 0 đến 10");
			sc.nextLine();
			System.out.print("Nhập điểm tiếng anh: ");
			diemAnh = sc.nextFloat();
		}
		System.out.print("Nhập điểm ngữ văn: ");
		diemVan = sc.nextFloat();
		while(diemVan < 0 || diemVan > 10) {
			System.err.println("Lỗi, vui lòng nhập điểm có giá trị từ 0 đến 10");
			sc.nextLine();
			System.out.print("Nhập điểm tiếng anh: ");
			diemVan = sc.nextFloat();
		}
	}
	
	public void xuat() {
		System.out.printf("%14s", diemToan);
		System.out.printf("%16s", diemAnh);
		System.out.printf("%16s", diemVan);
		System.out.printf("%12.1f", tinhDiemTrungBinh());
		
	}
	
	public float tinhDiemTrungBinh() {
		return (diemToan+diemVan+diemAnh)/3;
	}

}
