package com.example.abo.bai_thi;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.abo.DAO.ConnectAPI;
import com.example.abo.cau_hoi.CauHoi;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abo.R;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class KetQuaBaiThiActivity extends AppCompatActivity {

    ArrayList<CauHoi> arrCauHoi = new ArrayList<CauHoi>();
    int traLoiDung = 0;
    int traLoiSai = 0;
    int chuaTraLoi = 0;
    int tongDiem = 0;
    int diemCuaMotCau = 5;

    TextView tvTraLoiDung, tvTraLoiSai, tvChuaTraLoi, tvTongDiem;
    Button btnLuuDiem, btnLamLai, btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua_bai_thi);
        final Intent intent = getIntent();
        arrCauHoi = (ArrayList<CauHoi>) intent.getExtras().getSerializable("lstCauHoi");

        tvChuaTraLoi = (TextView) findViewById(R.id.tvChuaTraLoi);
        tvTraLoiSai = (TextView) findViewById(R.id.tvTraLoiSai);
        tvTraLoiDung = (TextView) findViewById(R.id.tvTraLoiDung);
        tvTongDiem = (TextView) findViewById(R.id.tvTongDiem);
        btnLamLai = (Button) findViewById(R.id.btnLamLai);
        btnLuuDiem = (Button) findViewById(R.id.btnLuuDiem);
        btnThoat = (Button) findViewById(R.id.btnThoat);

        kiemTraKetQua();
        tongDiem = traLoiDung * 10;
        tvChuaTraLoi.setText(chuaTraLoi +"");
        tvTraLoiDung.setText(traLoiDung +"");
        tvTraLoiSai.setText(traLoiSai+"");
        tvTongDiem.setText(tongDiem+"");

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(KetQuaBaiThiActivity.this);
                builder.setIcon(R.drawable.exit);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát hay không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        btnLuuDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(KetQuaBaiThiActivity.this);
                LayoutInflater inflater = KetQuaBaiThiActivity.this.getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog_luu_diem, null);
                builder.setView(view);

                final EditText editten = (EditText) view.findViewById(R.id.edTen);
                TextView txtdiemso = (TextView) view.findViewById(R.id.tvDiemSo);
                int diemtong = traLoiDung * diemCuaMotCau;
                txtdiemso.setText(diemtong + " điểm");


                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String ten = editten.getText().toString();
                        int maDeThi = arrCauHoi.get(0).getMaDeThi();
//                        KetQuaDAO.LuuDiem(ten, tongDiem);//

                            Diem diem = new Diem(maDeThi ,ten, tongDiem);
                            diem.execute();
                        try {
                            diem.get();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (statusSave){
                            Toast.makeText(KetQuaBaiThiActivity.this, "Lưu điểm thành công", Toast.LENGTH_LONG).show();
                            finish();
                            dialog.dismiss();
                        }else{
                            Toast.makeText(KetQuaBaiThiActivity.this, "Lưu điểm thất bại", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog b = builder.create();
                b.show();
            }
        });

        btnLamLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
                finish();
                Intent itLamLai = new Intent(KetQuaBaiThiActivity.this, ThiActivity.class);
                itLamLai.putExtra("lstCauHoi", arrCauHoi);
                startActivity(itLamLai);
            }
        });
    }

    // làm mới mảng câu hỏi
    public void  refresh(){
        for(int i = 0; i < arrCauHoi.size(); i++){
            arrCauHoi.get(i).reset();
        }
    }

    //hàm check kết quả
    public void kiemTraKetQua() {
        for (int i = 0; i < arrCauHoi.size(); i++) {
            if (arrCauHoi.get(i).isChuaTraLoi() == true) {
                chuaTraLoi++;
            } else if (arrCauHoi.get(i).isTraLoiDung() == true) {
                traLoiDung++;
            } else
                traLoiSai++;
        }
    }

    //Lưu điểm
    private ProgressDialog pDialog;
    class Diem extends AsyncTask {
        int maDeThi;
        String hoTen;
        int tongDiem;

        public Diem(int maDeThi, String hoTen, int tongDiem) {
            this.maDeThi = maDeThi;
            this.hoTen = hoTen;
            this.tongDiem = tongDiem;
        }

        @Override
        protected Object doInBackground(Object[] params) {
            ConnectAPI jsonParser = new ConnectAPI();

            List<NameValuePair> lstParam = new ArrayList<NameValuePair>();
            lstParam.add(new BasicNameValuePair("maDeThi",maDeThi+""));
            lstParam.add(new BasicNameValuePair("hoTen",hoTen+""));
            lstParam.add(new BasicNameValuePair("diem",tongDiem+""));
            lstParam.add(new BasicNameValuePair("taiKhoan",ConnectAPI.TAI_KHOAN+""));
            lstParam.add(new BasicNameValuePair("matKhau",ConnectAPI.MAT_KHAU+""));

            String json = jsonParser.callService(ConnectAPI.API_LUU_DIEM, ConnectAPI.POST, lstParam);
            if (json != null) {
                try {
                    JSONObject jsonObj = new JSONObject(json);
                    if (jsonObj != null) {
                        //////////
                       statusSave = jsonObj.getBoolean("status");
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
            pDialog = new ProgressDialog(KetQuaBaiThiActivity.this);
            pDialog.setMessage("Đang lưu điểm..");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if (pDialog.isShowing())
                pDialog.dismiss();
            setNofity();
        }
    }

    boolean statusSave = false;

    void setNofity(){

    }
}
