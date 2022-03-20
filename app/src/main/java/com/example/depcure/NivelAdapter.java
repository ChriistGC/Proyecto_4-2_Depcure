package com.example.depcure;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NivelAdapter extends RecyclerView.Adapter<NivelAdapter.NivelVH>{

    List<com.example.depcure.Nivel> nivelList;

    public NivelAdapter(List<com.example.depcure.Nivel> nivelList) {
        this.nivelList = nivelList;
    }

    @NonNull
    @Override
    public NivelVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new NivelVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NivelVH holder, int position) {

        com.example.depcure.Nivel nivel = nivelList.get(position);
        holder.codeNameTxt.setText(nivel.getCodeName());
        holder.alimentacionTxt.setText(nivel.getAlimentacion());
        holder.medicamentTxt.setText(nivel.getMedicament());

        boolean isExpandable = nivelList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return nivelList.size();
    }

    public class NivelVH extends RecyclerView.ViewHolder{

        TextView codeNameTxt, alimentacionTxt, medicamentTxt;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;

        public NivelVH(@NonNull View itemView) {
            super(itemView);

            codeNameTxt = itemView.findViewById(R.id.code_name);
            alimentacionTxt = itemView.findViewById(R.id.alimentacion);
            medicamentTxt = itemView.findViewById(R.id.medicament);

            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);


            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    com.example.depcure.Nivel nivel = nivelList.get(getAbsoluteAdapterPosition());
                    nivel.setExpandable(!nivel.isExpandable());
                    notifyItemChanged(getAbsoluteAdapterPosition());
                }
            });

        }
    }
}
