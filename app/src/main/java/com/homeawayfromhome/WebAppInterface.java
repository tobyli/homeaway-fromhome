package com.homeawayfromhome;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.webkit.JavascriptInterface;
import android.widget.Button;
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
    SlidingUpPanelLayout mBarLayout;


    WebAppInterface(Context context, TextView barTextView, TextView barTextView2, TextView barTextView3, SlidingUpPanelLayout barLayout){
        mContext = context;
        mBarTextView = barTextView;
        mBarTextView2 = barTextView2;
        mBarTextView3 = barTextView3;
        mBarLayout = barLayout;


    }

    @JavascriptInterface
    public void changeBarContent(String content) {
        final String content2 = content;
        runOnUiThread(new Runnable() {

            public void run() {
                mBarTextView.setText(content2);
                mBarTextView2.setText(Html.fromHtml("<b>"+ content2 + "</b> is similar to <b>Main Street</b> in <b>Madison, WI</b> because it has a lot of bars and drunk people. <b>" + content2 + "</b> is also considered as the home for crazy people."));
                mBarTextView3.setText(Html.fromHtml("Popular attractions of <b>" + content2 +"</b> are <b><a href=http://en.wikipedia.org/wiki/Zombie>Zombie's Nest</a></b> and <b><a href=http://en.wikipedia.org/wiki/Haunted_house>Haunted House</a></b>."));
                mBarLayout.invalidate();
            }
        });

    }






    @JavascriptInterface
    public void makeToast(String content) {
        Toast.makeText(mContext, content, Toast.LENGTH_SHORT);


    }
}
