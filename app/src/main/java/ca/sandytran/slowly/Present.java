package ca.sandytran.slowly;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Present extends AppCompatActivity implements View.OnClickListener {

    private Button btnNext;
    private ImageButton btnHome;
    private Button btnHome2;
    private TextView text;
    private int itemIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnNext = (Button) findViewById(R.id.btnNext);
        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnHome2 = (Button) findViewById(R.id.btnHome2);

        Intent i = getIntent();
        itemIndex = i.getIntExtra("itemIndex", 0);

        text = (TextView) findViewById(R.id.txtDescription);

        btnNext.setOnClickListener(this);
        btnHome.setOnClickListener(this);
        btnHome2.setOnClickListener(this);

        updateText();

    }

    private void updateText(){

        switch (itemIndex){
            case 0:
                //intro
                text.setText("Here we will engage the senses to connect with the present. " +
                         "\n \n" +
                        "Becoming aware of your surroundings will reduce anxiety by grounding you in the " +
                        "present moment.");
                break;
            case 1:
                //sight
                text.setText("Five things you can see.\n \n Think of a colour. \nLook around you and find five things around you of that colour.");
                break;
            case 2:
                //touch
                text.setText("Four things you can touch. \n \n What are four things that you can feel right now? \n What are your hands touching? \n" +
                                "Feel the surface of the table in front of you or the texture of the chair you're sitting on.");
                break;
            case 3:
                //sound
                text.setText("Three things you can hear. \n \n What are three things you can hear right now? \n Where are they coming from? \n Do they sound far away or nearby?");
                break;
            case 4:
                //smell
                text.setText("Two things that you can smell. \n \n Can you smell the laundry detergent in your clothes? \n The aroma of the beverage in front of you? \n The fragrance of a bar of soap?");
                break;
            case 5:
                //yourself
                text.setText("One thing that you like about yourself. \n \nWhat is one thing that you like about yourself?");
                break;
            default:
                break;
        }

        if (itemIndex == 0) {
            btnNext.setText("Begin");
        } else if (itemIndex==5){
            btnNext.setText("Repeat");
            btnHome2.setVisibility(View.VISIBLE);
            btnHome2.setEnabled(true);
        } else {
            btnNext.setText("Next");
        }

    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.btnHome || v.getId()==R.id.btnHome2){
            Intent h = new Intent(Present.this, MainActivity.class);
            startActivity(h);
        } else {
            if (itemIndex < 5) {
                Intent i = new Intent(Present.this, Present.class);
                i.putExtra("itemIndex", itemIndex + 1);
                startActivity(i);
            } else {
                Intent i = new Intent(Present.this, Present.class);
                i.putExtra("itemIndex", 1);
                startActivity(i);
            }
        }
    }
}
