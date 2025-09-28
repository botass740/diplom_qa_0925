/**
 * TestRule для автоматического создания скриншотов при падении тестов
 * Автор: Максим Романов
 * Группа: QAMID-87
 */
package ru.iteco.fmhandroid.ui.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.view.View;
import android.webkit.WebView;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;




public class ScreenshotTestRule implements TestRule {

    private final ActivityTestRule<?> activityTestRule;

    public ScreenshotTestRule(ActivityTestRule<?> activityTestRule) {
        this.activityTestRule = activityTestRule;
    }

    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    base.evaluate();
                } catch (Throwable throwable) {
                    takeScreenshot(description.getMethodName());
                    throw throwable;
                }
            }
        };
    }

    private void takeScreenshot(String testName) {
        try {
            Activity activity = activityTestRule.getActivity();
            if (activity != null) {
                View rootView = activity.getWindow().getDecorView().getRootView();
                Bitmap bitmap = getBitmapFromView(rootView);
                
                File screenshotFile = new File(
                    InstrumentationRegistry.getInstrumentation().getTargetContext().getExternalFilesDir(null),
                    "screenshot_" + testName + "_" + System.currentTimeMillis() + ".png"
                );
                
                FileOutputStream fos = new FileOutputStream(screenshotFile);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                fos.close();
                
                System.out.println("Screenshot saved: " + screenshotFile.getAbsolutePath());
            }
        } catch (Exception e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
        }
    }

    private Bitmap getBitmapFromView(View view) {
        if (view instanceof WebView) {
            return getBitmapFromWebView((WebView) view);
        } else {
            return getBitmapFromViewInternal(view);
        }
    }

    private Bitmap getBitmapFromViewInternal(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmap;
    }

    private Bitmap getBitmapFromWebView(WebView webView) {
        Picture picture = webView.capturePicture();
        Bitmap bitmap = Bitmap.createBitmap(picture.getWidth(), picture.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        picture.draw(canvas);
        return bitmap;
    }
} 