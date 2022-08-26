package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entities.Video;
import com.marketing.services.VideoService;

@RestController
@RequestMapping("/bpi/leads")
public class VideoRestController {
	
	@Autowired
	private VideoService videoservice;
	
	@GetMapping
	public List<Video> getAllLead(){
		List<Video> leads = videoservice.listLead();
		return leads;
	}
	
	@PostMapping
	public void saveOneLead(@RequestBody Video video) {
		videoservice.saveVideo(video);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteOneLead(@PathVariable("id") long id) {
		videoservice.deleteLeadById(id);
	}
	
	@PutMapping
	public void updateOneLead(@RequestBody Video video) {
		videoservice.saveVideo(video);
	}
	
	@GetMapping("search/{id}")
	public Video getOneLead(@PathVariable("id") long id) {
		Video video = videoservice.updateOneData(id);
		return video;
		
		
	}
	
	
}
