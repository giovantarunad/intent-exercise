package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import model.user;

public class ProfileActivity extends AppCompatActivity {

    private static final String USER_KEY = "USER_KEY" ;
    private TextView fullnameText;
    private TextView emailText;
    private TextView passwordText;
    private TextView confirmpasswordText;
    private TextView homepageText;
    private TextView aboutText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fullnameText = findViewById(R.id.text_fullname);
        emailText = findViewById(R.id.text_email);
        passwordText = findViewById(R.id.text_password);
        confirmpasswordText = findViewById(R.id.text_confirm_password);
        homepageText = findViewById(R.id.text_homepage);
        aboutText = findViewById(R.id.text_about);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            user data = getIntent().getParcelableExtra(USER_KEY);

            fullnameText.setText(data.getFullname());
            emailText.setText(data.getEmail());
            passwordText.setText(data.getPassword());
            confirmpasswordText.setText(data.getConfirmpassword());
            homepageText.setText(data.getHomepage());
            aboutText.setText(data.getAbout());
        }
    }
}
