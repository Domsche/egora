package dstecher.egora;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin;
    private TextView linkRegisterNow;

    // wird noch nicht verwendet ******************************
    private EditText username;
    private EditText email;
    private TextView linkForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide(); // hide the app title bar

        buttonLogin = findViewById(R.id.buttonLogin);
        linkRegisterNow = findViewById(R.id.textRegister);
        username = findViewById(R.id.logUsername);
        email = findViewById(R.id.logEmail);
        linkForgotPassword = findViewById(R.id.textForgotPassword);

        // Login with firebase auth
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // hier Login mit Firebase Auth ausführen
                Log.i("login", "login button clicked"); // nur zum Testen
            }
        });

        // Switch activity to register
        linkRegisterNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("register", "switch to registerview"); // nur zum Testen
                Intent intent = new Intent(getBaseContext(), CreateAccountActivity.class);
                startActivity(intent);
            }
        });

    }
}
