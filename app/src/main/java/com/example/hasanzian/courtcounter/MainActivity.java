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

    private int mScoreTeamA = 0;
    private int mScoreTeamB = 0;
    private TextView mTeamATextView;
    private TextView mTeamBTextView;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reset = findViewById(R.id.reset_button);
        mTeamATextView = findViewById(R.id.team_a_score);
        mTeamBTextView = findViewById(R.id.team_b_score);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        int orientation = this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            menu.findItem(R.id.reset_menu).setVisible(false);
            reset.setVisibility(View.VISIBLE);
        } else {
            menu.findItem(R.id.reset_menu).setVisible(true);
            reset.setVisibility(View.INVISIBLE);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.reset_menu) {
            mScoreTeamA = 0;
            mScoreTeamB = 0;
            displayForTeamA(mScoreTeamA);
            displayForTeamB(mScoreTeamB);
        }
        return super.onOptionsItemSelected(item);
    }

    public void addThreePointsTeamA(View view) {
        mScoreTeamA += 3;
        displayForTeamA(mScoreTeamA);
    }

    public void addTwoPointsTeamA(View view) {
        mScoreTeamA += 2;
        displayForTeamA(mScoreTeamA);
    }

    public void addOnePointsTeamA(View view) {
        mScoreTeamA += 1;
        displayForTeamA(mScoreTeamA);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreePointsTeamB(View view) {
        mScoreTeamB += 3;
        displayForTeamB(mScoreTeamB);
    }

    public void addTwoPointsTeamB(View view) {
        mScoreTeamB += 2;
        displayForTeamB(mScoreTeamB);
    }

    public void addOnePointsTeamB(View view) {
        mScoreTeamB += 1;
        displayForTeamB(mScoreTeamB);
    }

    public void resetScore(View view) {
        mScoreTeamA = 0;
        mScoreTeamB = 0;
        displayForTeamA(mScoreTeamA);
        displayForTeamB(mScoreTeamB);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(getString(R.string.team_a_key), mScoreTeamA);
        outState.putInt(getString(R.string.team_b_key), mScoreTeamB);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mTeamATextView.setText(String.valueOf(savedInstanceState.getInt(getString(R.string.team_a_key))));
        mTeamBTextView.setText(String.valueOf(savedInstanceState.getInt(getString(R.string.team_b_key))));
    }
}
