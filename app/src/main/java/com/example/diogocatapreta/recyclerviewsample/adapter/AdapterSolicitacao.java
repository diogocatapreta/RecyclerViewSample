package com.example.diogocatapreta.recyclerviewsample.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.diogocatapreta.recyclerviewsample.R;
import com.example.diogocatapreta.recyclerviewsample.model.Solicitacao;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapterSolicitacao extends RecyclerView.Adapter<AdapterSolicitacao.MyViewHolder> {

    private List<Solicitacao> listaSolicitacao;

    public AdapterSolicitacao( List<Solicitacao> lista) {
        this.listaSolicitacao = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //precisamos converter o layout adapter xml em uma view.
        View itemSolicitacao = LayoutInflater.from( viewGroup.getContext() )
                .inflate(R.layout.adapter_solicitacao, viewGroup, false);

        return new MyViewHolder(itemSolicitacao);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Solicitacao sol = listaSolicitacao.get(i);

        myViewHolder.dataSolicitacao.setText(sol.getDataCriacao());
        myViewHolder.documentoFornecedor.setText(sol.getDocFornecedor());
        myViewHolder.nomeFornecedor.setText(sol.getNomeFornecedor());
        myViewHolder.valorSolicitacao.setText("R$ "+sol.getValor());
        myViewHolder.numeroSolicitacao.setText("PDL"+sol.getNumero());
    }

    @Override
    public int getItemCount() {
        return listaSolicitacao.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView numeroSolicitacao;
        TextView nomeFornecedor;
        TextView dataSolicitacao;
        TextView valorSolicitacao;
        TextView documentoFornecedor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            numeroSolicitacao = itemView.findViewById(R.id.textViewSolicitacao);
            nomeFornecedor = itemView.findViewById(R.id.textViewNome);
            dataSolicitacao = itemView.findViewById(R.id.textViewData);
            valorSolicitacao = itemView.findViewById(R.id.textViewValor);
            documentoFornecedor = itemView.findViewById(R.id.textViewDoc);
        }
    }

}
