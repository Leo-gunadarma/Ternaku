package id.leo.ternaku;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import id.leo.ternaku.database.DatabaseHewan;
import id.leo.ternaku.database.TabelKandang;

public class TambahKandangActivity extends AppCompatActivity {
    private DatabaseHewan database;
    private TextView textViewLuasKandang;
    private EditText namaKandang, lokasiKandang, kapasitasKandang;
    private SeekBar luasKandang;
    private Button tombolSimpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kandang);

        database = DatabaseHewan.getDbInstance(this.getApplicationContext());

        namaKandang = findViewById(R.id.editTextNamaKandang);
        lokasiKandang = findViewById(R.id.editTextLokasiKandang);
        luasKandang = findViewById(R.id.seekBarLuasKandang);
        kapasitasKandang = findViewById(R.id.editTextKapasitasKandang);
        textViewLuasKandang = findViewById(R.id.textViewLuasKandang);
        tombolSimpan = findViewById(R.id.buttonSimpan);

        luasKandang.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textViewLuasKandang.setText("Luas Kandang: "+ progress + " Meter Persegi");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        tombolSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpanData();
            }
        });

    }
    public void  simpanData(){
        if (namaKandang.getText().toString().trim().length() == 0){
            Toast toast = Toast.makeText(this, "Nama Kandang Belum diisi", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        if (lokasiKandang.getText().toString().trim().length() == 0){
            Toast toast = Toast.makeText(this, "Lokasi Kandang Belum diisi", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        if (kapasitasKandang.getText().toString().trim().length() == 0){
            Toast toast = Toast.makeText(this, "Kapasitas Kandang Belum diisi", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        int luasKandangValue = luasKandang.getProgress();
        if (luasKandangValue == 0){
            Toast toast = Toast.makeText(this, "Luas Kandang Tidak Dapat bernilai 0", Toast.LENGTH_LONG);
            toast.show();
            return;
        }


        AlertDialog.Builder infoMsg = new AlertDialog.Builder(TambahKandangActivity.this);
        infoMsg.setTitle("Apakah Anda Yakin?");
        infoMsg.setMessage("Apakah anda yakin ingin menginputkan data sebagai berikut?\n\n"+"" +
                "Nama Kandang: " + namaKandang.getText().toString() +"\n"+
                "Lokasi Kandang: " + lokasiKandang.getText().toString() +"\n"+
                "Luas Kandang: " + luasKandangValue + " Meter Persegi \n"+
                "Kapasitas Kandang: "+ kapasitasKandang.getText().toString()+ "\n");
        infoMsg.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String nmKndang = namaKandang.getText().toString();
                String lksKndang = lokasiKandang.getText().toString();
                String kpsKndang = kapasitasKandang.getText().toString();
                int finalkpsKndang = Integer.parseInt(kpsKndang);
                TabelKandang row = new TabelKandang(nmKndang,lksKndang,luasKandangValue,finalkpsKndang);
                database.daoHewan().insertDataKandang(row);
                Intent intent = new Intent(TambahKandangActivity.this, KelolaKandangActivity.class);
                intent.putExtra("nama_kandang", nmKndang);
                startActivity(intent);
                finish();
            }
        });
        infoMsg.setNegativeButton("Perbarui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                namaKandang.requestFocus();
                dialogInterface.dismiss();
            }
        });
        infoMsg.show();
    }
}