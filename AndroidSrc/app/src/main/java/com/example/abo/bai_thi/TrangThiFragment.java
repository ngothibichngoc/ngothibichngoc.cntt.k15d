package com.example.abo.bai_thi;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
//import android.widget.TextView;

import com.example.abo.MainActivity;
import com.example.abo.R;
import com.example.abo.cau_hoi.CauHoi;
import com.example.abo.cau_hoi.DapAn;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrangThiFragment extends Fragment {

    ArrayList<CauHoi> lstCauHoi;

    public static final String ARG_PAGE = "page";
    public static final String ARG_CHECKANSWER = "checkAnswer";
    private int mPageNumber;    //số trang hiện tại
    public  int checkAns;       //biến kiểm tra

    TextView tvCauHoiSo, tvCauHoi;
    RadioGroup radioGroup;
    RadioButton dapAnA, dapAnB, dapAnC, dapAnD;
    ImageView imgIcon;


    public TrangThiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_tra_loi_cau_hoi_page, container, false);

        tvCauHoiSo = (TextView) rootView.findViewById(R.id.tvCauHoiSo);
        tvCauHoi = (TextView) rootView.findViewById(R.id.tvCauHoi);
        dapAnA = (RadioButton) rootView.findViewById(R.id.radA);
        dapAnB = (RadioButton) rootView.findViewById(R.id.radB);
        dapAnC = (RadioButton) rootView.findViewById(R.id.radC);
        dapAnD = (RadioButton) rootView.findViewById(R.id.radD);
        radioGroup = (RadioGroup) rootView.findViewById(R.id.radGroup);
        imgIcon = (ImageView)rootView.findViewById(R.id.ivIcon);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // lấy data từ ScreenSlideActivity
        lstCauHoi = new ArrayList<CauHoi>();
        ThiActivity slideActivity = (ThiActivity) getActivity();
        lstCauHoi = slideActivity.getDuLieu();

        mPageNumber = getArguments().getInt(ARG_PAGE);  // lấy số trang hiện tại
        checkAns = getArguments().getInt(ARG_CHECKANSWER);
    }

    public static TrangThiFragment create(int pageNumber, int checkAnswer) {
        TrangThiFragment fragment = new TrangThiFragment();
        Bundle args = new Bundle();                    //gói dữ liệu để gửi đi
        args.putInt(ARG_PAGE, pageNumber);             // gửi số trang hiện tại
        args.putInt(ARG_CHECKANSWER, checkAnswer);     // gửi giá trị kiểm tra câu trả lời
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        CauHoi cauHoi = getItem(mPageNumber);

        tvCauHoiSo.setText("Câu " + (mPageNumber + 1));
        tvCauHoi.setText(cauHoi.getCauHoi());

        //lấy đáp án
        System.out.println("Lấy câu trả lời = " + mPageNumber);
        ArrayList<DapAn> lstDapAn = cauHoi.getLstDapAn();
        dapAnA.setText(lstDapAn.get(0).getDapAn());
        dapAnB.setText(lstDapAn.get(1).getDapAn());
        dapAnC.setText(lstDapAn.get(2).getDapAn());
        dapAnD.setText(lstDapAn.get(3).getDapAn());


        imgIcon.setImageResource(getResources().getIdentifier(cauHoi.getHinhAnh()+"","drawable", MainActivity.PACKAGE_NAME));


        if(checkAns != 0){
            dapAnA.setClickable(false);
            dapAnB.setClickable(false);
            dapAnC.setClickable(false);
            dapAnD.setClickable(false);

            getCheckAns(cauHoi.getIndexDapAn());
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                getItem(mPageNumber).setIdChecked(checkedId);// lấy ID khi click câu trả lời
                getItem(mPageNumber).setTraLoi(LayGiaTriTuID(checkedId));

                //Toast.makeText(getActivity(), "Đây là đáp án "+ checkedId, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //lấy giá trị (vị trí) radiogroup chuyển thành đáp án A,B,C,D
    private int LayGiaTriTuID(int ID) {
        if (ID == R.id.radA) {
            return 0;
        } else if (ID == R.id.radB) {
            return 1;
        } else if (ID == R.id.radC) {
            return 2;
        } else if (ID == R.id.radD) {
            return 3;
        }
        return -1;
    }

    //lấy Item khi biet vi tri
    public CauHoi getItem(int vitri){
        System.out.println("Vị trí = " + vitri);
         return lstCauHoi.get(vitri);
    }

    private  void getCheckAns(int index) {
        if(index == 0){
            dapAnA.setBackgroundColor(Color.GREEN);
        }else if(index == 1){
            dapAnB.setBackgroundColor(Color.GREEN);
        }else if(index == 2){
            dapAnC.setBackgroundColor(Color.GREEN);
        }else if(index == 3){
            dapAnD.setBackgroundColor(Color.GREEN);
        }
    }
}
