package com.begs.mobile.view.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.begs.mobile.R;
import com.begs.mobile.domain.helper.Connectivity;
import com.begs.mobile.domain.mining.AprioriFrequentItemsetGenerator;
import com.begs.mobile.domain.mining.FrequentItemsetData;
import com.begs.mobile.model.CenterRepository;
import com.begs.mobile.model.entities.Money;
import com.begs.mobile.model.entities.Product;
import com.begs.mobile.util.PreferenceHelper;
import com.begs.mobile.util.TinyDB;
import com.begs.mobile.util.Utils;
import com.begs.mobile.util.Utils.AnimationType;
import com.begs.mobile.view.fragment.HomeFragment;
import com.begs.mobile.view.fragment.WhatsNewDialog;
import com.wang.avi.AVLoadingIndicatorView;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ECartHomeActivity extends AppCompatActivity {

    public static final double MINIMUM_SUPPORT = 0.1;
    private static final String TAG = ECartHomeActivity.class.getSimpleName();
    AprioriFrequentItemsetGenerator<String> generator =
            new AprioriFrequentItemsetGenerator<>();
    private int itemCount = 0;
    private BigDecimal checkoutAmount = new BigDecimal(BigInteger.ZERO);
    private DrawerLayout mDrawerLayout;

    private TextView checkOutAmount, itemCountTextView;
    private AVLoadingIndicatorView progressBar;

    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecart);

        CenterRepository.getCenterRepository().setListOfProductsInShoppingList(
                new TinyDB(getApplicationContext()).getListObject(
                        PreferenceHelper.MY_CART_LIST_LOCAL, Product.class));

        itemCount = CenterRepository.getCenterRepository().getListOfProductsInShoppingList()
                .size();

        //	makeFakeVolleyJsonArrayRequest();

        itemCountTextView = (TextView) findViewById(R.id.item_count);
        itemCountTextView.setSelected(true);
        itemCountTextView.setText(String.valueOf(itemCount));

        checkOutAmount = (TextView) findViewById(R.id.checkout_amount);
        checkOutAmount.setSelected(true);
        checkOutAmount.setText(Money.dollars(checkoutAmount).toString());

        mDrawerLayout = (DrawerLayout) findViewById(R.id.nav_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);

        progressBar = (AVLoadingIndicatorView) findViewById(R.id.loading_bar);

        checkOutAmount.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Utils.vibrate(getApplicationContext());

                Utils.switchContent(R.id.frag_container,
                        Utils.MY_CART, ECartHomeActivity.this,
                        AnimationType.SLIDE_UP);

            }
        });


        if (itemCount != 0) {
            for (Product product : CenterRepository.getCenterRepository()
                    .getListOfProductsInShoppingList()) {

                updateCheckOutAmount(
                        BigDecimal.valueOf(Long.valueOf(product.getSellMRP())),
                        true);
            }
        }

        findViewById(R.id.item_counter).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Utils.vibrate(getApplicationContext());
                        Utils.switchContent(R.id.frag_container,
                                Utils.MY_CART,
                                ECartHomeActivity.this, AnimationType.SLIDE_UP);

                    }
                });

        findViewById(R.id.checkout).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        findViewById(R.id.checkout_item_root).setVisibility(View.GONE);

                        Utils.vibrate(getApplicationContext());

                        moveToOrderDetailsPage();

                    }
                });

        Utils.switchFragmentWithAnimation(R.id.frag_container,
                new HomeFragment(), this, Utils.HOME_FRAGMENT,
                AnimationType.SLIDE_UP);

        toggleBannerVisibility();

        mNavigationView
                .setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        menuItem.setChecked(true);
                        switch (menuItem.getItemId()) {
                            case R.id.home:

                                mDrawerLayout.closeDrawers();

                                Utils.switchContent(R.id.frag_container,
                                        Utils.HOME_FRAGMENT,
                                        ECartHomeActivity.this,
                                        AnimationType.SLIDE_LEFT);

                                return true;

                            case R.id.my_cart:

                                mDrawerLayout.closeDrawers();

                                Utils.switchContent(R.id.frag_container,
                                        Utils.MY_CART,
                                        ECartHomeActivity.this,
                                        AnimationType.SLIDE_LEFT);
                                return true;

                            case R.id.shopping_list:

                                mDrawerLayout.closeDrawers();

                                Utils.switchContent(R.id.frag_container,
                                        Utils.SHOPPING_LIST_TAG,
                                        ECartHomeActivity.this,
                                        AnimationType.SLIDE_LEFT);
                                return true;

                            case R.id.my_friends:

                                mDrawerLayout.closeDrawers();

                                Utils.switchContent(R.id.frag_container,
                                        Utils.MY_FRIENDS,
                                        ECartHomeActivity.this,
                                        AnimationType.SLIDE_LEFT);
                                return true;

                            case R.id.checkout:

                                mDrawerLayout.closeDrawers();

                                Utils.switchContent(R.id.frag_container,
                                        Utils.MY_ORDER_DETAILS_FRAGMENT,
                                        ECartHomeActivity.this,
                                        AnimationType.SLIDE_LEFT);
                                return true;


                            case R.id.contact_us:

                                mDrawerLayout.closeDrawers();

                                Utils.switchContent(R.id.frag_container,
                                        Utils.CONTACT_US_FRAGMENT,
                                        ECartHomeActivity.this,
                                        AnimationType.SLIDE_LEFT);
                                return true;

                            case R.id.settings:

                                mDrawerLayout.closeDrawers();

                                Utils.switchContent(R.id.frag_container,
                                        Utils.SETTINGS_FRAGMENT_TAG,
                                        ECartHomeActivity.this,
                                        AnimationType.SLIDE_LEFT);
                                return true;
                            default:
                                return true;
                        }
                    }
                });

    }

    public AVLoadingIndicatorView getProgressBar() {
        return progressBar;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void updateItemCount(boolean ifIncrement) {
        if (ifIncrement) {
            itemCount++;
            itemCountTextView.setText(String.valueOf(itemCount));

        } else {
            itemCountTextView.setText(String.valueOf(itemCount <= 0 ? 0
                    : --itemCount));
        }

        toggleBannerVisibility();
    }

    public void updateCheckOutAmount(BigDecimal amount, boolean increment) {

        if (increment) {
            checkoutAmount = checkoutAmount.add(amount);
        } else {
            if (checkoutAmount.signum() == 1)
                checkoutAmount = checkoutAmount.subtract(amount);
        }

        checkOutAmount.setText(Money.dollars(checkoutAmount).toString());
    }

    @Override
    protected void onPause() {
        super.onPause();

        new TinyDB(getApplicationContext()).putListObject(
                PreferenceHelper.MY_CART_LIST_LOCAL, CenterRepository
                        .getCenterRepository().getListOfProductsInShoppingList());
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Show Offline Error Message
        if (!Connectivity.isConnected(getApplicationContext())) {
            final Dialog dialog = new Dialog(ECartHomeActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.connection_dialog);
            Button dialogButton = (Button) dialog
                    .findViewById(R.id.dialogButtonOK);

            // if button is clicked, close the custom dialog
            dialogButton.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog.dismiss();

                }
            });

            dialog.show();
        }

        // Show Whats New Features If Requires
        new WhatsNewDialog(this);
    }

    /*
     * Toggles Between Offer Banner and Checkout Amount. If Cart is Empty SHow
     * Banner else display total amount and item count
     */
    public void toggleBannerVisibility() {
        if (itemCount == 0) {
            findViewById(R.id.checkout_item_root).setVisibility(View.GONE);
        } else {
            findViewById(R.id.checkout_item_root).setVisibility(View.VISIBLE);
        }
    }

    /*
     * get total checkout amount
     */
    public BigDecimal getCheckoutAmount() {
        return checkoutAmount;
    }

    /*
     * Get Number of items in cart
     */
    public int getItemCount() {
        return itemCount;
    }

    /*
     * Get Navigation drawer
     */
    public DrawerLayout getmDrawerLayout() {
        return mDrawerLayout;
    }


    public void moveToOrderDetailsPage() {
        Utils.switchContent(R.id.frag_container,
                Utils.MY_ORDER_DETAILS_FRAGMENT,
                ECartHomeActivity.this,
                AnimationType.SLIDE_LEFT);
    }

}
