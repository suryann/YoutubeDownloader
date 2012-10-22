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
	
	private EditText sourceUrlEditText = null;
	protected String TAG = "YoutubeDownloaderActivity";
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
				Log.i(TAG , videoUrl);
				//FIXME: This is just for testing.
				VideoDownloader downloader = new VideoDownloader();
				downloader.execute(videoUrl);
				if(isValidUrl(videoUrl)) {
//					VideoDownloader downloader = new VideoDownloader();
//					downloader.execute(videoUrl);
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
}