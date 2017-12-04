package co.com.a4apps.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TaskUnoActivity extends AppCompatActivity {

    private ListView lV;
    private String[] syst = {"Ubuntu", "Android", "iOS&", "Windows", "Mac OSX",
            "Google Chrome OS", "Debian", "Mandriva", "Solaris", "Unix"};

    String TAG = "TaskUno";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_uno);

        lV = findViewById(R.id.lV_1);
        lV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Has Presionado el elmento "+i,Toast.LENGTH_SHORT).show();
            }
        });
    }


    private class CargarListView extends AsyncTask<Void, Void, ArrayAdapter<String>> {
        Context context;
        ProgressDialog pDialog;

        public CargarListView(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();

            Log.i(TAG,"Bien 1");

            Log.i("AsyncTask PreExecute", "Entra en PreExecute");
            pDialog = new ProgressDialog(context);
            pDialog.setMessage("Cargando Lista");
            pDialog.setCancelable(true);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.show();
        }

        @Override
        protected ArrayAdapter<String> doInBackground(Void... arg0) {
            // TODO Auto-generated method stub

            Log.i(TAG,"Bien 2");

            try {
                Thread.sleep(2000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            Log.i("doInBackground", "Crea el Adaptador");
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, syst);
            return adaptador;
        }

        @Override
        protected void onPostExecute(ArrayAdapter<String> result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            Log.i(TAG,"Bien 3");
            lV.setAdapter(result);
            pDialog.dismiss();
        }
    }
}
