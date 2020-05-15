package com.example.abo.bai_thi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.abo.R;
import com.example.abo.cau_hoi.CauHoi;

import java.util.ArrayList;

public class KiemTraBaiThiAdapter extends BaseAdapter {
    ArrayList lsDuLieu;
    LayoutInflater inflater;

    public KiemTraBaiThiAdapter(ArrayList lsDuLieu, Context context) {
        this.lsDuLieu = lsDuLieu;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return lsDuLieu.size();
    }

    @Override
    public Object getItem(int position) {
        return lsDuLieu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CauHoi dulieu = (CauHoi)getItem(position);
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_gridview_list_cau_tra_loi, null);
            holder.tvSoCauTraLoi = (TextView)convertView.findViewById(R.id.txtSoCauTraLoi);
            holder.tvCauTraLoi = (TextView)convertView.findViewById(R.id.txtCauTraLoi);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        int i = position + 1;

        holder.tvSoCauTraLoi.setText("Câu "+i+": ");
        holder.tvCauTraLoi.setText(dulieu.getTraloi());
        return convertView;
    }

    private  static  class  ViewHolder{
        TextView tvSoCauTraLoi, tvCauTraLoi;
    }
}
