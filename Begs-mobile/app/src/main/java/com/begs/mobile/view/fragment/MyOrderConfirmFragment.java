package com.begs.mobile.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.begs.mobile.R;
import com.begs.mobile.domain.mock.FakeWebServer;
import com.begs.mobile.model.CenterRepository;
import com.begs.mobile.model.entities.Product;
import com.begs.mobile.util.Utils;
import com.begs.mobile.util.Utils.AnimationType;
import com.begs.mobile.view.activities.ECartHomeActivity;
import com.begs.mobile.view.adapter.CartListAdapter;
import com.begs.mobile.view.adapter.CartListAdapter.OnItemClickListener;
import com.begs.mobile.view.adapter.ShoppingListAdapter;
import com.begs.mobile.view.customview.OnStartDragListener;
import com.begs.mobile.view.customview.SimpleItemTouchHelperCallback;

import java.util.List;

public class MyOrderConfirmFragment extends Fragment implements OnStartDragListener {

    private static FrameLayout noItemDefault;
    private static RecyclerView recyclerView;
    private ItemTouchHelper mItemTouchHelper;

    public MyOrderConfirmFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_order_confirm, container,
                false);
        recyclerView = (RecyclerView) view
                .findViewById(R.id.recommendOtherProductsList);
        final List<Product> products = FakeWebServer.getFakeWebServer().getRecommendedProducts();
        if (products.size() != 0) {

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                    getActivity().getBaseContext());

            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);

            ShoppingListAdapter shoppingListAdapter = new ShoppingListAdapter(
                    getActivity(), this, products);

            recyclerView.setAdapter(shoppingListAdapter);

            shoppingListAdapter
                    .SetOnItemClickListener(new ShoppingListAdapter.OnItemClickListener() {

                        @Override
                        public void onItemClick(View view, int position) {

                            Utils.switchFragmentWithAnimation(
                                    R.id.frag_container,
                                    new ProductDetailsFragment("", position,
                                            false, products),
                                    ((ECartHomeActivity) (getContext())), null,
                                    Utils.AnimationType.SLIDE_LEFT);

                        }
                    });

            ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(
                    shoppingListAdapter);
            mItemTouchHelper = new ItemTouchHelper(callback);
            mItemTouchHelper.attachToRecyclerView(recyclerView);

        }
        view.findViewById(R.id.slide_down).setVisibility(View.VISIBLE);
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

        view.findViewById(R.id.home).setOnTouchListener(
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