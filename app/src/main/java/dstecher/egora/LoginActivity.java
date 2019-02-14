package dstecher.egora;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //startActivity(new Intent(MainActivity.this, LoginActivity.class));
        //getSupportActionBar().hide();

        buttonLogin = (Button) findViewById(R.id.buttonLogin123);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("login", "login button clicked");
            }
        });

    }
}
