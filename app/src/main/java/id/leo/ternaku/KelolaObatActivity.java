package id.leo.ternaku;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import id.leo.ternaku.database.DatabaseHewan;
import id.leo.ternaku.database.TabelObat;

public class KelolaObatActivity extends AppCompatActivity {
    private DatabaseHewan database;
    private RecyclerView recyclerView;
    private KelolaObatAdapter adapter;
    private FloatingActionButton addButton;
    List<TabelObat> dataListObat = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_obat);
        database = DatabaseHewan.getDbInstance(this);
        recyclerView = findViewById(R.id.recyclerViewKelolaObat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataListObat = database.daoHewan().getAllDataObat();
        adapter = new KelolaObatAdapter(dataListObat);
        recyclerView.setAdapter(adapter);
        addButton = findViewById(R.id.addButtonObat);

        if (getIntent().getExtras()!= null){
            Intent hasil = getIntent();
            AlertDialog.Builder succesMsg = new AlertDialog.Builder(KelolaObatActivity.this);
            succesMsg.setTitle("Inputan Berhasil");
            succesMsg.setMessage("Anda berhasil memasukan Obat \""+hasil.getStringExtra("nama_obat")+ "\" dalam menu kelola obat");
            succesMsg.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            succesMsg.show();
        }

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahData();
            }
        });
    }

    public void tambahData(){
        Intent intent= new Intent(KelolaObatActivity.this , TambahObatActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent= new Intent(KelolaObatActivity.this , MainActivity.class);
        startActivity(intent);
        finish();
    }
}