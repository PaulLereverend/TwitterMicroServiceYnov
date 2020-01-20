package fr.ynov.paullereverend.b3.services;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TimelineService {

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
	
	public Twitter config() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("SPcQsEqo5SEcZxpVs0nbGbakj")
		  .setOAuthConsumerSecret("OvrQ5wmngjJrqUguUgBL9nsnbBcfcjSqowZeE8q0lRMHAzbwoj")
		  .setOAuthAccessToken("1216985142943719424-VaCkNtGuNTAqFT4UYlrWeceMU8jPhs")
		  .setOAuthAccessTokenSecret("2A2QfsRUkFPJ1ceSo50n8XNnwXH6uP8if19tLcNX49Vvf");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		return twitter;
	}
}
