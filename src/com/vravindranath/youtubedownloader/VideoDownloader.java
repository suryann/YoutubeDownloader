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

public class VideoDownloader {
	private static final String YOUTUBE_WATCH_URL_PREFIX = "http://www.youtube.com/watch?v=";
	
	public VideoDownloader(String url) {
		try {
			String htmlContent = getHTMLString(url);
			String downloadUrl = getDownloadUrlFromHtmlContent(htmlContent);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getDownloadUrlFromHtmlContent(String htmlContent) {
		String downloadUrl = null;
		String[] videoIdMatches = htmlContent.split(/\"video_id\":\s*\"([^\"]+)\"/);
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
}
