package fr.ynov.paullereverend.b3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.ynov.paullereverend.b3.services.TimelineService;
import twitter4j.JSONException;
import twitter4j.JSONObject;
import twitter4j.Status;

@RestController
public class TimelineController {

	@Autowired
	TimelineService service;
	
	@RequestMapping(value = "/tweet/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public String getById(@PathVariable String id) {
		Status tweet = service.getTweet(id);
		JSONObject json = new JSONObject();
		
		try {
			json.put("text", tweet.getText());
			json.put("user", tweet.getUser().getScreenName());
			json.put("date", tweet.getCreatedAt());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}
}
