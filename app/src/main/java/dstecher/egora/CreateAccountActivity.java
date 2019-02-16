package dstecher.egora;

import android.app.ProgressDialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {

    private Button buttonRegister;

    // wird noch nicht verwendet ******************************
    private EditText editEmail;
    private EditText editPassword;
    private EditText editRepeatedPassword;
    private EditText editFirstName;
    private EditText editLastName;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        getSupportActionBar().hide(); // hide the app title bar

        // Declaration

        buttonRegister = findViewById(R.id.buttonRegister);
        editEmail = findViewById(R.id.regEmail);
        editPassword = findViewById(R.id.regPassword);
        editRepeatedPassword = findViewById(R.id.regPasswordRepeat);
        editFirstName = findViewById(R.id.regFirstName);
        editLastName = findViewById(R.id.regLastName);
        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();
        // Register new user in firebase
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("register", "register button clicked"); // nur zum Testen
                // hier User bei Firebase anlegen
                if(v == buttonRegister){
                    registerUser();
                }

            }

        });
    }

    public void registerUser(){
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String repeatedPassword = editRepeatedPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //keine mail angegeben
            Toast.makeText(this, "Bitte geben Sie eine gültige E-Mail ein", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            //kein password angegeben
            Toast.makeText(this, "Bitte geben Sie ein gültiges Passwort ein", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registriere Nutzer");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //Registrierung erfolgreich
                            progressDialog.hide();
                            Toast.makeText(CreateAccountActivity.this, "Registrierung erfolgreich", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = firebaseAuth.getCurrentUser();

                        }
                        else{
                            progressDialog.hide();
                            Toast.makeText(CreateAccountActivity.this, "Registrierung fehlgeschlagen", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
}