package com.homeawayfromhome;


        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;


public class Exploring extends Activity {

    public final static String S_TAB = "away";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exploring);


        Intent intent = getIntent();
        String button_new = intent.getStringExtra(NewPlace.NEW_INFO);
        String button_home = intent.getStringExtra(NewPlace.HomeInfo);

        Button button_1 = (Button) findViewById(R.id.button_home);
        button_1.setText("Map of " + button_home);

        Button button_2 = (Button) findViewById(R.id.button_new);
        button_2.setText("Map of " + button_new);

//        Button button_3 = (Button) findViewById(R.id.home_neighbor);
//        button_3.setText("Neighborhood in " + button_home);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exploring, menu);
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


    public void exploreHome(View view)
    {
        Intent intent = new Intent(this, RootMap.class);
        intent.putExtra(S_TAB,"Madison");
        startActivity(intent);

    }

    public void exploreNew(View view)
    {
        Intent intent = new Intent(this, RootMap.class);
        intent.putExtra(S_TAB,"Minneapolis");
        startActivity(intent);

    }

//    public void next(View view)
//    {
//        Intent intent = new Intent(this, NewPlace.class);
//        EditText most_familiar = (EditText) findViewById(R.id.you_familiar);
//        String home = most_familiar.getText().toString();
//        intent.putExtra(AWAY_TAB,"Minneapolis");
//        startActivity(intent);
//
//    }

//    public void HomeNeighbor(View view)
//    {
//        Intent intent = new Intent(this, RootMap.class);
//        startActivity(intent);
//
//    }


}
