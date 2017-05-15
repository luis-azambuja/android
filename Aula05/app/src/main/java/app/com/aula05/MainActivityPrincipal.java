package app.com.aula05;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPrincipal extends AppCompatActivity {

    ImageView imageView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_principal);



        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Ronaldinho"));
        //items.add(new Item("Ronaldinho"));

        CustomAdapter itemsAdapter = new CustomAdapter(this, items);

        ListView listView = (ListView) findViewById(R.id.listViewItem);
        listView.setAdapter(itemsAdapter);

        imageView = (ImageView) findViewById(R.id.imageView2);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        DownloadImage downloadImage =
                new DownloadImage(
                        this,
                        new DownloadListener(){
                            @Override
                            public void getImg(Bitmap bitmap) {
                                imageView.setImageBitmap(bitmap);
                            }
                        },
                        progressBar,
                        "http://www.cvc.com.br/media/5757631/gramado-mini-mundo-divulgacao-cvc.jpg");

        downloadImage.execute();

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
