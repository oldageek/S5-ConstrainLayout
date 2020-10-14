package com.example.s5_constrainlayout;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class NotaFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private NotasInteractionListener mListener;
    private List<Nota> notaList;
    private MyNotaRecyclerViewAdapter adapterNotas;


    public NotaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotaFragment newInstance(int columnCount) {
        NotaFragment fragment = new NotaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (view.getId() == R.id.listPortrait) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
                int numeroColumnas = (int) (dpWidth / 180);
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(numeroColumnas, StaggeredGridLayoutManager.VERTICAL));
            }
            notaList = new ArrayList<>();
            notaList.add(new Nota("Lista del super", "Pan tostado", true, android.R.color.holo_blue_light));
            notaList.add(new Nota("Detalles", "Ya voy shingadamadre", true, android.R.color.holo_orange_dark));
            notaList.add(new Nota("Cumpleanos (Ale)", "Para toda esta putasituasion tenemos que mandar todo a la verga y listo chingadamadre, adios.", false, android.R.color.holo_red_dark));
            notaList.add(new Nota("Nota promosional", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In at orci commodo, mattis erat ac, porttitor nunc. Nullam molestie lacinia ligula efficitur placerat. Sed sollicitudin odio justo, eget convallis ipsum suscipit ac", false, android.R.color.holo_purple));
            notaList.add(new Nota("Informacion", "Esta informacion es solo de ayuda para mandara a shingar a su madre", true, android.R.color.holo_green_light));
            notaList.add(new Nota("Con amor", "Esta notita es para llenar espacios jajaja", true, android.R.color.holo_green_dark));
            notaList.add(new Nota("Detalles", "Ya voy shingadamadre", false, android.R.color.holo_orange_light));

            adapterNotas = new MyNotaRecyclerViewAdapter(notaList);
            recyclerView.setAdapter(adapterNotas);
        }
        return view;
    }
}