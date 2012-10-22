package com.vravindranath.youtubedownloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;

public class VideoDownloader extends AsyncTask<String, Void, Void>{
	private static final String YOUTUBE_WATCH_URL_PREFIX = "http://www.youtube.com/watch?v=";
	private String TAG = "VideoDownloader";
	
	private String getDownloadUrlFromHtmlContent(String htmlContent) {
		String downloadUrl = null;
//		String[] videoIdMatches = htmlContent.split(/\"video_id\":\s*\"([^\"]+)\"/);
		return downloadUrl;
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
			Log.i(TAG , line);
		    str.append(line);
		}
		stream.close();
		html = str.toString();
		return html;
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

	@Override
	protected Void doInBackground(String... params) {
		try {
			String htmlContent = getHTMLString(params[0]);
//			String downloadUrl = getDownloadUrlFromHtmlContent(htmlContent);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
