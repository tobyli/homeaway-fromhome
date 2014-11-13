package com.homeawayfromhome;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.SearchView;
import android.widget.TextView;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;


public class ResultMap extends Activity {

    private WebView mWebView;
    private SearchView mSearchView;
    private TextView mBarTextView;
    private SlidingUpPanelLayout mLayout;

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

        mBarTextView = (TextView) findViewById(R.id.bar_texview);
        mBarTextView.setText("I'm a slide bar!\nI'm a slide bar!\nI'm a slide bar!\nI'm a slide bar!\nI'm a slide bar!");
        mBarTextView.setTextSize(30);

        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.setWebViewClient(new MyWebViewClient());
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setLayerType(mWebView.LAYER_TYPE_SOFTWARE, null);
        mWebView.loadUrl("file:///android_asset/map.html");
        mWebView.addJavascriptInterface(new WebAppInterface(this, mBarTextView), "Android");

        mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);





        ActionBar actionBar = this.getActionBar();
        actionBar.setTitle("Result Map");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#db4437")));




    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result_map, menu);

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
}
