package repository;

import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import model.TaiKhoan;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;
import utility.HibernateUtil;
import viewmodel.NhanVienResponse;

public class NhanVienRepository {

    // 1. add
    public static boolean add(NhanVien nhanVien) {
        boolean check = false;
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
            check = true;
        } catch (HibernateException ex) {
            ex.printStackTrace(System.out);
        }
        return check;
    }

    // 2. update
    public static boolean update(NhanVienResponse nhanVienResponse) {
        boolean check = false;
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction transaction = session.beginTransaction();
            
            NhanVien nhanVien = session.get(NhanVien.class, nhanVienResponse.getId());
            
            nhanVien.setHoTen(nhanVienResponse.getHoTen());
            nhanVien.setGioiTinh(nhanVienResponse.isGioiTinh());
            nhanVien.setSdt(nhanVienResponse.getSdt());
            nhanVien.setNgaySinh(nhanVienResponse.getNgaySinh());
            nhanVien.setDiaChi(nhanVienResponse.getDiaChi());
            nhanVien.setEmail(nhanVienResponse.getEmail());
            nhanVien.setChucVu(nhanVienResponse.isChucVu());
            nhanVien.setTrangThai(nhanVienResponse.isTrangThai());
            nhanVien.setHinhAnh(nhanVienResponse.getHinhAnh());
            
            TaiKhoan taiKhoan = nhanVien.getTaiKhoan();
            taiKhoan.setTaiKhoan(nhanVienResponse.getTaiKhoan());
            taiKhoan.setMatKhau(nhanVienResponse.getMatKhau());
            nhanVien.setTaiKhoan(taiKhoan);
            
            session.update(nhanVien);
            transaction.commit();
            check = true;
        } catch (HibernateException e) {
            e.printStackTrace(System.out);
        }
        return check;
    }

    // 3. get all
    public static List<NhanVienResponse> getAll() {
        List<NhanVienResponse> nhanVienResponses = new ArrayList<>();
        
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Query query = session.createQuery("""
                                              SELECT new viewmodel.NhanVienResponse
                                              (nv.id, nv.hoTen, nv.gioiTinh, nv.sdt, nv.ngaySinh, nv.diaChi, nv.email, nv.chucVu, nv.trangThai, nv.hinhAnh, tk.taiKhoan, tk.matKhau)
                                              FROM NhanVien nv
                                              INNER JOIN nv.taiKhoan tk
                                               """);
            
            nhanVienResponses = query.getResultList();
        } catch (HibernateException ex) {
            ex.printStackTrace(System.out);
        }
        return nhanVienResponses;
    }

    // Test
    public static void main(String[] args) {
        // getAll
        List<NhanVienResponse> nhanVienResponses = getAll();
        nhanVienResponses.forEach(nv -> System.out.println(nv.toString()));

        // update
//        NhanVienResponse nhanVienResponse = new NhanVienResponse();
//
//        nhanVienResponse.setId(1);
//        nhanVienResponse.setHoTen("Nguyễn Khắc Thịnh");
//        nhanVienResponse.setGioiTinh(true);
//        nhanVienResponse.setSdt("091232829112");
//        nhanVienResponse.setNgaySinh(LocalDate.now());
//        nhanVienResponse.setDiaChi("265 Phạm Văn Đồng");
//        nhanVienResponse.setEmail("thinh123@gmail.com");
//        nhanVienResponse.setChucVu(false);
//        nhanVienResponse.setTrangThai(true);
//        nhanVienResponse.setHinhAnh("abc.png");
//
//        nhanVienResponse.setTaiKhoan("thingnguyen1234");
//        nhanVienResponse.setMatKhau("1234");
//
//        System.out.println(update(nhanVienResponse));
//        NhanVien nhanVien = new NhanVien();
        
            // add
//        nhanVien.setHoTen("Nguyễn Khắc Thịnh");
//        nhanVien.setGioiTinh(true);
//        nhanVien.setSdt("091232829112");
//        nhanVien.setNgaySinh(LocalDate.now());
//        nhanVien.setDiaChi("262 Phạm Văn Đồng");
//        nhanVien.setEmail("thinh12@gmail.com");
//        nhanVien.setChucVu(true);
//        nhanVien.setTrangThai(false);
//        nhanVien.setHinhAnh("");
//        
//        TaiKhoan taiKhoan = new TaiKhoan();
//        taiKhoan.setTaiKhoan("thingnguyen123");
//        taiKhoan.setMatKhau("12312092");
//        
//        nhanVien.setTaiKhoan(taiKhoan);
//        
//        System.out.println(add(nhanVien));
    }
}
