package com.example.raunak.sharedprefereneces;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private TextView textView;
    private SharedPreferences preferences;
    private static final String Pref_Name = "myPref";   // name of database for storing data in memory.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences = getSharedPreferences(Pref_Name,0); // connect with prefname mode 0 = read&write
                SharedPreferences.Editor editor = preferences.edit();  //

                editor.putString("message",editText.getText().toString());
                editor.commit();
            }
        });

        SharedPreferences rec = getSharedPreferences(Pref_Name,0);
        if(rec.contains("message")){
            String msg = rec.getString("message","Not Found").toString();
            textView.setText(msg);
            textView.setVisibility(View.VISIBLE);
        }
    }
}
