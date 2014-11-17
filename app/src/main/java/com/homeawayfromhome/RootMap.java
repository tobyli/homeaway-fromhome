package com.homeawayfromhome;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;

import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TabHost;
import android.widget.TextView;
import com.homeawayfromhome.TabListener;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

public class RootMap extends Activity {
    private SearchView mSearchView;
    public ActionBar.Tab homeMapTab, awayMapTab;
    Fragment homeFragmentMapTab = new HomeMapFragmentTab(this);
    Fragment awayFragmentMapTab = new AwayMapFragmentTab(this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_map);
        ActionBar actionBar = this.getActionBar();
        //actionBar.setDisplayShowHomeEnabled(false);
        //actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#cfcfcf")));



        homeMapTab = actionBar.newTab().setText("               Madison");
        awayMapTab = actionBar.newTab().setText("            Minneapolis");
        homeMapTab.setTabListener(new TabListener(homeFragmentMapTab));
        awayMapTab.setTabListener(new TabListener(awayFragmentMapTab));

        actionBar.addTab(homeMapTab);
        actionBar.addTab(awayMapTab);

        actionBar.setTitle("Map Search");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#db4437")));
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void search(View view){
        //response to the search button
        awayMapTab.select();

    }

    public void zoomDetail(View view){
        //response to the search button
        ((AwayMapFragmentTab) awayFragmentMapTab).zoomDetail();

    }




}









