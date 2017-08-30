package com.villes.connect3;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    //2 means unplayed
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    public void dropIn(View view){


        ImageView counter = (ImageView) view;
        System.out.println(counter.getTag().toString());
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

        if (gameState[tappedCounter] == 2){
            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1000f);
            if(activePlayer == 0){
                counter.setImageResource(R.drawable.black);
                activePlayer = 1;
            }else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);
            Log.i("TEST", "dropIn: " + view.getId());
            for(int[] winningPosition : winningPositions){
                if(gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2){
                    System.out.println(gameState[winningPosition[0]]);

                }

            }
        }






    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
