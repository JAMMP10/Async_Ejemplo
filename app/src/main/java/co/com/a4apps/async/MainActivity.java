package co.com.a4apps.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_1, btn_2;
    String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_1 = findViewById(R.id.btn_l);
        btn_2 = findViewById(R.id.btn_g);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TaskUnoActivity.class);
                startActivity(intent);
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AgridActivity.class);
                startActivity(intent);
            }
        });

    }

    private class ast extends AsyncTask <Void, Context, String[]>{

        protected void onPreExecute() {
            super.onPreExecute();

            Log.i(TAG,"Bien 1");

        }
        @Override
        protected String[] doInBackground(Void... voids) {
            return new String[0];
        }
    }
}
