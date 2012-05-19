package com.vravindranath.youtubedownloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

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
	private static final String YOUTUBE_WATCH_URL_PREFIX = "http://www.youtube.com/watch?v=";
	
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
				saveVideoToDevice(videoUrl);
				if(isValidUrl(videoUrl)) {
					saveVideoToDevice(videoUrl);
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
	
	private String getHTMLString(String url) throws ClientProtocolException, IOException {
		url = "http://www.youtube.com/watch?v=1DVusKFmjj4&feature=g-vrec";
		String html = "";
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		HttpResponse response = httpClient.execute(request);
		InputStream stream = response.getEntity().getContent();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		StringBuilder str = new StringBuilder();
		String line = null;
		while((line = reader.readLine()) != null) {
		    str.append(line);
		}
		stream.close();
		html = str.toString();
		return html;
	}

	private void saveVideoToDevice(String url) {
		//TODO: Add saving logic here
		try {
			String html = getHTMLString(url);
			Log.i(tag, html);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String videoId = getVideoIdFromUrl(url);
		Log.i(tag, videoId);
	}
	
	private String getVideoIdFromUrl(String url) {
		url = "http://www.youtube.com/watch?v=1DVusKFmjj4&feature=g-vrec";
		String videoId = null;
		int indexOfAnd;
		videoId = url.substring(YOUTUBE_WATCH_URL_PREFIX.length());
		indexOfAnd = videoId.indexOf('&');
		videoId = videoId.substring(0, indexOfAnd);
		return videoId;
	}
}