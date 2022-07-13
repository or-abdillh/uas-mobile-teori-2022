package com.naufal.coffee;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMenuCoffee#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMenuCoffee extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentMenuCoffee() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMenuCoffee.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMenuCoffee newInstance(String param1, String param2) {
        FragmentMenuCoffee fragment = new FragmentMenuCoffee();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_coffee, container, false);

        //tampil data barang
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference table = database.getReference("tb_menu");
        List<String> list;
        list = new ArrayList<>();
        ListView listbrg = view.findViewById(R.id.listbrg);

        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String kc,nc,jc,hc,sc;
                for (DataSnapshot child : snapshot.getChildren()) {
                    kc = child.getKey();
                    nc = child.child("namacoffee").getValue().toString();
                    jc = child.child("jeniscoffee").getValue().toString();
                    hc = child.child("hargacoffee").getValue().toString();
                    sc = child.child("stockcoffee").getValue().toString();
                    list.add(kc + "\nNama Coffee: " + nc + "\nJenis Coffee: " + jc + "\nHarga Coffee : " + hc + "\nStock Coffee: " + sc);
                }

                ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list);
                listbrg.setAdapter(arrayadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}