package id.ac.polinema.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUser, etPass;
    Button btnLogin;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);

        sessionManagement = new SessionManagement(this);

        if (sessionManagement.isLoggedIn()) {
            goToActivity();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user, pass;
                user = etUser.getText().toString();
                pass = etPass.getText().toString();
                if (user.matches("") || user.trim().isEmpty() || pass.matches("") || pass.trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Username dan Password tidak boleh kosong atau berisi spasi !", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    sessionManagement.createLoginSession(user, pass);
                    goToActivity();
                }
            }
        });

    }

    private void goToActivity() {
        Intent mIntent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(mIntent);
    }
}
