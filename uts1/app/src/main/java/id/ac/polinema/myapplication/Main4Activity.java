package id.ac.polinema.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    RvKotaAdapter rvKotaAdapter;
    Button btnTambah;

    Cursor cursor;
    DataKota datkot;

    ArrayList<String> dataset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        rv = findViewById(R.id.rv);
        btnTambah = findViewById(R.id.btnTambah);
        datkot = new DataKota(this);

        lm = new LinearLayoutManager(this);

        rv.setLayoutManager(lm);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main4Activity.this,Main3Activity.class);
                startActivity(i);
            }
        });
        refreshList();
    }

    public void refreshList(){
        SQLiteDatabase db = datkot.getReadableDatabase();
        dataset = new ArrayList<String>();

        cursor = db.rawQuery("SELECT * FROM kota",null);
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            dataset.add(cursor.getString(0).toString());
        }

        rvKotaAdapter = new RvKotaAdapter(dataset);

        rv.setAdapter(rvKotaAdapter);
    }
}
