package com.naufal.coffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        BottomNavigationView botnav = findViewById(R.id.botnav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FragmentMenuCoffee()).commit();
        botnav.setSelectedItemId(R.id.FDmenu);
        botnav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.FDmenu:
                        fragment = new FragmentMenuCoffee();
                        break;
                    case R.id.FDpesanan:
                        fragment = new FragmentPesanan();
                        break;
                    case R.id.FDprofil:
                        fragment = new FragmentProfil();
                        break;


                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                return true;

            }
        });
    }
    public void addcoffee(View view){
        //pindah dari splash screen ke login
        Intent pindah = new Intent(this, TambahCoffee.class);
        startActivity(pindah);
    }
    public void addpesanan(View view){
        //pindah dari splash screen ke login
        Intent pindah1 = new Intent(this, TambahPesanan.class);
        startActivity(pindah1);
    }
}