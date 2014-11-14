package com.homeawayfromhome;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by toby on 11/13/14.
 */
public class WebAppInterface {
    Context mContext;
    TextView mBarTextView;

    WebAppInterface(Context context, TextView barTextView){
        mContext = context;
        mBarTextView = barTextView;
    }

    @JavascriptInterface
    public void changeBarContent(String content) {
        mBarTextView.setText(content);
        mBarTextView.


    }

    @JavascriptInterface
    public void makeToast(String content) {
        Toast.makeText(mContext, content, Toast.LENGTH_SHORT);


    }
}
