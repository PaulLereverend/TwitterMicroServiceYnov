package com.ecriretweet.ecriretweet;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@SpringBootApplication
public class EcriretweetApplication {
	
	static final String CONSUMER_KEY = "SPcQsEqo5SEcZxpVs0nbGbakj";
	static final String CONSUMER_SECRET = "OvrQ5wmngjJrqUguUgBL9nsnbBcfcjSqowZeE8q0lRMHAzbwoj";
	static final String ACCESS_TOKEN = "1216985142943719424-VaCkNtGuNTAqFT4UYlrWeceMU8jPhs";
	static final String ACCESS_TOKEN_SECRET = "2A2QfsRUkFPJ1ceSo50n8XNnwXH6uP8if19tLcNX49Vvf";


	
	
	

	public static void main(String[] args) throws TwitterException, IOException {
		ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)
	    .setOAuthConsumerKey(CONSUMER_KEY)
	    .setOAuthConsumerSecret(CONSUMER_SECRET)
	    .setOAuthAccessToken(ACCESS_TOKEN)
	    .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

	    TwitterFactory tf = new TwitterFactory(cb.build());
	    Twitter twitter = tf.getInstance();
	    Scanner sc = new Scanner(System.in);
		System.out.println("saisir un tweet :");
		String letweet = sc.nextLine();
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "censor-character=*&content=blacla");
		Request request = new Request.Builder()
			.url("https://neutrinoapi-bad-word-filter.p.rapidapi.com/bad-word-filter")
			.post(body)
			.addHeader("x-rapidapi-host", "neutrinoapi-bad-word-filter.p.rapidapi.com")
			.addHeader("x-rapidapi-key", "204411731emsha53858308e14880p174122jsn90ceb00b1a8d")
			.addHeader("content-type", "application/x-www-form-urlencoded")
			.build();

		Response response = client.newCall(request).execute();
		String bad = response.body().string();
		//System.out.println(bad);
		String search = "\"is-bad\":false";
		
		if ( bad.toLowerCase().indexOf(search.toLowerCase()) != -1 )
	    	{twitter.updateStatus(letweet);}
		
		else {System.out.println("gros mot");}
		SpringApplication.run(EcriretweetApplication.class, args);
		
		//twitter.updateStatus(letweet);
	}
	
	
		
	public static Twitter getTwitterInstance() {
	    ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)
	    .setOAuthConsumerKey(CONSUMER_KEY)
	    .setOAuthConsumerSecret(CONSUMER_SECRET)
	    .setOAuthAccessToken(ACCESS_TOKEN)
	    .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

	    TwitterFactory tf = new TwitterFactory(cb.build());
	    return tf.getInstance();
	}
	
	
	public String createTweet(String tweet) throws TwitterException {
	    Twitter twitter = getTwitterInstance();
	    Status status = twitter.updateStatus(tweet);
	    return status.getText();
	}
	
		

}
