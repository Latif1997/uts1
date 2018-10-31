package id.ac.polinema.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    DataKota datKot;
    Cursor cursor;
    EditText editText;
    Button btninputnama,btncekkota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editText = findViewById(R.id.editText);
        btninputnama = findViewById(R.id.btninputnama);
        btncekkota = findViewById(R.id.btncekkota);
        datKot = new DataKota(this);

        btninputnama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = editText.getText().toString();
                SQLiteDatabase db = datKot.getWritableDatabase();
                db.execSQL("insert into kota (nama) values ('"+nama+"')");
                Toast.makeText(Main3Activity.this,"Input Berhasil dengan nama = "+nama,Toast.LENGTH_LONG).show();
            }
        });
        btncekkota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(i);
            }
        });
    }
}
