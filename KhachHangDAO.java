/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.landcoffee.DAO;

import com.landcoffee.entity.KhachHang;
import com.landcoffee.utils.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyễn Tiến Dũng
 */
public class KhachHangDAO extends LandCoffeeDAO<KhachHang, String> {

    String insert_Sql = "INSERT INTO KHACHHANG(MAKH,TENKH,DIACHI,SDT,DIEM,MANV) VALUES(?,?,?,?,?,?)";
    String update_Sql = "UPDATE KHACHHANG SET TENKH = ?, DIACHI = ?, SDT = ?, DIEM = ?, MANV = ? WHERE MAKH = ?";
    String delete_Sql = "DELETE FROM KHACHHANG WHERE MAKH = ?";
    String selectAll_Sql = "SELECT * FROM KHACHHANG";
    String selectById_Sql = "SELECT * FROM KHACHHANG WHERE MAKH = ?";

    @Override
    public void insert(KhachHang entity) {
        try {
            jdbcHelper.update(insert_Sql, entity.getMaKH(), entity.getDiaChi(), entity.getSdt(), entity.getDiem(), entity.getManv());
        } catch (Exception e) {
        }
    }

    @Override
    public void update(KhachHang entity) {
        try {
            jdbcHelper.update(update_Sql, entity.getHoTen(), entity.getDiaChi(), entity.getSdt(), entity.getDiem(), entity.getManv());
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(String id) {
        try {
            jdbcHelper.update(delete_Sql, id);
        } catch (Exception e) {
        }
    }

    @Override
    public List<KhachHang> selectAll() {
        return this.selectBySql(selectAll_Sql);
    }

    @Override
    public KhachHang selectById(String id) {
        List<KhachHang> list = this.selectBySql(selectById_Sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setMaKH(rs.getString("MAKH"));
                entity.setHoTen(rs.getString("HOTEN"));
                entity.setDiaChi(rs.getString("DIACHI"));
                entity.setSdt(rs.getString("SDT"));
                entity.setDiem(rs.getFloat("DIEM"));
                entity.setManv(rs.getString("MANV"));
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
