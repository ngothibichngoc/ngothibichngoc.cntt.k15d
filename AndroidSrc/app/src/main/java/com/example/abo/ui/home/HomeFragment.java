package com.example.abo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.abo.MainActivity;
import com.example.abo.R;
import com.example.abo.ui.de_thi.DeThiFragment;

public class HomeFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Trang chủ");
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button btnBatDauThi = (Button) view.findViewById(R.id.btnBatDauThi);
        btnBatDauThi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DeThiFragment fragment = new DeThiFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_main, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}
