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

import android.graphics.Bitmap;
import android.os.Environment;
import android.view.View;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Nishant Srivastava
 */
public class ScreenShott {
  private static ScreenShott ourInstance = new ScreenShott();

  public static ScreenShott getInstance() {
    return ourInstance;
  }

  private ScreenShott() {
  }

  public Bitmap takeScreenShotOfRootView(View root_view, String filename) {
    View rootview = root_view.getRootView();
    rootview.setDrawingCacheEnabled(true);
    Bitmap bitmap = rootview.getDrawingCache();
    saveScreenshot(bitmap, filename);
    return bitmap;
  }

  private void saveScreenshot(Bitmap bmp, String filename) {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    bmp.compress(Bitmap.CompressFormat.JPEG, 40, bytes);
    FileOutputStream outputStream = null;
    File file = new File(
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
            + "/"
            + filename
            + ".jpg");
    try {
      file.createNewFile();
      outputStream = new FileOutputStream(file);
      outputStream.write(bytes.toByteArray());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (outputStream != null) {
          outputStream.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
