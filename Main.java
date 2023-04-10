package bai_tap_lon;

import java.io.IOException;
import java.util.Scanner;


public class Main  {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		DanhSachBangDiemKhaoSat dsbdks = new DanhSachBangDiemKhaoSat();
		Scanner sc = new Scanner(System.in);
		int lc = 0;
		while (true) {
			System.out.println("*******************MENU*******************");
			System.out.println("1. Nhập danh sách bảng điểm");
			System.out.println("2. In danh sách bảng điểm");
			System.out.println("3. Số lượng học sinh vượt qua và trượt khảo sát");
			System.out.println("4. Danh sách học sinh trượt khảo sát");
			System.out.println("5. Xóa học sinh theo mã học sinh");
			System.out.println("6. Tìm kiếm học sinh theo tên");
			System.out.println("7. Thêm học sinh vào danh sách");
			System.out.println("8. Sửa thông tin học sinh theo mã ");
			System.out.println("9. Làm rỗng toàn bộ danh sách");
			System.out.println("10. Lấy số lượng học sinh trong danh sách");
			System.out.println("11. Sắp xếp học sinh theo chiều giảm dần của điểm trung bình");
			System.out.println("12. Ghi danh sách bảng điểm vào file ");
			System.out.println("13. Đọc danh sách bảng điểm");
			System.out.println("0. THOÁT");

			System.out.print("Nhập lựa chọn: ");

			lc = Integer.parseInt(sc.nextLine());
			
			if(lc==1) {
				dsbdks.nhapDsbd();
			}else if(lc==2) {
				dsbdks.inDsbd();
			}else if(lc==3) {
				dsbdks.soLuongHocSinhQuaVaTruotKhaoSat();
			}else if(lc==4) {
				dsbdks.danhSachHocSinhTruotKhaoSat();
			}else if(lc==5) {
				dsbdks.xoaHocSinhTheoMaHocSinh();
				System.out.println("Xóa Thành Công !!!");
			}else if(lc==6) {
				dsbdks.timKiemhHocSinhTheoTenVaKhoi();
			}else if(lc==7) {
				dsbdks.themHocSinhVaoDanhSach();
			}else if(lc==8) {
				dsbdks.suaThongTinHocSinhTheoMaHocSinh();
				System.out.println("Đã sửa thông tin thành công");
			}else if(lc==9) {
				dsbdks.lamRongToanBoDanhSach();
				System.out.println("DANH SÁCH HỌC SINH ĐÃ ĐƯỢC LÀM RỖNG");
			}else if(lc==10) {
				System.out.println("Số lượng học sinh hiện tại có trong danh sách là: "+dsbdks.laySoLuongHocSinhTrongDanhSach());
			}else if(lc==11) {
				dsbdks.sapXepHocSinhTheoGiamDanTheoDiemTrungBinh();
				dsbdks.inDsbd();
			}else if(lc==0) {
				break;
			}else if(lc==12) {
				dsbdks.ghiFile();
				System.out.println("GHI FILE THÀNH CÔNG!!!");
			}else if(lc==13) {
				dsbdks.docFile();
				dsbdks.inDsbd();
			}
			else {
				System.out.println("Bạn đã nhập sai");
			}

		}

	}
}
