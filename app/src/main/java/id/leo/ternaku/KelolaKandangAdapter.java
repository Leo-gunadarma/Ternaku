package id.leo.ternaku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.leo.ternaku.database.TabelKandang;

public class KelolaKandangAdapter  extends RecyclerView.Adapter<KelolaKandangAdapter.viewHolder>{
    private List<TabelKandang> dataKandang = new ArrayList<>();
    public KelolaKandangAdapter(List<TabelKandang> dataKandang) {
        this.dataKandang = dataKandang;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kandang_view,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.namaKandang.setText(dataKandang.get(position).getNamaKandang());
        holder.lokasiKandang.setText("Lokasi: "+ dataKandang.get(position).getLokasiKandang());
    }

    @Override
    public int getItemCount() {
        return dataKandang.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        private TextView namaKandang, lokasiKandang;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            namaKandang = itemView.findViewById(R.id.textViewNamaObatAdapter);
            lokasiKandang = itemView.findViewById(R.id.textViewJumlahObatAdapter);
        }
    }
}
