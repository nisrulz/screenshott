/*
 * Copyright (C) 2016 Nishant Srivastava
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package github.nisrulz.screenshottproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import github.nisrulz.screenshott.ScreenShott;
import java.io.File;

public class MainActivity extends AppCompatActivity {

  private final static String[] requestWritePermission =
      { Manifest.permission.WRITE_EXTERNAL_STORAGE };
  private ImageView imageView;
  private Bitmap bitmap;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    final boolean hasWritePermission = RuntimePermissionUtil.checkPermissonGranted(this,
        Manifest.permission.WRITE_EXTERNAL_STORAGE);

    imageView = findViewById(R.id.imageView);
    TextView hidden_txtview =  findViewById(R.id.hidden_txtview);
    TextureView hidden_textureview =  findViewById(R.id.hidden_textureview);

    ImageButton capture_screenshot = findViewById(R.id.capture_screenshot);
    capture_screenshot.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        // Take screen shot
        //bitmap = ScreenShott.getInstance().takeScreenShotOfView(hidden_txtview);
        //bitmap = ScreenShott.getInstance().takeScreenShotOfJustView(hidden_txtview);
        //bitmap = ScreenShott.getInstance().takeScreenShotOfTextureView(hidden_textureview);
        bitmap = ScreenShott.getInstance().takeScreenShotOfRootView(view);
        // Display in imageview
        imageView.setImageBitmap(bitmap);
      }
    });

    ImageButton capture_refresh = findViewById(R.id.capture_refresh);
    capture_refresh.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Bitmap placeholder =
            BitmapFactory.decodeResource(MainActivity.this.getResources(), R.drawable.placeholder);
        // load the placeholder image into imageview
        imageView.setImageBitmap(placeholder);
      }
    });

    ImageButton capture_save =  findViewById(R.id.capture_save);
    capture_save.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (bitmap != null) {
          if (hasWritePermission) {
            saveScreenshot();
          }
          else {
            RuntimePermissionUtil.requestPermission(MainActivity.this, requestWritePermission, 100);
          }
        }
      }
    });
  }

  private void saveScreenshot() {
    // Save the screenshot

    try {
      File file = ScreenShott.getInstance()
          .saveScreenshotToPicturesFolder(MainActivity.this, bitmap, "my_screenshot");
      // Display a toast
      Toast.makeText(MainActivity.this, "Bitmap Saved at " + file.getAbsolutePath(),
          Toast.LENGTH_SHORT).show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull final String[] permissions,
      @NonNull final int[] grantResults) {
    switch (requestCode) {
      case 100: {

        RuntimePermissionUtil.onRequestPermissionsResult(grantResults, new RPResultListener() {
          @Override
          public void onPermissionGranted() {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
              saveScreenshot();
            }
          }

          @Override
          public void onPermissionDenied() {
            Toast.makeText(MainActivity.this, "Permission Denied! You cannot save image!",
                Toast.LENGTH_SHORT).show();
          }
        });
        break;
      }
    }
  }
}
