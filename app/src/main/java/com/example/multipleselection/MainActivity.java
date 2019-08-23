package com.example.multipleselection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 31);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        Log.e("permissionIs", permissions[0]);
        Log.e("resultIs", grantResults[0] + "");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 47);
                //startActivityForResult();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e("resultCodeIs", resultCode + "");

        if (data != null)
            Log.e("dataIs", data.toString());

        Uri uri = data.getData();
        Log.e("uriIs",uri+"");

        String string = data.getType();
        Log.e("typeIs", string+"");

        string = data.getDataString();
        Log.e("dataStringIs", string+"");

        string = data.getScheme();
        Log.e("schemeIs", string+"");

        string = data.getType();
        Log.e("typeIs", string+"");

        string = data.resolveType(this);
        Log.e("resolvedIs", string+"");

        ClipData clipData = data.getClipData();
        Log.e("clipDataIs", clipData+"");
    }
}
