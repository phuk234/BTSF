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

public class MainActivity2 extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText inputemail;
    EditText inputpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mAuth = FirebaseAuth.getInstance();



        inputemail=findViewById(R.id.txtemail3);
        inputpassword=findViewById(R.id.txtpassword3);
        Button btnsignin=findViewById(R.id.btnregister2);


        btnsignin.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String email=inputemail.getText().toString().trim();
                String password=inputpassword.getText().toString().trim();
                if(TextUtils.isEmpty(email)) {

                    Toast.makeText(v.getContext(), "Enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){

                    Toast.makeText(v.getContext(),"Enter your password",Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(v.getContext(), "Sign in successfully!",
                                            Toast.LENGTH_SHORT).show();


                                }
                                else Toast.makeText(v.getContext(), "Email or password invalid!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                );


            }
        });
    }
}