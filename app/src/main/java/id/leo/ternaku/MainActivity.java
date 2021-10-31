package id.leo.ternaku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView kelolaHewan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kelolaHewan = findViewById(R.id.imageViewKelolaHewan);
        kelolaHewan.setOnClickListener(new View.OnClickListener() {
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
}