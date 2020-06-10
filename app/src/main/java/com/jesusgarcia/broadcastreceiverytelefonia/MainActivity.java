package com.jesusgarcia.broadcastreceiverytelefonia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText txtTelefono, txtMsg;
static Intent i = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTelefono = findViewById(R.id.txtTel);
        txtMsg = findViewById(R.id.txtMSG);
    }

    public void btnGuardar(View view) {
        i.putExtra("tel",txtTelefono.getText().toString());
        i.putExtra("msg",txtMsg.getText().toString());
        Toast.makeText(this, "Boton presionado", Toast.LENGTH_SHORT).show();
    }
}
