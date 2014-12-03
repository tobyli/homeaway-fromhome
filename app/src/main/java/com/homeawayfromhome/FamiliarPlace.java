package com.homeawayfromhome;



        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.EditText;


public class FamiliarPlace extends Activity {

    public final static String HOME_INFO = "information";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familiar_place);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_familiar_place, menu);
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
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);

    }

    public void next(View view)
    {
        Intent intent = new Intent(this, NewPlace.class);
        EditText most_familiar = (EditText) findViewById(R.id.you_familiar);
        String home = most_familiar.getText().toString();
        intent.putExtra(HOME_INFO,home);
        startActivity(intent);

    }
}
