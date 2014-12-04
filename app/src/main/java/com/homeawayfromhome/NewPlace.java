package com.homeawayfromhome;


        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.EditText;


public class NewPlace extends Activity {

    public final static String NEW_INFO = "information";
    public final static String HomeInfo = "homeinformation";

//    Intent intent_1 = getIntent();
//    String home_frombefore = intent_1.getStringExtra(FamiliarPlace.HOME_INFO);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_place);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_place, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void back(View view)
    {
        Intent intent = new Intent(this, FamiliarPlace.class);
        startActivity(intent);

    }

    public void next(View view)
    {
        Intent intent_1 = getIntent();
        String home_frombefore = intent_1.getStringExtra(FamiliarPlace.HOME_INFO);

        EditText new_city = (EditText) findViewById(R.id.new_ex);
        String new_neighborhood = new_city.getText().toString();

        Intent intent = new Intent(this, Exploring.class);
        intent.putExtra(NEW_INFO,new_neighborhood);
        intent.putExtra(HomeInfo,home_frombefore);
        startActivity(intent);

    }
}
