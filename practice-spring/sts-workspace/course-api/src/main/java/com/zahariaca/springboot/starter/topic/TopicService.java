package com.zahariaca.springboot.starter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	List<Topic> topics = new ArrayList<> (Arrays.asList(
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java", "Java core", "Java core Description"),
			new Topic("Javascript", "Javascript Framework", "Javascript Framework Description")
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id){
		return topics.stream()
				.filter(t -> t.getId().equals(id))
				.findFirst().get();
	}
	
	public void addTopic(Topic topic){
		topics.add(topic);
	}
}
