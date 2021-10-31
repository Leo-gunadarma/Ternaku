package id.leo.ternaku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView kelolaHewan,kelolaKandang,kelolaObat,pengaturanProfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kelolaHewan = findViewById(R.id.imageViewKelolaHewan);
        kelolaKandang = findViewById(R.id.imageViewKelolaKandang);
        kelolaObat = findViewById(R.id.imageViewMenuKelolaObat);
        pengaturanProfil = findViewById(R.id.imageViewMenuPengaturanProfil);
        kelolaHewan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuKelolaHewan();
            }
        });
        kelolaKandang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuKelolaHewan();
            }
        });
        kelolaObat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuKelolaHewan();
            }
        });
        pengaturanProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuKelolaHewan();
            }
        });
    }
    public void menuKelolaHewan(){
        Intent intent = new Intent(MainActivity.this, KelolaHewanActivity.class);
        startActivity(intent);
    }
    public void menuKelolaKandang(){
        Toast toast = Toast.makeText(this, "Menu dalam pembuatan", Toast.LENGTH_LONG);
        toast.show();
    }
    public void menuKelolaObat(){
        Toast toast = Toast.makeText(this, "Menu dalam pembuatan", Toast.LENGTH_LONG);
        toast.show();
    }
    public void menuPengaturanProfil(){
        Toast toast = Toast.makeText(this, "Menu dalam pembuatan", Toast.LENGTH_LONG);
        toast.show();
    }
}