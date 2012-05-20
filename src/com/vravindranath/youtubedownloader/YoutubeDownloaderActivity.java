package com.vravindranath.youtubedownloader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class YoutubeDownloaderActivity extends Activity {
    /** Called when the activity is first created. */	
	
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
//				Log.i(tag, videoUrl);
				//For testing
				VideoDownloader downloader = new VideoDownloader(videoUrl);
				if(isValidUrl(videoUrl)) {
//					VideoDownloader downloader = new VideoDownloader(videoUrl);
				} else {
					//Display Error dialog
				}
				
			}
		});
    }
    
    /* 
     * Sample YoutTube Url: http://www.youtube.com/watch?v=1DVusKFmjj4&feature=g-vrec
     */
    
	protected boolean isValidUrl(String url) {
		// TODO: Check if url is valid
		return false;
	}
}