package com.example.hellonetwork;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ImageActivity extends Activity {

	private static final String FIG_URL = "http://cdn.crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_image);
	}

	public void downloadImage(View view) {
		Log.e("Image", "downloadImage");

		try {
			URL url = new URL(FIG_URL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			setImage(con.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setImage(InputStream is) {
		Bitmap bitmap = BitmapFactory.decodeStream(is);
		ImageView imageView = (ImageView) findViewById(R.id.imageView);
		imageView.setImageBitmap(bitmap);
	}
}
