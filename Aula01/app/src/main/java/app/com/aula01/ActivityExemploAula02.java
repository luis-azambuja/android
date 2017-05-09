package app.com.aula01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class ActivityExemploAula02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_aula02);

        Button button = (Button) findViewById(R.id.confirmationButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAnother();
            }
        });
    }

    private void goToAnother(){
        Intent intent = new Intent(this, ActivityExemploAula022.class);

        String desc = getResources().getString(R.string.login_usuario);

        final EditText editText = (EditText) findViewById(R.id.editText);
        Usr user = new Usr(editText.getText().toString(), desc);

//        final EditText editText = (EditText) findViewById(R.id.editText);
//        intent.putExtra("mTag", editText.getText().toString());

        intent.putExtra("mTag", new Gson().toJson(user));
        startActivity(intent);
    }
}
