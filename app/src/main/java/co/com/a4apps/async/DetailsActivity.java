package co.com.a4apps.async;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    Intent i;
    int position;
    ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        adapter = new ImageAdapter(this);

        i           = getIntent();
        position    = i.getIntExtra("position",-1);


        imageView   = findViewById(R.id.dimage);
        textView    = findViewById(R.id.dtext);

        imageView.setImageResource(adapter.getImage(position));

        textView.setText(adapter.getText(position));

    }
}
