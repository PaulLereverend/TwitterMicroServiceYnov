package fr.ynov.paullereverend.b3.services;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import twitter4j.JSONArray;
import twitter4j.JSONException;
import twitter4j.JSONObject;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TimelineService {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

	public Status getTweet(String id) {
		
		Twitter twitter = config();
		try {
	        Status status = twitter.showStatus(Long.parseLong(id));
	        if (status == null) { // 
	        } else {
	            System.out.println("@" + status.getUser().getScreenName()
	                        + " - " + status.getText());
	    		return status;
	        }
	    } catch (TwitterException e) {
	        System.err.print("Failed to search tweets: " + e.getMessage());
	    }
		return null;
	}
	
	private JSONObject sendGet() {

        HttpGet request = new HttpGet("http://localhost:8081");

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);

            if (entity != null) {
                String result = EntityUtils.toString(entity);
                System.out.println(result);
                JSONObject obj = new JSONObject(result);
            }
        }catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }

	public JSONArray getTimeline() throws TwitterException {
		Twitter twitter = config();
		JSONArray tl = new JSONArray();
	     for (Status tweet : twitter.getHomeTimeline()) {
	    	JSONObject json = new JSONObject();
	 		try {
	 			json.put("text", tweet.getText());
	 			json.put("user", tweet.getUser().getScreenName());
	 			json.put("date", tweet.getCreatedAt());
	 		} catch (JSONException e) {
	 			e.printStackTrace();
	 		}
			tl.put(json);
		}
	    return tl; 
	}
	
	public Twitter config() {		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(false)
		  .setOAuthConsumerKey("SPcQsEqo5SEcZxpVs0nbGbakj")
		  .setOAuthConsumerSecret("OvrQ5wmngjJrqUguUgBL9nsnbBcfcjSqowZeE8q0lRMHAzbwoj")
		  .setOAuthAccessToken("1216985142943719424-VaCkNtGuNTAqFT4UYlrWeceMU8jPhs")
		  .setOAuthAccessTokenSecret("2A2QfsRUkFPJ1ceSo50n8XNnwXH6uP8if19tLcNX49Vvf");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		return twitter;
	}
}
