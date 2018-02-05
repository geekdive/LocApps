package id.dev.septiyadi.locapps;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int progressStatus = 0;
    private Handler handler = new Handler();

    TextView tvProgress;
    ProgressBar pgProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvProgress = (TextView)findViewById(R.id.txtProgress);
        pgProgress = (ProgressBar)findViewById(R.id.pgrProgress);

        //TODO 1: Create Method Splash
        splashRun();

    }

    public void splashRun(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < 100){
                    progressStatus += 1;
                    try {
                        Thread.sleep(50);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pgProgress.setProgress(progressStatus);
                            tvProgress.setText(progressStatus + "%");
                            int hasil = progressStatus;
                            if(hasil == 100){
                                Intent i = new Intent(MainActivity.this, connectionActivity.class);
                                startActivity(i);
                                //Finish the MainActivity for Disable Access Go Back Pressed
                                finish();
                            }
                        }
                    });
                }
            }
        }).start();
    }
}
