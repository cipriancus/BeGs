package com.begs.mobile.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;

import com.begs.mobile.R;
import com.begs.mobile.model.CenterRepository;
import com.begs.mobile.model.entities.Money;
import com.begs.mobile.model.entities.Producer;
import com.begs.mobile.model.entities.Product;
import com.begs.mobile.util.ColorGenerator;
import com.begs.mobile.util.Utils;
import com.begs.mobile.util.Utils.AnimationType;
import com.begs.mobile.view.activities.ECartHomeActivity;
import com.begs.mobile.view.adapter.SimilarProductsPagerAdapter;
import com.begs.mobile.view.customview.ClickableViewPager;
import com.begs.mobile.view.customview.ClickableViewPager.OnItemClickListener;
import com.begs.mobile.view.customview.LabelView;
import com.begs.mobile.view.customview.TextDrawable;
import com.begs.mobile.view.customview.TextDrawable.IBuilder;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.math.BigDecimal;


public class ProducerFragment extends Fragment {

    private Producer producer;

    private ImageView producerImage;

    private TextView producerName;

    private TextView producerDescription;

    private String subcategoryKey;

    private IBuilder mDrawableBuilder;

    private TextDrawable drawable;

    private ColorGenerator mColorGenerator = ColorGenerator.MATERIAL;

    private ClickableViewPager sellersProducts;

    private Toolbar mToolbar;

    public ProducerFragment(Producer producer, String subcategoryKey) {
        this.producer = producer;
        this.subcategoryKey = subcategoryKey;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_producer,
                container, false);

        mToolbar = (Toolbar) rootView.findViewById(R.id.htab_toolbar);
        if (mToolbar != null) {
            ((ECartHomeActivity) getActivity()).setSupportActionBar(mToolbar);
        }

        if (mToolbar != null) {
            ((ECartHomeActivity) getActivity()).getSupportActionBar()
                    .setDisplayHomeAsUpEnabled(true);

            mToolbar.setNavigationIcon(R.drawable.ic_drawer);

        }

        mToolbar.setTitleTextColor(Color.WHITE);

        mToolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ECartHomeActivity) getActivity()).getmDrawerLayout()
                        .openDrawer(GravityCompat.START);
            }
        });

        ((ECartHomeActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);


        sellersProducts = (ClickableViewPager) rootView
                .findViewById(R.id.sellers_products);


        producerName = ((TextView) rootView.findViewById(R.id.producer_name_product_details));

        producerDescription = ((TextView) rootView.findViewById(R.id.producer_description));

        producerImage = (ImageView) rootView.findViewById(R.id.producer_image);

        fillProductData();

        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP
                        && keyCode == KeyEvent.KEYCODE_BACK) {


                    Utils.switchContent(R.id.frag_container,
                            Utils.PRODUCT_OVERVIEW_FRAGMENT_TAG,
                            ((ECartHomeActivity) (getActivity())),
                            AnimationType.SLIDE_RIGHT);
                }
                return true;
            }
        });

        return rootView;
    }


    public void fillProductData() {

        producerName.setText(producer.getProducerName());

        producerDescription.setText(producer.getLongDescription());

        mDrawableBuilder = TextDrawable.builder().beginConfig()

                .withBorder(4).endConfig().roundRect(10);

        drawable = mDrawableBuilder.build(
                String.valueOf(producer.getProducerName().charAt(0)),
                mColorGenerator.getColor(producer.getProducerName()));

        Picasso.with(getActivity())
                .load(producer.getImageUrl()).placeholder(drawable)
                .error(drawable).fit().centerCrop()
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(producerImage, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        // Try again online if cache failed

                        Picasso.with(getActivity())
                                .load(producer
                                        .getImageUrl())
                                .placeholder(drawable).error(drawable)
                                .fit().centerCrop().into(producerImage);
                    }
                });


        mDrawableBuilder = TextDrawable.builder().beginConfig()
                .withBorder(4).endConfig().roundRect(10);

        SimilarProductsPagerAdapter mCustomPagerAdapter = new SimilarProductsPagerAdapter(
                getActivity(), subcategoryKey);

        sellersProducts.setAdapter(mCustomPagerAdapter);

        sellersProducts.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(int position) {

                Utils.switchFragmentWithAnimation(R.id.frag_container,
                        new ProducerFragment(CenterRepository.getCenterRepository()
                                .getMapOfProductsInCategory().get(subcategoryKey).get(position).getProducer(), subcategoryKey),
                        ((ECartHomeActivity) (getContext())), null,
                        AnimationType.SLIDE_LEFT);

                Utils.vibrate(getActivity());

            }
        });
    }
}
