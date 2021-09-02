package com.practice.awsDynamoDB.service;

import java.util.List;

import com.practice.awsDynamoDB.model.Template;
import com.practice.awsDynamoDB.repository.TemplateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.awsDynamoDB.model.SongsPojo;
import com.practice.awsDynamoDB.repository.DynamoDao;

@Service
public class DynamoService {

	@Autowired
	DynamoDao dao;
	@Autowired
	TemplateDao templateDao;

	public String addMusic(SongsPojo song) throws Exception {
		return dao.addMusic(song);
	}

	public List<SongsPojo> getMusicById(String songId) throws Exception {
		return dao.getMusicfromId(songId);
	}

	public List<SongsPojo> getMusicByName(String songName) throws Exception {
		return dao.getMusicfromName(songName);
	}

	public List<Template> getTemplateByKey(String ui_key) throws Exception {
		return templateDao.getTemplatebyId(ui_key);
	}

	public void updateMusicById(SongsPojo song) throws Exception {
		dao.updateMusicbyId(song);
	}

}
