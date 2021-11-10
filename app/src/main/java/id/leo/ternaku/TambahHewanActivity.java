package id.leo.ternaku;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import id.leo.ternaku.database.DatabaseHewan;
import id.leo.ternaku.database.TabelHewan;

public class TambahHewanActivity extends AppCompatActivity {
    private DatabaseHewan database;
    private EditText namaHewan, jumlahHewan, rasHewan;
    private Spinner jenisHewan;
    private Button tombolSimpan;
    private RadioButton selected;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_hewan);
        database = DatabaseHewan.getDbInstance(this.getApplicationContext());
        namaHewan = findViewById(R.id.editTextNamaHewan);
        rasHewan = findViewById(R.id.editTextRasHewan);
        jenisHewan = findViewById(R.id.spinnerJenisHewan);
        jumlahHewan = findViewById(R.id.editTextJumlahHewan);
        radioGroup = findViewById(R.id.radioGroupJadwalMakan);
        tombolSimpan = findViewById(R.id.buttonSimpan);
        tombolSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpanData();
            }
        });
    }
    public void simpanData(){
        if (namaHewan.getText().toString().trim().length() == 0){
            //method trim digunakan untuk menghapus spasi
            Toast toast = Toast.makeText(this, "Nama Hewan Belum diisi", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        if (rasHewan.getText().toString().trim().length() == 0){
            Toast toast = Toast.makeText(this, "Ras Hewan Belum diisi", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        if (jenisHewan.getSelectedItemPosition() == 0){
            Toast toast = Toast.makeText(this, "Jenis Hewan Belum dirubah", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        if (jumlahHewan.getText().toString().trim().length() == 0){
            Toast toast = Toast.makeText(this, "Banyak Hewan Belum diisi", Toast.LENGTH_LONG);
            toast.show();
            return;
        }


        if (radioGroup.getCheckedRadioButtonId() == -1){
            Toast toast = Toast.makeText(this, "Jadwal makan belum dipilih", Toast.LENGTH_LONG);
            toast.show();
            return;
        }else{
            int select = radioGroup.getCheckedRadioButtonId();
            selected = findViewById(select);
        }
        AlertDialog.Builder infoMsg = new AlertDialog.Builder(TambahHewanActivity.this);
        infoMsg.setTitle("Apakah Anda Yakin?");
        infoMsg.setMessage("Apakah anda yakin ingin menginputkan data sebagai berikut?\n\n"+
                "Nama Hewan: "+ namaHewan.getText().toString()+ "\n"+
                "Ras Hewan: " + rasHewan.getText().toString() + "\n"+
                "Jenis Hewan: " + jenisHewan.getSelectedItem().toString() + "\n"+
                "Jumlah Hewan: " + jumlahHewan.getText().toString() + "\n" +
                "Jadwal Makan: "+ selected.getText().toString() + "\n");
        infoMsg.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String nmHwn = namaHewan.getText().toString();
                String rsHwn = rasHewan.getText().toString();
                String jnsHwn = jenisHewan.getSelectedItem().toString();
                String jmlhHwn = jumlahHewan.getText().toString();
                int finalJmlhHwn = Integer.parseInt(jmlhHwn);
                String jadwalMakan = selected.getText().toString();
                TabelHewan row = new TabelHewan(nmHwn,rsHwn,jnsHwn,finalJmlhHwn,jadwalMakan);
                database.daoHewan().insertDataHewan(row);
                Intent intent = new Intent(TambahHewanActivity.this, KelolaHewanActivity.class);
                intent.putExtra("nama_hewan", nmHwn);
                startActivity(intent);
                finish();
            }
        });
        infoMsg.setNegativeButton("Perbarui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                namaHewan.requestFocus();
                dialogInterface.dismiss();
            }
        });
        infoMsg.show();

    }
}