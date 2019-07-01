package com.noname.profilecard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileEdit extends AppCompatActivity {

    Profile userProfile;
    EditText etFirstName, etLastName, etUserName, etRandom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);
        userProfile = new Profile();

        init();

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveProfile();
                goToNextActivity();

                Toast.makeText(ProfileEdit.this, "Big Toast", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goToNextActivity() {
        Intent intent = new Intent(ProfileEdit.this, ProfileView.class);
        intent.putExtra(Constants.USER_PROFILE_KEY, userProfile);
        startActivity(intent);
    }

    private void saveProfile() {
        /*String fName = etFirstName.getText().toString();
        userProfile.setFirstName(fName);*/

        userProfile.setFirstName(etFirstName.getText().toString());
        userProfile.setLastName(etLastName.getText().toString());
        userProfile.setUserName(etUserName.getText().toString());
        userProfile.setRandom(etRandom.getText().toString());
    }

    private void init() {
        etFirstName = findViewById(R.id.et_first_name);
        etLastName = findViewById(R.id.et_last_name);
        etUserName = findViewById(R.id.et_user_name);
        etRandom = findViewById(R.id.et_random);
    }
}