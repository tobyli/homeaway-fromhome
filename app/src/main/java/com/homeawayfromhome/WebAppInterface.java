package com.homeawayfromhome;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.TextView;
import android.widget.Toast;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

/**
 * Created by toby on 11/13/14.
 */
public class WebAppInterface {
    Context mContext;
    TextView mBarTextView;
    SlidingUpPanelLayout mBarLayout;

    WebAppInterface(Context context, TextView barTextView, SlidingUpPanelLayout barLayout){
        mContext = context;
        mBarTextView = barTextView;
        mBarLayout = barLayout;


    }

    @JavascriptInterface
    public void changeBarContent(String content) {
        mBarTextView.setText(content + "\n\n" + content + " is a very nice neighborhood");
        mBarLayout.invalidate();



    }

    @JavascriptInterface
    public void makeToast(String content) {
        Toast.makeText(mContext, content, Toast.LENGTH_SHORT);


    }
}
