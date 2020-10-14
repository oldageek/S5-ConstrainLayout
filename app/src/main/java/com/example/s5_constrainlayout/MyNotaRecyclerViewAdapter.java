package com.example.s5_constrainlayout;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MyNotaRecyclerViewAdapter extends RecyclerView.Adapter<MyNotaRecyclerViewAdapter.ViewHolder> {
    private final List<Nota> mValues;

    public MyNotaRecyclerViewAdapter(List<Nota> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.TxtVTitulo.setText(holder.mItem.getTitulo());
        holder.TxtVContenido.setText(holder.mItem.getContenido());

//        Seleccionamos la imagen en negro en caso que sea favorita
        if (holder.mItem.isFavorita()) {
            holder.ImgVFavorita.setImageResource(R.drawable.ic_baseline_star_24);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView TxtVTitulo;
        public final TextView TxtVContenido;
        public final ImageView ImgVFavorita;
        public Nota mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            TxtVTitulo = view.findViewById(R.id.textViewTitulo);
            TxtVContenido = view.findViewById(R.id.textViewContenido);
            ImgVFavorita = view.findViewById(R.id.imageViewFavorita);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + TxtVTitulo.getText() + "'";
        }
    }
}