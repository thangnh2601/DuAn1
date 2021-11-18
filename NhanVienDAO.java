/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.landcoffee.DAO;

import com.landcoffee.entity.NhanVien;
import com.landcoffee.utils.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyễn Tiến Dũng
 */
public class NhanVienDAO extends LandCoffeeDAO<NhanVien, String> {

    String insert_Sql = "INSERT INTO NHANVIEN(MANV,TENNV,DIACHI,SDT,CALAM,LUONGCB,VAITRO) VALUES(?,?,?,?,?,?,?)";
    String update_Sql = "UPDATE NHANVIEN SET TENNV = ?, DIACHI = ?, SDT=?, CALAM = ?, LUONGCB = ?, VAITRO = ? WHERE MANV = ?";
    String delete_Sql = "DELETE FROM NHANVIEN WHERE MANV = ?";
    String selectAll_Sql = "SELECT * FROM NHANVIEN";
    String selectById_Sql = "SELECT * FROM NHANVIEN WHERE MANV = ?";

    @Override
    public void insert(NhanVien entity) {
        try {
            jdbcHelper.update(insert_Sql, entity.getMaNV(), entity.getHoTen(), entity.getDiaChi(), entity.getSdt(), entity.getCaLam(), entity.getLuongCB(), entity.getVaitro());
        } catch (Exception e) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(NhanVien entity) {
        try {
            jdbcHelper.update(update_Sql, entity.getHoTen(), entity.getDiaChi(), entity.getSdt(), entity.getCaLam(), entity.getLuongCB(), entity.getVaitro(), entity.getMaNV());
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(String id) {
        try {
            jdbcHelper.update(delete_Sql, id);
        } catch (Exception e) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(selectAll_Sql);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = this.selectBySql(selectById_Sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MANV"));
                entity.setHoTen(rs.getString("HOTEN"));
                entity.setDiaChi(rs.getString("DIACHI"));
                entity.setCaLam(rs.getBoolean("CALAM"));
                entity.setLuongCB(rs.getInt("LUONGCB"));
                entity.setVaitro(rs.getBoolean("VAITRO"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
