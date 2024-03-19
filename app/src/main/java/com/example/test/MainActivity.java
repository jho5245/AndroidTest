package com.example.test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		EdgeToEdge.enable(this);
		setContentView(R.layout.activity_main); // 앱을 실행했을 때 어떤게 보일지(초기화면)
		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
		{
			Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
			return insets;
		});
	}

	public void onClicked(View view)
	{
		Log.i(System.getProperty("os.name"), "test_message");
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-2911-5245"));
		startActivity(intent);
	}
}