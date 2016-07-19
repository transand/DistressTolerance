package ca.sandytran.slowly;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMeditation;
    private Button btnBreathing;
    private Button btnPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnMeditation = (Button) findViewById(R.id.btnMeditation);
        btnBreathing = (Button) findViewById(R.id.btnBreathing);
        btnPresent = (Button) findViewById(R.id.btnPresent);

        btnMeditation.setOnClickListener(this);
        btnBreathing.setOnClickListener(this);
        btnPresent.setOnClickListener(this);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnMeditation:
                Intent i = new Intent(getApplicationContext(), Meditation.class);
                startActivity(i);
                break;
            case R.id.btnBreathing:
                Intent j = new Intent(getApplicationContext(), Breathing.class);
                startActivity(j);
                break;
            case R.id.btnPresent:
                Intent k = new Intent(getApplicationContext(), Present.class);
                startActivity(k);
                break;
            default:
                break;
        }
    }
}
