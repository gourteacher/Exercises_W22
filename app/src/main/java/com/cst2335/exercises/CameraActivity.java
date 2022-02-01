package com.cst2335.exercises;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CameraActivity extends AppCompatActivity {

    public final static String TAG = "CameraActivity";
    ImageButton profileButton;


    ActivityResultLauncher<Intent> cameraResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult()
            ,new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    Log.i(TAG, "onActivityResult");

                    if (result.getResultCode() == Activity.RESULT_OK) {

                        Intent data = result.getData();


                        File whereAmI = getFilesDir();//where your app is installed

                        Bitmap thumbnail = data.getParcelableExtra("data");


                        try {
                            FileOutputStream file = openFileOutput("ProfilePict.png", Context.MODE_PRIVATE);

                            thumbnail.compress(Bitmap.CompressFormat.PNG, 100, file);
                            file.flush();
                            file.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        catch(IOException ioe){
                            Log.w(TAG, "Can't output PNG");
                        }


                        Log.i(TAG, "image");
                    }
                    else if(result.getResultCode() == Activity.RESULT_CANCELED)
                        Log.i(TAG, "User refused the image");
                }
            } );




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Log.i(TAG, "onCreate");

        try {
            Intent next = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            cameraResult.launch( next ); //start the transition
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Code to check for runtime permissions.
     */
    private void checkPermissions() {
        if(Build.VERSION.SDK_INT < 23)
            return;
        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 0);
        }
    }
}