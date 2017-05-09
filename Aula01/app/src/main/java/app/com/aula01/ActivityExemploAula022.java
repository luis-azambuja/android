package app.com.aula01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class ActivityExemploAula022 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_aula02_2);

        TextView textView = (TextView) findViewById(R.id.textView6);

        String mString = getIntent().getStringExtra("mTag");
        Usr userGson = new Gson().fromJson(mString, Usr.class);

        textView.setText(userGson.getName());
    }
}
