package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        ToggleButton toggle = findViewById(R.id.toggleButton);
        if(toggle.isChecked()) sendReverseMessage();
        else sendNormalMessage();
    }

    public void sendNormalMessage(){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void sendReverseMessage(){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        char[] tempForwardsMessage = message.toCharArray();
        char[] tempBackwardsMessage = new char[message.length()];
        for(int i = 0 ; i < tempForwardsMessage.length ; i++){
            tempBackwardsMessage[i] = tempForwardsMessage[message.length() - i - 1];
        }
        String reversedMessage = new String(tempBackwardsMessage);

        intent.putExtra(EXTRA_MESSAGE, reversedMessage);
        startActivity(intent);
    }
}
