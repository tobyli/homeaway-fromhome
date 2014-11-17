package com.homeawayfromhome;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

/**
 * Created by toby on 11/13/14.
 */
public class WebAppInterface extends Activity {
    Context mContext;
    TextView mBarTextView;
    TextView mBarTextView2;
    TextView mBarTextView3;
    WebView mWebView;
    SlidingUpPanelLayout mBarLayout;
    Button mSearchButton;
    ImageView mImageView;

    WebAppInterface(Context context, TextView barTextView, TextView barTextView2, TextView barTextView3, SlidingUpPanelLayout barLayout, Button searchButton, WebView webView, ImageView imageView){
        mContext = context;
        mWebView = webView;
        mBarTextView = barTextView;
        mBarTextView2 = barTextView2;
        mBarTextView3 = barTextView3;
        mBarLayout = barLayout;
        mSearchButton = searchButton;
        mImageView = imageView;

    }

    @JavascriptInterface
    public void changeBarContent(String content, int option) {
        if (option == 0) {
            final String content2 = content;
            runOnUiThread(new Runnable() {

                public void run() {
                    mImageView.setImageResource(R.drawable.town_photo);
                    mBarTextView.setText(content2);
                    mBarTextView2.setText(Html.fromHtml("<b>" + content2 + "</b> is similar to <b>Main Street</b> in <b>Madison, WI</b> because it has a lot of bars and drunk people. <b>" + content2 + "</b> is also considered as the home for crazy people."));
                    mBarTextView3.setText(Html.fromHtml("Popular attractions of <b>" + content2 + "</b> are <b><a href=http://en.wikipedia.org/wiki/Zombie>Zombie's Nest</a></b> and <b><a href=http://en.wikipedia.org/wiki/Haunted_house>Haunted House</a></b>."));
                    mBarLayout.invalidate();
                    mSearchButton.setText("Zoom");
                    mSearchButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.zoom_in_unselected, 0, 0, 0);
                    mSearchButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mWebView.loadUrl("javascript:zoomDetail()");
                        }
                    });
                }
            });
        } else if (option == 1) {
            final String content2 = content;
            runOnUiThread(new Runnable() {

                public void run() {
                    mImageView.setImageResource(R.drawable.food_photo);

                    mBarTextView.setText(content2);
                    mBarTextView2.setText(Html.fromHtml("<b>" + content2 + "</b> is similar to <b>Joey's Family Restaurant</b> in <b>Madison, WI</b> because it has a lot of cheesy food. Like <b>Joey's</b>,  <b>" + content2 + "</b> is also considered as the a cozy family style restaurant."));
                    mBarTextView3.setText(Html.fromHtml("Popular dishes of <b>" + content2 + "</b> are <b><a href=http://en.wikipedia.org/wiki/Zombie>Wisconsin Cheese Curd</a></b> and <b><a href=http://en.wikipedia.org/wiki/Haunted_house>Homemade Apple Pie</a></b>."));
                    mBarLayout.invalidate();
                    mSearchButton.setText("      Detail");
                    mSearchButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    mSearchButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mBarLayout.isPanelExpanded() == true) {
                                mBarLayout.collapsePanel();
                                mSearchButton.setText("      Detail");
                            } else {
                                mBarLayout.expandPanel();
                                mSearchButton.setText("       Close");
                            }
                        }
                    });
                }
            });

        } else {
            final String content2 = content;
            runOnUiThread(new Runnable() {

                public void run() {
                    mBarTextView.setText(content2);
                    mBarTextView2.setText(Html.fromHtml("<b>" + content2 + "</b> in <b>Madison, WI</b> is a business area with a lot of cheese shop. <b>" + content2 + "</b> is also considered as the home for college students."));
                    mBarTextView3.setText(Html.fromHtml("Popular attractions of <b>" + content2 + "</b> are <b><a href=http://en.wikipedia.org/wiki/Zombie>Cheese House</a></b> and <b><a href=http://en.wikipedia.org/wiki/Haunted_house>Madison Theater</a></b>."));
                }


            });

        }
    }






    @JavascriptInterface
    public void makeToast(String content) {
        Toast.makeText(mContext, content, Toast.LENGTH_SHORT);


    }
}
