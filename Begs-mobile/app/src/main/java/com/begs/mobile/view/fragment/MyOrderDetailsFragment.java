package com.begs.mobile.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.begs.mobile.R;
import com.begs.mobile.util.Utils;
import com.begs.mobile.util.Utils.AnimationType;
import com.begs.mobile.view.activities.ECartHomeActivity;
import com.begs.mobile.view.customview.OnStartDragListener;

public class MyOrderDetailsFragment extends Fragment implements OnStartDragListener {

    private static FrameLayout noItemDefault;
    private static RecyclerView recyclerView;
    private ItemTouchHelper mItemTouchHelper;

    public MyOrderDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_order_details, container,
                false);

        view.findViewById(R.id.slide_down).setVisibility(View.VISIBLE);
        view.findViewById(R.id.home).setOnTouchListener(
                new OnTouchListener() {

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        Utils.switchContent(R.id.frag_container,
                                Utils.MY_ORDER_CONFIRM_FRAGMENT,
                                ((ECartHomeActivity) (getContext())),
                                AnimationType.SLIDE_LEFT);

                        return false;
                    }
                });

        view.findViewById(R.id.slide_down).setOnTouchListener(
                new OnTouchListener() {

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        Utils.switchFragmentWithAnimation(R.id.frag_container,
                                new HomeFragment(),
                                ((ECartHomeActivity) (getContext())),
                                Utils.HOME_FRAGMENT, AnimationType.SLIDE_DOWN);

                        return false;
                    }
                });


        return view;
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }

}