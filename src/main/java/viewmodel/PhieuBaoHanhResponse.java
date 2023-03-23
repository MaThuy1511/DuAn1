package viewmodel;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhieuBaoHanhResponse {

    private int id;

    private String tenLoaiBH;
    private String dieuKienBH;

    private String tenKhachHang;
    private String tenDienThoai;
    private String imei;
    private long giaSanPham;
    private int thoiHanBaoHanh;
    private LocalDate ngayMuaHang;
    private LocalDate ngayHetHan;
    private String moTa;
    private boolean trangThai;

    @Override
    public String toString() {
        return "PhieuBaoHanhResponse{" + "id=" + id + ", tenLoaiBH=" + tenLoaiBH + ", dieuKienBH=" + dieuKienBH + ", tenKhachHang=" + tenKhachHang
                + ", tenDienThoai=" + tenDienThoai + ", imei=" + imei + ", giaSanPham=" + giaSanPham + ", thoiHanBaoHanh=" + thoiHanBaoHanh + ", ngayMuaHang="
                + ngayMuaHang + ", ngayHetHan=" + ngayHetHan + ", moTa=" + moTa + ", trangThai=" + trangThai + '}';
    }

}
