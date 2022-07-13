package com.naufal.coffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahPesanan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pesanan);
    }
    public void addDataPesanan(View view){
        EditText txtKodepesanan =findViewById(R.id.kodepesanan);
        EditText txtNamapesanan =findViewById(R.id.namaapesan);
        EditText txtCoffeepesanan =findViewById(R.id.coffeepesanan);
        EditText txtHargapesanan =findViewById(R.id.hargapesanan);
        EditText txtJumlahPesanan =findViewById(R.id.jumlahpesanan);

        String kp = txtKodepesanan.getText().toString();
        String np = txtNamapesanan.getText().toString();
        String cp = txtCoffeepesanan.getText().toString();
        String hp = txtHargapesanan.getText().toString();
        String jp = txtJumlahPesanan.getText().toString();

        FirebaseDatabase dbku = FirebaseDatabase.getInstance();
        DatabaseReference table = dbku.getReference("tb_pesanan");

        HandlerPesanan query = new HandlerPesanan(kp,np,cp,hp,jp);
        table.child(kp).setValue(query);
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}