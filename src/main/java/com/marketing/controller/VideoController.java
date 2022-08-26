package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.VideoData;
import com.marketing.entities.Video;
import com.marketing.services.VideoService;

@Controller
public class VideoController {
	
	@Autowired
	private VideoService videoservice;
	
	@RequestMapping("/tCup")
	public String saveOneVideo() {
		return "create_video";
	}
	
//	@RequestMapping("/addCup")
//	public String addOneVideo(@ModelAttribute Video video,ModelMap model) {
//		videoservice.saveVideo(video);
//		model.addAttribute("msg", "Video is Saved");
//		return "create_video";
//		
//	}
	
//	@RequestMapping("/addCup")
//	public String addOneVideo(@RequestParam("firstName") String fName,@RequestParam("lastName") String lName,@RequestParam("email") String email,@RequestParam("mobile") String mobile) {
//		Video v = new Video();
//		v.setFirstName(fName);
//		v.setLastName(lName);
//		v.setEmail(email);
//		v.setMobile(mobile);
//		videoservice.saveVideo(v);
//		return "create_video";
//		
//	}
	
	@RequestMapping("/addCup")
	public String addOneVideo(VideoData video,ModelMap model) {
		Video v = new Video();
		v.setEmail(video.getEmail());
		v.setFirstName(video.getFirstName());
		v.setLastName(video.getLastName());
		v.setMobile(video.getMobile());
		videoservice.saveVideo(v);
		model.addAttribute("msg", "Video is Saved");
		return "create_video";
		
	}
	
	@RequestMapping("/akshay")
	public String listAllLeads(ModelMap model) {
		List<Video> leads = videoservice.listLead();
		model.addAttribute("leads", leads);
		return "lead_result";
		
	}
	
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id,ModelMap model) {
		
		videoservice.deleteLeadById(id);
		
		List<Video> leads = videoservice.listLead();
		model.addAttribute("leads", leads);
		return "lead_result";
	}
	
	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id") long id,ModelMap model) {
		Video video = videoservice.updateOneData(id);
		model.addAttribute("video", video);
		return "update_result";
	}
	
	@RequestMapping("/updateLead")
	public String updateOneLeadData(VideoData data,ModelMap model) {
		Video video = new Video();
		video.setId(data.getId());
		video.setFirstName(data.getFirstName());
		video.setLastName(data.getLastName());
		video.setEmail(data.getEmail());
		video.setMobile(data.getMobile());
		
		videoservice.saveVideo(video);
		
		List<Video> leads = videoservice.listLead();
		model.addAttribute("leads", leads);
		return "lead_result";
	}
}
