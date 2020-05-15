package com.example.abo.bai_thi;

//import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abo.DAO.ConnectAPI;
import com.example.abo.R;
import com.example.abo.cau_hoi.CauHoi;
import com.example.abo.cau_hoi.DapAn;
import com.example.abo.ui.de_thi.DeThi;
import com.example.abo.ui.de_thi.DeThiAdapter;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ThiActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static int NUM_PAGES = 20;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter pagerAdapter;
    ArrayList<CauHoi> lstCauHoi;
    CounterClass thoiGian;
    int maDe;
    float tongThoiGian = 3;
    public int checkAns = 0;
    int thoiGianLamMotCau = 30; //tính theo giây

    TextView tvKiemTra, tvThoiGian, tvXemDiem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_tra_loi_cau_hoi);

        // lấy giá trị gửi về từ Fragment
        Intent intent = getIntent();
        maDe = intent.getIntExtra("MaDe",-1);

        lstCauHoi = new ArrayList<CauHoi>();
        //arr_cauhoi = cauhoi_ctrler.getCauHoi(sode,monhoc);

        khoiTaoThoiGian();

        tvThoiGian = (TextView)findViewById(R.id.tvThoiGian);
        tvThoiGian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tvXemDiem = (TextView)findViewById(R.id.txtXemDiem);

        tvKiemTra = (TextView)findViewById(R.id.txtKiemTra);
        tvKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KiemTra_CauTraLoi();
            }
        });

        tvXemDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent1 = new Intent(ThiActivity.this, KetQuaBaiThiActivity.class);
                // gửi list câu hỏi

                intent1.putExtra("lstCauHoi", lstCauHoi);
                startActivity(intent1);
            }
        });


        //lấy dữ liệu câu hỏi
        System.out.println("MaDe = " + maDe);
        if (maDe == -1){
            //Làm lại bải
            lstCauHoi = (ArrayList<CauHoi>) intent.getExtras().getSerializable("lstCauHoi");
            System.out.println("lstCauHoi = " + lstCauHoi.size());
            setData();
        }else  {
            //Lấy dữ liệu mới từ server
            Data data = new Data();
            data.execute();
//            try {
//                data.get();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    private void khoiTaoThoiGian(){
        int time = (int)(tongThoiGian*60*1000);
        thoiGian = new CounterClass(time, 1000);
    }
    public  ArrayList<CauHoi> getDuLieu(){
        return lstCauHoi;
    }

    // sự kiện nút quay lại
    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            dialogExit();
//            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    public  void dialogExit(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(ThiActivity.this);
        builder.setIcon(R.drawable.exit);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn thoát hay không?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                thoiGian.cancel();
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

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
//            return new TrangThiFragment();
            //gọi phương thức bên ScreenSlidePageFragment
            // gửi số trang hiện tại
            System.out.println("position = " + position);
            return TrangThiFragment.create(position, checkAns);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }

    // hàm kiểm tra câu trả lời
    public  void KiemTra_CauTraLoi(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.check_answer_dialog);    //gán layout
        dialog.setTitle("Danh sách câu trả lời");

        KiemTraBaiThiAdapter kiemTraBaiThiAdapter = new KiemTraBaiThiAdapter(lstCauHoi, this);
        GridView gvCauTraLoi = (GridView)dialog.findViewById(R.id.gvLsQuestion);
        gvCauTraLoi.setAdapter(kiemTraBaiThiAdapter);

        gvCauTraLoi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPager.setCurrentItem(position);    //set ViewPage tại vị trí click câu trả lời
                dialog.dismiss();   // tắt Dialog
            }
        });

        Button btndong, btnketthuc;
        btndong = (Button)dialog.findViewById(R.id.btnDong);
        btnketthuc = (Button)dialog.findViewById(R.id.btnKetThuc);
        btndong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnketthuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thoiGian.cancel();
                KetQua();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public  void KetQua(){
        checkAns = 1;

        mPager.setAdapter(pagerAdapter);
        mPager.setCurrentItem(0);

        tvXemDiem.setVisibility(View.VISIBLE);
        tvKiemTra.setVisibility(View.GONE);
        Toast.makeText(this, "Kiểm Tra Kết Thúc", Toast.LENGTH_LONG).show();
    }

    // hàm đếm thời gian
    public class CounterClass extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */


        //millisInFuture: 60*1000    - số thời gian đếm: 60s
        //countDownInterval:  1000   - số bước nhảy: 1s
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            tvThoiGian.setText(countTime); //SetText cho textview hiển thị thời gian.
        }

        @Override
        public void onFinish() {
            tvThoiGian.setText("00:00");  //SetText cho textview hiển thị thời gian.
            KetQua();
        }
    }

    //getData
    private ProgressDialog pDialog;
    class Data extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] params) {
            ConnectAPI jsonParser = new ConnectAPI();

            List<NameValuePair> lstParam = new ArrayList<NameValuePair>();
            lstParam.add(new BasicNameValuePair("maDeThi",maDe+""));

            String json = jsonParser.callService(ConnectAPI.API_BAI_THI, ConnectAPI.GET, lstParam);
            lstCauHoi = new ArrayList<>();
            if (json != null) {
                try {
                    JSONObject jsonObj = new JSONObject(json);
                    if (jsonObj != null) {
                        JSONArray platfform = jsonObj.getJSONArray("BaiThi");

                        System.out.println(platfform.toString());

                        for (int i = 0; i < platfform.length(); i++) {
                            JSONObject obj = (JSONObject) platfform.get(i);

                            ArrayList<DapAn> lstDapAn = new ArrayList<>();
                            JSONArray arrDapAn = obj.getJSONArray("DapAn");
                            for (int j = 0; j< arrDapAn.length(); j++){
                                JSONObject jsonDapAn = (JSONObject) arrDapAn.get(j);
                                lstDapAn.add(new DapAn(jsonDapAn.getString("DapAn"), jsonDapAn.getInt("IsTrue")));
                            }

                            CauHoi cauHoi = new CauHoi(obj.getInt("MaDeThi"), obj.getInt("MaCauHoi"), obj.getString("CauHoi"), obj.getString("HinhAnh"), lstDapAn);

                            lstCauHoi.add(cauHoi);
                        }
                        Collections.shuffle(lstCauHoi);
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
            pDialog = new ProgressDialog(ThiActivity.this);
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
//        NUM_PAGES = lstCauHoi.size();
        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        mPager.setPageTransformer(true, new DepthPageTransformer());
        tongThoiGian = (lstCauHoi.size()*thoiGianLamMotCau)/60;
        khoiTaoThoiGian();
        thoiGian.start();
    }

}

