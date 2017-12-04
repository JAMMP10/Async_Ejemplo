package co.com.a4apps.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class AgridActivity extends AppCompatActivity {

    GridView gridView;
    ImageAdapter imageAdapter;

    String TAG = "TaskDos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agrid);

        gridView = (GridView)findViewById(R.id.gView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(AgridActivity.this, DetailsActivity.class);
                i.putExtra("position",position);
                startActivity(i);
            }
        });

    }

    private class gAsync extends AsyncTask<Void, Void, ImageAdapter>{

        Context context;
        ProgressDialog pDialog;

        public gAsync (Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.i(TAG,"Bien 1");

            pDialog = new ProgressDialog(context);
            pDialog.setMessage("Cargando Lista");
            pDialog.setCancelable(true);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.show();

        }

        @Override
        protected ImageAdapter doInBackground(Void... voids) {
            Log.i(TAG,"Bien 2");
            try{
                Thread.sleep(2000);
            }catch(Exception ex){
                ex.printStackTrace();
            }

            imageAdapter = new ImageAdapter(context);
            return imageAdapter;
        }

        @Override
        protected void onPostExecute(ImageAdapter imagesAdapter) {
            super.onPostExecute(imagesAdapter);
            Log.i(TAG,"Bien 3");
            gridView.setAdapter(imagesAdapter);
            pDialog.dismiss();
        }
    }
}
