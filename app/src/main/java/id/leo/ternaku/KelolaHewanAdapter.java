package id.leo.ternaku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.leo.ternaku.database.TabelHewan;

public class KelolaHewanAdapter extends RecyclerView.Adapter<KelolaHewanAdapter.viewHolder>{
    private List<TabelHewan> dataHewan= new ArrayList<>();

    public KelolaHewanAdapter(List<TabelHewan> dataHewan) {
        this.dataHewan = dataHewan;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hewan_view,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.namaHewan.setText(dataHewan.get(position).getNamaHewan());
        holder.jumlahHewan.setText("Jumlah Hewan: "+dataHewan.get(position).getJumlahHewan());
    }

    @Override
    public int getItemCount() {
        return dataHewan.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView namaHewan,jumlahHewan;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            namaHewan = itemView.findViewById(R.id.textViewNamaHewan);
            jumlahHewan = itemView.findViewById(R.id.textViewJumlahHewan);
        }
    }
}
