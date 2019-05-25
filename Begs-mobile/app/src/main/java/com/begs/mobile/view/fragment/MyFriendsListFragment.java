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
import android.view.View.OnTouchListener;
import android.view.ViewGroup;

import com.begs.mobile.R;
import com.begs.mobile.domain.mock.FakeWebServer;
import com.begs.mobile.model.entities.Product;
import com.begs.mobile.util.Utils;
import com.begs.mobile.util.Utils.AnimationType;
import com.begs.mobile.view.activities.ECartHomeActivity;
import com.begs.mobile.view.adapter.ProductListAdapter;
import com.begs.mobile.view.adapter.ProductListAdapter.OnItemClickListener;
import com.begs.mobile.view.adapter.ShoppingListAdapter;
import com.begs.mobile.view.customview.OnStartDragListener;
import com.begs.mobile.view.customview.SimpleItemTouchHelperCallback;

import java.util.List;

public class MyFriendsListFragment extends Fragment implements OnStartDragListener {

    private static RecyclerView recyclerView;

    private ItemTouchHelper mItemTouchHelper;

    public MyFriendsListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_my_friends, container,
                false);

        view.findViewById(R.id.slide_down).setVisibility(View.VISIBLE);
        view.findViewById(R.id.slide_down).setOnTouchListener(
                new View.OnTouchListener() {

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        Utils.switchFragmentWithAnimation(R.id.frag_container,
                                new HomeFragment(),
                                ((ECartHomeActivity) (getContext())),
                                Utils.HOME_FRAGMENT, Utils.AnimationType.SLIDE_DOWN);

                        return false;
                    }
                });

        recyclerView = (RecyclerView) view
                .findViewById(R.id.my_fiends_list_recycler_view);

        final List<Product> products = FakeWebServer.getFakeWebServer().getFriendsPageList();
        if (products.size() != 0) {

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());

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
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP
                        && keyCode == KeyEvent.KEYCODE_BACK) {

                    Utils.switchContent(R.id.frag_container,
                            Utils.HOME_FRAGMENT,
                            ((ECartHomeActivity) (getContext())),
                            Utils.AnimationType.SLIDE_UP);

                }
                return true;
            }
        });

        return view;
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }

}