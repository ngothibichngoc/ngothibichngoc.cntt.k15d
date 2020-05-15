package com.example.abo.ket_qua;

import androidx.annotation.NonNull;

import java.util.Date;

public class KetQua {
    private int id;
    private String hoTen;
    private float diem;
    private Date ngayThi;

    public KetQua(int id, String hoTen, float diem, Date ngayThi) {
        this.id = id;
        this.hoTen = hoTen;
        this.diem = diem;
        this.ngayThi = ngayThi;
    }

    public KetQua(String hoTen, float diem) {
        this.hoTen = hoTen;
        this.diem = diem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public Date getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(Date ngayThi) {
        this.ngayThi = ngayThi;
    }

    @NonNull
    @Override
    public String toString() {
        return getHoTen() +" - " +getDiem();
    }
}
