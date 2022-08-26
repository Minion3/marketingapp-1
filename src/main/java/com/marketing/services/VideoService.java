package com.marketing.services;

import java.util.List;

import com.marketing.entities.Video;

public interface VideoService {

	public void saveVideo(Video video);

	public List<Video> listLead();

	public void deleteLeadById(long id);

	public Video updateOneData(long id);
}
