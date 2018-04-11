package com.example.hasanzian.courtcounter;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0 ;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reset = findViewById(R.id.reset_button);
        //displayForTeamA(54);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        int orienation = this.getResources().getConfiguration().orientation;
        if(orienation  == Configuration.ORIENTATION_PORTRAIT){
            menu.findItem(R.id.reset_menu).setVisible(false);
            reset.setVisibility(View.VISIBLE);
        }
        else {
            menu.findItem(R.id.reset_menu).setVisible(true);
            reset.setVisibility(View.INVISIBLE);
            }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();
         if(id == R.id.reset_menu){
            scoreTeamA=0;
            scoreTeamB=0;
            displayForTeamA(scoreTeamA);
            displayForTeamB(scoreTeamB);
        }
        return super.onOptionsItemSelected(item);
    }

    public void addThreePointsTeamA(View view){
        scoreTeamA+=3;
        displayForTeamA(scoreTeamA);
    }

    public void addTwoPointsTeamA(View view){
        scoreTeamA+=2;
        displayForTeamA(scoreTeamA);
    }
    public void addOnePointsTeamA(View view){
        scoreTeamA+=1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }



    public void addThreePointsTeamB(View view) {
        scoreTeamB+=3;
        displayForTeamB(scoreTeamB);
    }

    public void addTwoPointsTeamB(View view) {
        scoreTeamB+=2;
        displayForTeamB(scoreTeamB);
    }

    public void addOnePointsTeamB(View view) {
        scoreTeamB+=1;
        displayForTeamB(scoreTeamB);
    }

    public void resetScore(View view) {
        scoreTeamA=0;
        scoreTeamB=0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
