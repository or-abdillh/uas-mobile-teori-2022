package com.naufal.coffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public void cencel(View view) {
        //pindah dari splash screen ke login
        Intent pindah = new Intent(Registration.this, Login.class);
        startActivity(pindah);
    }
    public void mau(View view){
        //identifikasi komponen
        EditText txtUsername =findViewById(R.id.txtusername);
        EditText txtPassword =findViewById(R.id.txtpassword);
        EditText txtConfirmPassword =findViewById(R.id.txtpassword2);
        EditText txtEmail =findViewById(R.id.txtemail);
        EditText txtPhone =findViewById(R.id.txtphone);
        //simpan input dari edit text ke variable
        String un = txtUsername.getText().toString();
        String ps = txtPassword.getText().toString();
        String cp = txtConfirmPassword.getText().toString();
        String em = txtEmail.getText().toString();
        String ph = txtPhone.getText().toString();
        // Write a message to the database
        FirebaseDatabase dbku = FirebaseDatabase.getInstance();
        DatabaseReference table = dbku.getReference("tb_user");

        //intruksi write ke firebase
        if(cp.equals(ps)){
            //write data
            DataHandler query = new DataHandler(un,ps,em,ph);
            table.child(ph).setValue(query);
            Intent pindah = new Intent(Registration.this, Login.class);
            startActivity(pindah);
            Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
            //pindah dari splash screen ke login

        }else {
            Toast.makeText(this, "Data yang di masukkan salah", Toast.LENGTH_SHORT).show();
        }
    }
}