package app.com.aula04;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

public class MainActivityAula04 extends AppCompatActivity {

    TextView textView;
    int dibre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_aula04);

        textView = (TextView) findViewById(R.id.textView);
    }

    public void buttonClick(View view){
        switch(view.getId()){
            case R.id.button:
                materialDialog();
                break;
            case R.id.button2:
                listDialog();
                break;
            case R.id.button3:
                openOtherLayout();
                break;
        }
    }

    private void dialogDefault() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.title)
                .setMessage(R.string.description)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    private void materialDialog(){
        new MaterialDialog.Builder(this)
                .title(R.string.title)
                .content(R.string.description)
                .positiveText(R.string.yes)
                .negativeText(R.string.no)
                .onPositive(new MaterialDialog.SingleButtonCallback(){
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        finish();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback(){
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    private void listDialog(){
        new MaterialDialog.Builder(this)
                .title(R.string.title)
                .items(R.array.mArray)
                .itemsColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        String[] mArray = getResources().getStringArray(R.array.mArray);
                        textView.setText(mArray[which]);
                    }
                })
                .show();
    }

    private void openOtherLayout(){
        new MaterialDialog.Builder(this)
                .customView(R.layout.activitydialogbutton3, true)
                .positiveText(R.string.yes)
                .negativeText(R.string.yes)
                .onAny(new MaterialDialog.SingleButtonCallback(){
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        otherLayoutClickAnyButton();
                    }
                })
                .onNeutral(new MaterialDialog.SingleButtonCallback(){
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        openOtherLayout();
                    }
                })
                .show();
    }

    public void otherLayoutClickAnyButton(){
        dibre++;
        new MaterialDialog.Builder(this)
                .title(R.string.title)
                .content("Dibrado "+dibre+"x")
                .positiveText(R.string.yes)
                .negativeText(R.string.no)
                .onPositive(new MaterialDialog.SingleButtonCallback(){
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        otherLayoutClickAnyButton();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback(){
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                    }
                })
                .onNeutral(new MaterialDialog.SingleButtonCallback(){
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        otherLayoutClickAnyButton();
                    }
                })
                .show();
    }
}
