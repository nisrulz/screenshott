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

package github.nisrulz.screenshott;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.ContentValues.TAG;
import static android.view.View.MeasureSpec;

/**
 * The type ScreenShott class.
 */
public class ScreenShott {
  private static final ScreenShott ourInstance = new ScreenShott();

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static ScreenShott getInstance() {
    return ourInstance;
  }

  private ScreenShott() {
  }

  /**
   * Take screen shot of the View with spaces as per constraints
   *
   * @param v
   *     the v
   * @return the bitmap
   */
  public Bitmap takeScreenShotOfView(View v) {
    v.setDrawingCacheEnabled(true);
    v.buildDrawingCache(true);
    
    // creates immutable clone
    Bitmap b = Bitmap.createBitmap(v.getDrawingCache());
    v.setDrawingCacheEnabled(false); // clear drawing cache
    return b;
  }

  /**
   * Take screen shot of root view.
   *
   * @param v
   *     the v
   * @return the bitmap
   */
  public Bitmap takeScreenShotOfRootView(View v) {
    v = v.getRootView();
    return takeScreenShotOfView(v);
  }

  /**
   * Take screen shot of just the View without any constraints
   *
   * @param v
   *     the v
   * @return the bitmap
   */
  public Bitmap takeScreenShotOfJustView(View v) {
    v.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
        MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
    v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
    return takeScreenShotOfView(v);
  }

  /**
   * Save screenshot to pictures folder.
   *
   * @param context
   *     the context
   * @param image
   *     the image
   * @param filename
   *     the filename
   */
  public void saveScreenshotToPicturesFolder(Context context, Bitmap image, String filename) {
    File bitmapFile = getOutputMediaFile(filename);
    if (bitmapFile == null) {
      Log.d(TAG, "Error creating media file, check storage permissions: ");// e.getMessage());
      return;
    }
    try {
      FileOutputStream fos = new FileOutputStream(bitmapFile);
      image.compress(Bitmap.CompressFormat.PNG, 90, fos);
      fos.close();

      // Initiate media scanning to make the image available in gallery apps
      MediaScannerConnection.scanFile(context, new String[] { bitmapFile.getPath() },
          new String[] { "image/jpeg" }, null);
    } catch (FileNotFoundException e) {
      Log.d(TAG, "File not found: " + e.getMessage());
    } catch (IOException e) {
      Log.d(TAG, "Error accessing file: " + e.getMessage());
    }
  }

  private File getOutputMediaFile(String filename) {
    // To be safe, you should check that the SDCard is mounted
    // using Environment.getExternalStorageState() before doing this.
    File mediaStorageDirectory = new File(
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
            + File.separator);
    // Create the storage directory if it does not exist
    if (!mediaStorageDirectory.exists()) {
      if (!mediaStorageDirectory.mkdirs()) {
        return null;
      }
    }
    // Create a media file name
    String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());
    File mediaFile;
    String mImageName = filename + timeStamp + ".jpg";
    mediaFile = new File(mediaStorageDirectory.getPath() + File.separator + mImageName);
    return mediaFile;
  }
}
