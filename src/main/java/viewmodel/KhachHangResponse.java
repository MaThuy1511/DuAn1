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
public class KhachHangResponse {

    private int id;
    private String hoTen;
    private String email;
    private String sdt;
    private boolean gioiTinh;
    private LocalDate ngaySinh;
    private String diaChi;
    private boolean trangThai;
    private String maThe;
    private LocalDate ngayKichHoat;
    private int soDiem;
    private boolean trangThaiThe;

    @Override
    public String toString() {
        return "KhachHangResponse{" + "id=" + id + ", hoTen=" + hoTen + ", email=" + email + ", sdt=" + sdt + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", trangThai=" + trangThai + ", maThe=" + maThe + ", ngayKichHoat=" + ngayKichHoat + ", soDiem=" + soDiem + ", trangThaiThe=" + trangThaiThe + '}';
    }

}
