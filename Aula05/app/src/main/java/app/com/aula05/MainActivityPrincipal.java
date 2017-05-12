package app.com.aula05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_principal);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Ronaldinho"));
        items.add(new Item("Ronaldinho"));

        CustomAdapter itemsAdapter = new CustomAdapter(this, items);

        ListView listView = (ListView) findViewById(R.id.listViewItem);
        listView.setAdapter(itemsAdapter);
    }
}
