
package entity;


public class SanPham {
    private String maSP,tenSP,maNV;
    private float gia;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String maNV, float gia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maNV = maNV;
        this.gia = gia;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", maNV=" + maNV + ", gia=" + gia + '}';
    }
    
    
    
}
