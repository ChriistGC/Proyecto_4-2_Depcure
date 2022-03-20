package com.example.depcure.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.depcure.R;

import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    Button btn_login;
    Button btn_regis;
    private static final String TAG = "EntryChoiceActivity";
    private static final int PERMISSION_REQUESTS = 1;
    private static final String[] REQUIRED_RUNTIME_PERMISSIONS = new String[]{"android.permission.CAMERA",
            "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = findViewById(R.id.btn_login);
        btn_regis = findViewById(R.id.btn_regis);
        btn_login.setOnClickListener(view -> {
            Intent ilog = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(ilog);
        });

        btn_regis.setOnClickListener(view -> {
            Intent iregi = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(iregi);
        });

        if (!this.allRuntimePermissionsGranted()) {
            this.getRuntimePermissions();
        }
    }

    private boolean allRuntimePermissionsGranted() {
        for(String permission: REQUIRED_RUNTIME_PERMISSIONS) {
            if (permission != null) {
                if (!this.isPermissionGranted((Context)this, permission)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void getRuntimePermissions() {
        ArrayList <String> permissionsToRequest = new ArrayList <String>();

        for(String permission: REQUIRED_RUNTIME_PERMISSIONS) {
            if (permission != null) {
                if (!this.isPermissionGranted((Context)this, permission)) {
                    permissionsToRequest.add(permission);
                }
            }
        }
        if (!permissionsToRequest.isEmpty()) {
            String[] permissions = permissionsToRequest.toArray(new String[0]);
            ActivityCompat.requestPermissions(this, permissions, 1);
        }

    }

    private boolean isPermissionGranted(Context context, String permission) {
        if (ContextCompat.checkSelfPermission(context, permission) == 0) {
            Log.i("EntryChoiceActivity", "Permission granted: " + permission);
            return true;
        } else {
            Log.i("EntryChoiceActivity", "Permission NOT granted: " + permission);
            return false;
        }

    }

}