package github.nisrulz.screenshott;

import android.graphics.Bitmap;
import android.os.Environment;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

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


    public Bitmap takeScreenShotOfRootView(View root_view) {
        View rootview = root_view.getRootView();
        rootview.setDrawingCacheEnabled(true);
        Bitmap bitmap = rootview.getDrawingCache();
        saveScreenshot(bitmap);
        return bitmap;
    }

    private void saveScreenshot(Bitmap bmp) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 40, bytes);
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment
                .DIRECTORY_PICTURES) + "/" +
                "capturedscreenandroid.jpg");
        try {
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(bytes.toByteArray());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
