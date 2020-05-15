package com.example.abo.cau_hoi;

import android.graphics.Color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CauHoi implements Serializable {
    private  int maDeThi;

    private int maCauHoi;
    private String cauHoi;
    private String hinhAnh;
    private int IdChecked;

    private ArrayList<DapAn> lstDapAn;


    public CauHoi(int maDeThi, int maCauHoi, String cauHoi, String hinhAnh, ArrayList<DapAn> lstDapAn) {
        this.maDeThi = maDeThi;
        this.maCauHoi = maCauHoi;
        this.cauHoi = cauHoi;
        this.hinhAnh = hinhAnh;
        this.lstDapAn = lstDapAn;

        tronDapAn();
    }

    private void tronDapAn(){
//        Collections.shuffle(this.lstDapAn);
    }
    public CauHoi(int maDeThi, int maCauHoi, String cauHoi, String hinhAnh) {
        this.maDeThi = maDeThi;
        this.maCauHoi = maCauHoi;
        this.cauHoi = cauHoi;
        this.hinhAnh = hinhAnh;
    }

    public int getMaDeThi() {
        return maDeThi;
    }

    public void setMaDeThi(int maDeThi) {
        this.maDeThi = maDeThi;
    }

    public int getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(int maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public ArrayList<DapAn> getLstDapAn() {
        return lstDapAn;
    }

    public void setLstDapAn(ArrayList<DapAn> lstDapAn) {
        this.lstDapAn = lstDapAn;
    }

    public void reset() {
//        Collections.shuffle(lstDapAn);
        tronDapAn();
        for (DapAn dapAn: lstDapAn) {
            dapAn.setChecked(false);
        }
    }

    public boolean isChuaTraLoi(){
        for (DapAn dapAn: lstDapAn) {
            if (dapAn.isChecked() == true){
                return false;
            }
        }

        return true;
    }

    public boolean isTraLoiDung(){
        for (DapAn dapAn: lstDapAn) {
            if (dapAn.isChecked() == true && dapAn.isTrue() == true){
                return true;
            }
        }

        return false;
    }

    public DapAn getDapAn() {
        for (DapAn dapAn: lstDapAn) {
            if (dapAn.isTrue()){
                return dapAn;
            }
        }
        return null;
    }

    public void setTraLoi(int layGiaTriTuID) {
        for (DapAn dapAn: lstDapAn) {
            dapAn.setChecked(false);
        }
        DapAn dapAn = lstDapAn.get(layGiaTriTuID);
        dapAn.setChecked(true);
    }

    public DapAn getTraLoi(){
        for (DapAn dapAn: lstDapAn) {
            if (dapAn.isChecked()){
                return dapAn;
            }
        }

        return null;
    }

    public int getIdChecked() {
        return IdChecked;
    }

    public void setIdChecked(int idChecked) {
        IdChecked = idChecked;
    }

    public int getIndexDapAn() {
        int i = 0;
        for (DapAn dapAn: lstDapAn) {
            if (dapAn.isTrue()){
                return i;
            }
            i++;
        }
        return -1;
    }

    public String getTraloi() {
        int index = 0;
        for (DapAn dapAn: lstDapAn) {
            if (dapAn.isChecked()){
                if(index == 0){
                   return "A";
                }else if(index == 1){
                    return "B";
                }else if(index == 2){
                    return "C";
                }else if(index == 3){
                    return "D";
                }
            }
            index++;
        }
        return "";
    }

    public CauHoi clone(){
        CauHoi obj = new CauHoi(maDeThi,maCauHoi,cauHoi,hinhAnh);
        obj.lstDapAn = new ArrayList<DapAn>();

        for (DapAn dapAn: lstDapAn) {
            obj.lstDapAn.add(dapAn.clone());
        }

        return obj;
    }
}
