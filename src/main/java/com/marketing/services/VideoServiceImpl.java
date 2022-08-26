package com.marketing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entities.Video;
import com.marketing.repositories.VideoRepository;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoRepository videorepo;

	@Override
	public void saveVideo(Video video) {
		videorepo.save(video);
	}

	@Override
	public List<Video> listLead() {
		List<Video> leads = videorepo.findAll();
		return leads;
	}

	@Override
	public void deleteLeadById(long id) {
			videorepo.deleteById(id);
	}

	@Override
	public Video updateOneData(long id) {
		Optional<Video> findById = videorepo.findById(id);
		Video video = findById.get();
		return video;
	}

}
