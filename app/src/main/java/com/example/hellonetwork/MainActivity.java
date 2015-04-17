package com.example.hellonetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        new GcmController(this).registerID();

		// Necessário para permitir rodar operações de rede na thread principal.
		// NÃO USE!!!
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
	}

	public void downloadHttp(View view) {
		Log.e("HTTP", "downloadHttp");

		try {
			URL url = new URL("http://www.google.com");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			readStream(con.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void readStream(InputStream in) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in));
			String line = "";
			while ((line = reader.readLine()) != null) {
				Log.i("downloadHttp", line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void downloadImage(View view) {
		Log.e("HTTP", "downloadImage");

		Intent intent = new Intent(this, ImageActivity.class);
		startActivity(intent);
	}
}
