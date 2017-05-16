package app.com.aula06;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import app.com.aula06.db.FireData;
import app.com.aula06.downloadImage.DownloadImage;
import app.com.aula06.downloadImage.DownloadListener;
import app.com.aula06.entity.user.User;

public class MainActivity extends AppCompatActivity {

    // DataBase
    FirebaseDatabase database;
    DatabaseReference reference;

    // View
    ImageView imageViewAvatar, imageViewPerfil;
    TextView textViewAvatar1, textViewAvatar2, textViewRodape1, textViewRodape2;

    // UserList
    ArrayList<User> list = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DataBase
        this.configureDataBase();

        // View
        this.inicializeObjectsView();

        // Popula a lista de User
        this.setUser();
    }

    private void configureDataBase(){
        // DataBase
        database = FireData.getDatabase();
        reference = database.getReference("/results");
    }

    private void inicializeObjectsView(){
        // View
        imageViewAvatar = (ImageView) findViewById(R.id.imageViewAvatar);
        imageViewPerfil = (ImageView) findViewById(R.id.imageViewPerfil);
        textViewAvatar1 = (TextView) findViewById(R.id.textViewAvatar1);
        textViewAvatar2 = (TextView) findViewById(R.id.textViewAvatar2);
        textViewRodape1 = (TextView) findViewById(R.id.textViewRodape1);
        textViewRodape2 = (TextView) findViewById(R.id.textViewRodape2);
    }

    private void setUser(){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    list.add(snapshot.getValue(User.class));
                }

                // Passa do user para a view
                setView();

                // Exemplos de uso do dataSnapshot
//                for(int i = 0; i < dataSnapshot.getChildrenCount(); i++){ }
//                textViewAvatar1.setText((String) dataSnapshot.child("0/").child("name/").child("first").getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // TODO
            }
        });
    }

    private void setView(){
        // Passa do user para a view
        textViewAvatar1.setText(list.get(0).getName().getFirst());
        textViewAvatar2.setText(list.get(0).getName().getLast());
        downloadImage(imageViewAvatar, null, list.get(0).getPicture().getThumbnail());
        downloadImage(imageViewPerfil, null, list.get(0).getPicture().getLarge());
        textViewRodape1.setText(list.get(0).getEmail());
        textViewRodape2.setText(list.get(0).getPhone());
    }

    private void downloadImage(final ImageView imageView, ProgressBar progressBar, String url){
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
                        url);

        downloadImage.execute();
    }
}
