package com.example.abo.cau_hoi;

import java.io.Serializable;

public class DapAn implements Serializable {
    private String dapAn;
    private boolean isTrue;
    private boolean isChecked;

    public DapAn(String dapAn, boolean isTrue) {
        this.dapAn = dapAn;
        this.isTrue = isTrue;
    }

    public DapAn(String dapAn, boolean isTrue, boolean isChecked) {
        this.dapAn = dapAn;
        this.isTrue = isTrue;
        this.isChecked = isChecked;
    }

    public DapAn(String dapAn, int isTrue) {
        this.dapAn = dapAn;

        if (isTrue == 0){
            this.isTrue = false;
        }else {
            this.isTrue = true;
        }
    }

    public String getDapAn() {
        return dapAn;
    }

    public void setDapAn(String dapAn) {
        this.dapAn = dapAn;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public DapAn clone(){
        DapAn obj = new DapAn(dapAn, isTrue,isChecked);
        return obj;
    }
}
