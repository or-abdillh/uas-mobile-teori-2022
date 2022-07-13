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
 * Use the {@link FragmentPesanan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPesanan extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentPesanan() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPesanan.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPesanan newInstance(String param1, String param2) {
        FragmentPesanan fragment = new FragmentPesanan();
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
        View view = inflater.inflate(R.layout.fragment_pesanan, container, false);

        //tampil data barang
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference table = database.getReference("tb_pesanan");
        List<String> list;
        list = new ArrayList<>();
        ListView listbrg2 = view.findViewById(R.id.listbrg2);

        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String kp,np,cp,hp,jp;
                for (DataSnapshot child : snapshot.getChildren()) {
                    kp = child.getKey();
                    np = child.child("namapesanan").getValue().toString();
                    cp = child.child("coffeepesanan").getValue().toString();
                    hp = child.child("hargapesanan").getValue().toString();
                    jp = child.child("jumlahpesanan").getValue().toString();
                    list.add(kp + "\nNama Pemesan: " + np + "\n Coffe Pesanan: " + cp + "\nHarga Coffee : " + hp + "\nJumlah Pesanan: " + jp);
                }

                ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list);
                listbrg2.setAdapter(arrayadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}