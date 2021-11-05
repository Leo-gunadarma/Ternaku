package id.leo.ternaku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class KelolaHewanActivity extends AppCompatActivity {
    FloatingActionButton addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_hewan);
        addButton = findViewById(R.id.addButtonHewan);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahData();
            }
        });
    }
    public void tambahData(){
        Intent intent= new Intent(KelolaHewanActivity.this , TambahHewanActivity.class);
        startActivity(intent);
    }
}