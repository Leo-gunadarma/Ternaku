package id.leo.ternaku;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import id.leo.ternaku.database.DatabaseHewan;
import id.leo.ternaku.database.TabelObat;

public class TambahObatActivity extends AppCompatActivity {
    private DatabaseHewan database;
    private EditText namaObat, jumlahObat, deskripsiObat;
    private Button tombolSimpan;
    private CheckBox peraturan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_obat);

        database = DatabaseHewan.getDbInstance(this.getApplicationContext());

        namaObat = findViewById(R.id.editTextNamaObat);
        jumlahObat = findViewById(R.id.editTextJumlahObat);
        deskripsiObat = findViewById(R.id.editTextDeskripsiObat);
        tombolSimpan = findViewById(R.id.buttonSimpan);
        peraturan = findViewById(R.id.checkBoxPeraturan);
        tombolSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpanData();
            }
        });
    }
    public void simpanData(){

        if (namaObat.getText().toString().trim().length() == 0){
            Toast toast = Toast.makeText(this, "Nama Obat Belum Diisi", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        if (jumlahObat.getText().toString().trim().length() == 0){
            Toast toast = Toast.makeText(this, "Jumlah Obat Belum diisi", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        if (deskripsiObat.getText().toString().trim().length() == 0){
            Toast toast = Toast.makeText(this, "Deskripsi Obat Belum Diisi", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        if (peraturan.isChecked() == false){
            Toast toast = Toast.makeText(this, "Peraturan Belum Dicentang", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        AlertDialog.Builder infoMsg = new AlertDialog.Builder(TambahObatActivity.this);
        infoMsg.setTitle("Apakah Anda Yakin?");
        infoMsg.setMessage("Apakah anda yakin ingin menginputkan data sebagai berikut?\n\n"+"" +
                "Nama Obat: " + namaObat.getText().toString() +"\n"+
                "Jumlah Obat: "+ jumlahObat.getText().toString() + "\n"+
                "Deskripsi Obat: "+ deskripsiObat.getText().toString() + "\n");
        infoMsg.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String nmaObat = namaObat.getText().toString();
                String jmlhObat = jumlahObat.getText().toString();
                String dskObat = deskripsiObat.getText().toString();
                int finalJmlhObat = Integer.parseInt(jmlhObat);
                String prtrnObat = "True";
                TabelObat row = new TabelObat(nmaObat,finalJmlhObat,dskObat,prtrnObat);
                database.daoHewan().insertDataObat(row);
                Intent intent = new Intent(TambahObatActivity.this, KelolaObatActivity.class);
                intent.putExtra("nama_obat", nmaObat);
                startActivity(intent);
                finish();
            }
        });
        infoMsg.setNegativeButton("Perbarui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                namaObat.requestFocus();
                dialogInterface.dismiss();
            }
        });
        infoMsg.show();
    }
}