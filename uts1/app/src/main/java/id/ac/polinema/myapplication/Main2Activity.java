package id.ac.polinema.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {
    SessionManagement sm;
    TextView tvUser;
    Button btnLogout, btnkota;
    HashMap<String, String> loginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvUser = findViewById(R.id.tvUser);
        btnLogout = findViewById(R.id.btnLogout);
        btnkota = findViewById(R.id.btnkota);

        sm = new SessionManagement(this);
        loginUser = sm.getUserInformation();

        Toast.makeText(this, sm.isLoggedIn()+"", Toast.LENGTH_LONG).show();

        tvUser.setText(loginUser.get(sm.KEY_USER));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sm.logoutUser();
            }
        });

        btnkota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(i);
            }
        });
    }
}