package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fun_web(View view){
        EditText web_msg = (EditText) findViewById(R.id.web_text);
        String message_web = web_msg.getText().toString();
        Uri webpage = Uri.parse(message_web);
        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
        startActivity(intent);

    }

    public void fun_map(View view){
        EditText web_msg = (EditText) findViewById(R.id.web_text);
        String message_web = web_msg.getText().toString();
        Uri webpage = Uri.parse("geo:0,0?q="+message_web);
        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
        startActivity(intent);

    }

    public void fun_text(View view){
        EditText web_msg = (EditText) findViewById(R.id.web_text);
        String message_web = web_msg.getText().toString();
        ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setChooserTitle("Message")
                .setText(message_web)
                .startChooser();

    }


}
