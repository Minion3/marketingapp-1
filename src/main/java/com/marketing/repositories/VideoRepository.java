package com.marketing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketing.entities.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
