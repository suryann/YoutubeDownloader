package com.vravindranath.youtubedownloader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class YoutubeDownloaderActivity extends Activity {
    /** Called when the activity is first created. */
	private static final String tag = "YoutubeDownloaderActivity";
	private EditText sourceUrlEditText = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        sourceUrlEditText = (EditText) findViewById(R.id.sourceUrl_edittext);
        
        Button saveButton = (Button) findViewById(R.id.save_video);
        saveButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String videoUrl = (sourceUrlEditText.getText()).toString();
				Log.i(tag, videoUrl);
				if(isValidUrl(videoUrl)) {
					saveVideoToDevice(videoUrl);
				} else {
					//Display Error dialog
				}
				
			}
		});
    }
    
	protected boolean isValidUrl(String url) {
		// TODO: Check if url is valid
		return false;
	}

	private void saveVideoToDevice(String url) {
		//TODO: Add saving logic here
	}
}