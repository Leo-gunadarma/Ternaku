package id.leo.ternaku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.leo.ternaku.database.TabelObat;

public class KelolaObatAdapter extends RecyclerView.Adapter<KelolaObatAdapter.viewHolder> {

    List<TabelObat> dataObat = new ArrayList<>();
    public KelolaObatAdapter(List<TabelObat> dataObat) {
        this.dataObat = dataObat;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_obat_view,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.namaObat.setText(dataObat.get(position).getNamaObat());
        holder.jumlahObat.setText("Jumlah Obat: "+dataObat.get(position).getJumlahObat());
    }

    @Override
    public int getItemCount() {
        return dataObat.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        private TextView namaObat,jumlahObat;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            namaObat = itemView.findViewById(R.id.textViewNamaObatAdapter);
            jumlahObat = itemView.findViewById(R.id.textViewJumlahObatAdapter);
        }
    }
}
