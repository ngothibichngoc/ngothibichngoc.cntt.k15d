package com.example.abo.ui.de_thi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.abo.R;

import java.util.ArrayList;

public class DeThiAdapter extends ArrayAdapter<DeThi> {

    Context context;
    ArrayList<DeThi> lstDeThi;
    public DeThiAdapter(Context context, ArrayList<DeThi> lstDeThi) {
        super(context, 0, lstDeThi);
        this.lstDeThi =lstDeThi;
        this.context = context;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_de_thi, parent, false);
        }

        TextView txtten = (TextView)convertView.findViewById(R.id.txtTenDe);
        ImageView imgicon = (ImageView)convertView.findViewById(R.id.imgIcon);
        System.out.println("Run getView De thi");
        DeThi p = lstDeThi.get(position);
        if(p != null){
            txtten.setText("" + p.getTenDeThi());
            imgicon.setImageResource(R.mipmap.icons8_book_64);
        }

        return convertView;
    }
}
