package co.com.a4apps.async;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by jm on 11-30-17.
 */

public class ImageAdapter extends BaseAdapter {

    int[] imagenes          = {R.drawable.orca,R.drawable.llama,R.drawable.dromedario,R.drawable.dolphin,R.drawable.whale,R.drawable.gorrion,R.drawable.cow,R.drawable.toro,R.drawable.lobo,R.drawable.fish};

    String[] texto          = {"Imagen de una Orca","Imagen de una Llama","Imagen de un Dromedario","Imagen de un Delfin","Imagen de una Ballena","Imagen de un Gorrión","Imagen de una Vaca","Imagen de un Toro","Imagen de un Lobo","Imagen de un Pez Payaso"};

    Context context;
    LayoutInflater inflater;

    public ImageAdapter (Context context){
        this.context    = context;

        this.inflater   = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return imagenes.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public int getImage(int position){
        return imagenes[position];
    }

    public String getText(int position){
        return texto[position];
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ImageView imageView;

        if (convertView == null) {

            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(250,250));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        }else{
            imageView = (ImageView) view;
        }

        imageView.setImageResource(imagenes[position]);

        return imageView;
    }

}
