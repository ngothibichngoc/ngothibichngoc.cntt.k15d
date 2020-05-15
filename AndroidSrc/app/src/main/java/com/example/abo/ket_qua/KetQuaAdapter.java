package com.example.abo.ket_qua;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;


import androidx.annotation.NonNull;

import com.example.abo.R;
import com.example.abo.bai_thi.KiemTraBaiThiAdapter;
import com.example.abo.cau_hoi.CauHoi;

import java.util.ArrayList;
import java.util.List;


public class KetQuaAdapter extends ArrayAdapter<KetQua> {
    ArrayList<KetQua> lsDuLieu;
    LayoutInflater inflater;
    Context context;


    public KetQuaAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        lsDuLieu = (ArrayList) objects;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lsDuLieu.size();
    }

    @Override
    public KetQua getItem(int position) {
        return lsDuLieu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("Chạy adapter");

        KetQua dulieu = (KetQua)getItem(position);
        TextView diem, hoTen;

        View viewKetQua;
        if(convertView == null){
            viewKetQua = inflater.inflate(R.layout.item_list_score, null);
            diem = (TextView)viewKetQua.findViewById(R.id.tvDiemSo);
            hoTen = (TextView)viewKetQua.findViewById(R.id.tvHoTen);
        }else {
            return null;
        }

        diem.setText(dulieu.getDiem()+"");
        hoTen.setText(dulieu.getHoTen());
        return viewKetQua;
    }

}
