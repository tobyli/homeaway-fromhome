package com.homeawayfromhome;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

/**
 * Created by toby on 11/16/14.
 */
public class AwayMapFragmentTab extends Fragment {
    private View rootView;
    private RootMap rootActivity;
    private WebView mWebView;
    private TextView mBarTextView;
    private TextView mBarTextView2;
    private TextView mBarTextView3;
    private TextView mScoreText;
    private SlidingUpPanelLayout mLayout;
    Button searchButton;

    public AwayMapFragmentTab(){

    }

    public AwayMapFragmentTab(RootMap rootActivity){
        this.rootActivity = rootActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.activity_result_map, container, false);
        this.rootView = rootView;
        mBarTextView = (TextView) rootView.findViewById(R.id.bar_textview);
        mBarTextView.setText("Minneapolis");


        mBarTextView2 = (TextView) rootView.findViewById(R.id.bar_textview2);
        mBarTextView2.setText(Html.fromHtml("Similar to <b>Madison</b>, <b>Minneapolis</b> is a spooky city with ghosts and zombies everywhere. There are also quite a lot of drunk people on the street."));

        mBarTextView3 = (TextView) rootView.findViewById(R.id.bar_textview3 );
        mBarTextView3.setText(Html.fromHtml("Popular attractions of <b>Minneapolis</b> are <b><a href=http://en.wikipedia.org/wiki/Zombie>Zombie's Nest</a></b> and <b><a href=http://en.wikipedia.org/wiki/Haunted_house>Haunted House</a></b>."));

        mWebView = (WebView) rootView.findViewById(R.id.webview);
        mWebView.setWebViewClient(new MyWebViewClient());
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setLayerType(mWebView.LAYER_TYPE_SOFTWARE, null);
        mWebView.loadUrl("file:///android_asset/MPLSMap.html");
        mLayout = (SlidingUpPanelLayout) rootView.findViewById(R.id.sliding_layout);
        mLayout.setBackgroundColor(Color.parseColor("#dfdfdf"));
        mWebView.addJavascriptInterface(new WebAppInterface(rootActivity, mBarTextView, mBarTextView2, mBarTextView3, mLayout), "Android");
        mWebView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mLayout.expandPanel((float)0.001);
                        mLayout.collapsePanel();

                    }
                }, 50);

                return false;
            }
        });







        searchButton = (Button) rootView.findViewById(R.id.button);
        searchButton.getBackground().setColorFilter(Color.parseColor("#db4437"), PorterDuff.Mode.OVERLAY);


        mScoreText = (TextView) rootView.findViewById(R.id.bar_textScoreView);
        mScoreText.setText(Html.fromHtml("Similarity Score: <b>7.2/10</b>"));
        return rootView;
    }
    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public void search(View view){
        //response to the search button
        Intent intent = new Intent(rootActivity, ResultMap.class);
        startActivity(intent);
        rootActivity.overridePendingTransition(0, 0);
    }

}
