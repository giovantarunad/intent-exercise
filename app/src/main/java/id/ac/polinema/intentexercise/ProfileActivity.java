package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import model.user;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = ProfileActivity.class.getName();
    public static final String USER_KEY = "USER_KEY";
    private TextView fullname;
    private TextView email;
    private TextView homepage;
    private TextView about;
    private user user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fullname = findViewById(R.id.label_fullname);
        email = findViewById(R.id.label_email);
        homepage = findViewById(R.id.label_homepage);
        about = findViewById(R.id.label_about);

        Intent extras = getIntent();
        user = extras.getParcelableExtra(USER_KEY);

        if (user.getImageUri() != null) {

            try {
                Uri imgProfile = user.getImageUri();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imgProfile);
                ImageView image = findViewById(R.id.image_profile);
                image.setImageBitmap(bitmap);
            } catch (IOException e) {
                Log.d(TAG, "onCreated: " + e.getMessage());
            }
        }

        about.setText(user.getAbout());
        fullname.setText(user.getFullname());
        email.setText(user.getEmail());
        homepage.setText(user.getHomepage());
    }
    public void handleViewHomePage(View view) {
        String homepage = user.getHomepage();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(homepage));

        startActivity(intent);
    }
}