package com.hencoder.hencoderpracticedraw1.beziertest;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.hencoder.hencoderpracticedraw1.R;

public class MPageFragment extends Fragment {
    private static final String TAG = "PageFragment";
    @LayoutRes
    int sampleLayoutRes;
    @LayoutRes
    int practiceLayoutRes;

    public static MPageFragment newInstance(@LayoutRes int sampleLayoutRes, @LayoutRes int practiceLayoutRes) {
        MPageFragment fragment = new MPageFragment();
        Bundle args = new Bundle();
        args.putInt("sampleLayoutRes", sampleLayoutRes);
        args.putInt("practiceLayoutRes", practiceLayoutRes);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_page, container, false);
        view.findViewById(R.id.rl_sample).setVisibility(View.GONE);
        ViewStub sampleStub = (ViewStub) view.findViewById(R.id.sampleStub);
        sampleStub.setVisibility(View.GONE);
        try {
//            Log.i(TAG, "onCreateView: sampleLayoutRes=="+sampleLayoutRes);
//            sampleStub.setLayoutResource(sampleLayoutRes);
//            sampleStub.inflate();
        }catch (Exception e){
//            sampleStub.setVisibility(View.GONE);
            e.printStackTrace();
        }


        ViewStub practiceStub = (ViewStub) view.findViewById(R.id.practiceStub);
        practiceStub.setLayoutResource(practiceLayoutRes);
        practiceStub.inflate();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            sampleLayoutRes = args.getInt("sampleLayoutRes");
            practiceLayoutRes = args.getInt("practiceLayoutRes");
        }
    }

}
