package com.naufal.coffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        //menghilangkan status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void openRegistation(View view){
        //pindah dari splash screen ke login
        Intent pindah = new Intent(Login.this, Registration.class);
        startActivity(pindah);
    }
    public void userlogin(View v){
        //1. ambil data yang di input user
        EditText txtusername = findViewById(R.id.txtusername);
        EditText txtpassword = findViewById(R.id.txtpassword);
        String un = txtusername.getText().toString().trim();
        String ps = txtpassword.getText().toString().trim();
        //2. cari data di db yang sama dengan yang di input

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference table = database.getReference("tb_user");
        Query CheckUserName = table.orderByChild("phone").equalTo(un);//menacri username di firebase
        CheckUserName.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String dbpass = snapshot.child(un).child("password").getValue().toString();
                    //jika password sama dengan yang ada di database
                    if (dbpass.equals(ps)){//jika password benar
                        Intent pindah = new Intent(Login.this, Dashboard.class);
                        String user = un;
                        pindah.putExtra("Value", user);
                        startActivity(pindah);
                    }else{//jika password salah
                        Toast.makeText(Login.this, "password salah", Toast.LENGTH_SHORT).show();
                    }
                }else{//jika usernama tidak di temukan
                    Toast.makeText(Login.this, "username belum terdaftar", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //3. periksa jika data valid maka ke dashboard, tidak valid kembali ke activity_login

    }
}