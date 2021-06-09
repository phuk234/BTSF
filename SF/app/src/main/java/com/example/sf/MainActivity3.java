package com.example.sf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity3 extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText inputemail;
    EditText inputpassword;
    EditText inputyourname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mAuth = FirebaseAuth.getInstance();



        inputemail=findViewById(R.id.txtemail3);
        inputpassword=findViewById(R.id.txtpassword3);
        inputyourname=findViewById(R.id.txtyourname);
        Button btnregister=findViewById(R.id.btnregister2);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=inputemail.getText().toString().trim();
                String password=inputpassword.getText().toString().trim();
                String yourname=inputyourname.getText().toString().trim();

                if(TextUtils.isEmpty(yourname)) {

                    Toast.makeText(v.getContext(), "Enter your name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(email)) {

                    Toast.makeText(v.getContext(), "Enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)) {

                    Toast.makeText(v.getContext(), "Enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(v.getContext(), "Register successfully!",
                                    Toast.LENGTH_SHORT).show();
                        }else Toast.makeText(v.getContext(), "Error!",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}