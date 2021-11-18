/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.landcoffee.DAO;

import com.landcoffee.entity.KhachHang;
import com.landcoffee.entity.SanPham;
import com.landcoffee.utils.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Nguyễn Tiến Dũng
 */
public class SanPhamDAO extends LandCoffeeDAO<SanPham, String> {

    String insert_Sql = "INSERT INTO SANPHAM(MASP,TENSP,GIA,MANV) VALUES(?,?,?,?)";
    String update_Sql = "UPDATE SANPHAM SET TENSP = ?, GIA = ?,MANV = ? WHERE MASP = ?";
    String delete_Sql = "DELETE FROM SANPHAM WHERE MASP = ?";
    String selectAll_Sql = "SELECT * FROM SANPHAM";
    String selectById_Sql = "SELECT * FROM SANPHAM WHERE MASP = ?";

    @Override
    public void insert(SanPham entity) {
        try {
            jdbcHelper.update(insert_Sql, entity.getMaSP(), entity.getTenSP(), entity.getGia(), entity.getMaNV());
        } catch (Exception e) {
        }
    }

    @Override
    public void update(SanPham entity) {
        try {
            jdbcHelper.update(update_Sql, entity.getTenSP(), entity.getGia(), entity.getMaNV(), entity.getMaSP());
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(String id) {
        try {
            jdbcHelper.update(delete_Sql,id);
        } catch (Exception e) {
        }
    }

    @Override
    public List<SanPham> selectAll() {
        return this.selectBySql(selectAll_Sql);
    }

    @Override
    public SanPham selectById(String id) {
        List<SanPham> list = this.selectBySql(selectById_Sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<SanPham> selectBySql(String sql, Object... args) {
         List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                SanPham entity = new SanPham();
                entity.setMaSP(rs.getString("MASP"));
                entity.setTenSP(rs.getString("TENSP"));
                entity.setGia(rs.getFloat("GIA"));
                entity.setMaNV(rs.getString("SDT"));
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
