package com.homeawayfromhome;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;


public class ResultMap extends Activity {

    private WebView mWebView;
    private SearchView mSearchView;
    private TextView mBarTextView;
    private TextView mBarTextView2;
    private TextView mBarTextView3;
    private TextView mScoreText;
    private SlidingUpPanelLayout mLayout;
    Button detailButton;
    private ImageView mImageView;
//    boolean list_status = false;



    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_result_map);

            mBarTextView = (TextView) findViewById(R.id.bar_textview);
            mBarTextView.setText("Minneapolis");


            mBarTextView2 = (TextView) findViewById(R.id.bar_textview2);
            mBarTextView2.setText(Html.fromHtml("Similar to <b>Madison</b>, <b>Minneapolis</b> is a spooky city with ghosts and zombies everywhere. There are also quite a lot of drunk people on the street."));

            mBarTextView3 = (TextView) findViewById(R.id.bar_textview3);
            mBarTextView3.setText(Html.fromHtml("Popular attractions of <b>Minneapolis</b> are <b><a href=http://en.wikipedia.org/wiki/Zombie>Zombie's Nest</a></b> and <b><a href=http://en.wikipedia.org/wiki/Haunted_house>Haunted House</a></b>. <b>Minneaplis</b> is also famous for its deep-fried bloody pie on-a-stick"));

            mWebView = (WebView) findViewById(R.id.webview);
            mWebView.setWebViewClient(new MyWebViewClient());
            WebSettings webSettings = mWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            mWebView.setLayerType(mWebView.LAYER_TYPE_SOFTWARE, null);
            mWebView.loadUrl("file:///android_asset/map.html");
            mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
            mImageView = (ImageView) findViewById(R.id.imageview);

            mWebView.addJavascriptInterface(new WebAppInterface(this, mBarTextView, mBarTextView2, mBarTextView3, mLayout, detailButton, mWebView, mImageView), "Android");
            mWebView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mLayout.expandPanel((float) 0.001);
                            mLayout.collapsePanel();

                        }
                    }, 50);

                    return false;
                }
            });


            ActionBar actionBar = this.getActionBar();
            actionBar.setTitle("Result Map");
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#db4437")));

            detailButton = (Button) findViewById(R.id.button);
            detailButton.getBackground().setColorFilter(Color.parseColor("#db4437"), PorterDuff.Mode.OVERLAY);

            mScoreText = (TextView) findViewById(R.id.bar_textScoreView);
            mScoreText.setText(Html.fromHtml("Similarity Score: <b>7.2/10</b>"));


        }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_root_map, menu);

        mSearchView = ((SearchView)menu.findItem(R.id.searchView).getActionView());

        //mSearchView.setIconifiedByDefault(false);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    public void goList()
//    {
//        Intent intent = new Intent(this, ResultList.class);
//        startActivity(intent);
//
//    }



}
