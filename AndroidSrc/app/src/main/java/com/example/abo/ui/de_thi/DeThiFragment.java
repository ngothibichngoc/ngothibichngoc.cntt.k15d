package com.example.abo.ui.de_thi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.abo.DAO.ConnectAPI;
import com.example.abo.MainActivity;
import com.example.abo.R;
import com.example.abo.bai_thi.ThiActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DeThiFragment extends Fragment {
    DeThiAdapter deThiAdapter;
    GridView gvDeThi;
    ArrayList<DeThi> lstDeThi = new ArrayList<DeThi>();

    public DeThiFragment() {
        // Required empty public constructor
    }


    @Override
    // làm việc với View
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Danh sách đề thi");
        return inflater.inflate(R.layout.fragment_item_de_thi_list, container, false);
    }

    @Override
    // viết lệnh trên Fragment
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gvDeThi = (GridView)getActivity().findViewById(R.id.gvDeThi);

        Data data = new Data();
        data.execute();

        gvDeThi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> AdapterView, View view, int i, long l) {
                // lệnh chuyển màn hình (Activity)
                Intent intent = new Intent(getActivity(), ThiActivity.class);
                // giá trị truyền
                DeThi deThi = (DeThi) AdapterView.getAdapter().getItem(i);
                intent.putExtra("MaDe", deThi.getMaDeThi());
                startActivity(intent);
            }
        });
    }


    private ProgressDialog pDialog;
    class Data extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] params) {
            ConnectAPI jsonParser = new ConnectAPI();
            String json = jsonParser.callService(ConnectAPI.API_DE_THI, ConnectAPI.GET);
            lstDeThi = new ArrayList<>();
            if (json != null) {
                try {
                    JSONObject jsonObj = new JSONObject(json);
                    if (jsonObj != null) {
                        JSONArray platfform = jsonObj.getJSONArray("DanhSachDeThi");
                        for (int i = 0; i < platfform.length(); i++) {
                            JSONObject obj = (JSONObject) platfform.get(i);
                            DeThi pf = new DeThi(obj.getString("TenDeThi"), obj.getInt("MaDeThi"));
                            lstDeThi.add(pf);
                            System.out.println(pf.toString());
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("JSON Data", "Didn't receive any data from server!");
            }
            return null;
        }
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getContext());
            pDialog.setMessage("Đang tải dữ liệu..");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if (pDialog.isShowing())
                pDialog.dismiss();
            setData();
        }
    }

    public void setData(){

        deThiAdapter = new DeThiAdapter(getContext(), lstDeThi);
        gvDeThi.setAdapter(deThiAdapter);
        System.out.println("Đã set adapter");
    }
}
