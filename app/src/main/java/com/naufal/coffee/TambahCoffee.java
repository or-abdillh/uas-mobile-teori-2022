package com.naufal.coffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahCoffee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_coffee);
    }
    public void addDataCoffee(View view){
        EditText txtKodecoffee =findViewById(R.id.kodecoffee);
        EditText txtNamacoffee =findViewById(R.id.namacoffee);
        EditText txtJeniscoffee =findViewById(R.id.jeniscoffee);
        EditText txtHargacoffee =findViewById(R.id.hargacoffee);
        EditText txtStockcoffee =findViewById(R.id.stockcoffee);

        String kc = txtKodecoffee.getText().toString();
        String nc = txtNamacoffee.getText().toString();
        String jc = txtJeniscoffee.getText().toString();
        String hc = txtHargacoffee.getText().toString();
        String sc = txtStockcoffee.getText().toString();

        FirebaseDatabase dbku = FirebaseDatabase.getInstance();
        DatabaseReference table = dbku.getReference("tb_menu");

        HandlerCoffee query = new HandlerCoffee(kc,nc,jc,hc,sc);
        table.child(kc).setValue(query);
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}