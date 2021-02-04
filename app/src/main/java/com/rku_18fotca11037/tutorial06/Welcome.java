package com.rku_18fotca11037.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    TextView txtwel;
    Button btnLogout;
    SharedPreferences Preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setContentView(R.layout.activity_welcome);

        txtwel = findViewById(R.id.txtwel);
        btnLogout = findViewById(R.id.btnLogout);
        Preferences = getSharedPreferences("university",MODE_PRIVATE);
        String userPreference = Preferences.getString("username","");
        if(userPreference.equals(""))
        {
            Intent intent = new Intent(Welcome.this,Login.class);
            startActivity(intent);
            finish();
        }
    }

    public void logout(View view) {
        SharedPreferences.Editor editor =  Preferences.edit();
        editor.remove("username");
        editor.commit();

        Intent intent = new Intent(Welcome.this,Login.class);
    startActivity(intent);
    finish();

    }
}