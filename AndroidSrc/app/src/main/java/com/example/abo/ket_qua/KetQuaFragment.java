package com.example.abo.ket_qua;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.abo.DAO.ConnectAPI;
import com.example.abo.MainActivity;
import com.example.abo.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class KetQuaFragment  extends Fragment {
    ListView lvKetQua;
    KetQuaAdapter ketQuaAdapter;

    public KetQuaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Danh sách điểm");
        return inflater.inflate(R.layout.fragment_ket_qua, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Data data = new Data();
        data.execute();
    }

    private ProgressDialog pDialog;
    private ArrayList<KetQua> lstKetQua;

    class Data extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] params) {
            ConnectAPI jsonParser = new ConnectAPI();
            String json = jsonParser.callService(ConnectAPI.API_KET_QUA, ConnectAPI.GET);
            lstKetQua = new ArrayList<>();
            if (json != null) {
                try {
                    JSONObject jsonObj = new JSONObject(json);
                    if (jsonObj != null) {
                        JSONArray platfform = jsonObj.getJSONArray("DanhSachKetQua");
                        for (int i = 0; i < platfform.length(); i++) {
                            JSONObject obj = (JSONObject) platfform.get(i);
                            KetQua pf = new KetQua(obj.getString("HoTen"), obj.getInt("Diem"));
                            lstKetQua.add(pf);
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
        lvKetQua = (ListView)getActivity().findViewById(R.id.lvDiem);
        System.out.println("lvKetQua = " + lstKetQua.size());
        ketQuaAdapter = new KetQuaAdapter(getContext(), -1,lstKetQua);

        lvKetQua.setAdapter(ketQuaAdapter);
        System.out.println("Đã set adapter");
    }
}
