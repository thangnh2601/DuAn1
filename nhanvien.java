
package entity;


public class NhanVien {
    private String maNV,hoTen,diaChi,sdt;
    private int luongCB;
    private boolean caLam;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, String diaChi, String sdt, int luongCB, boolean caLam) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.luongCB = luongCB;
        this.caLam = caLam;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(int luongCB) {
        this.luongCB = luongCB;
    }

    public boolean isCaLam() {
        return caLam;
    }

    public void setCaLam(boolean caLam) {
        this.caLam = caLam;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", sdt=" + sdt + ", luongCB=" + luongCB + ", caLam=" + caLam + '}';
    }
    
}
