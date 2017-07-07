package com.zahariaca.springboot.starter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {


	@RequestMapping("/topics")
	public List<Topic> getAllTopic(){
		
		return Arrays.asList(
				new Topic("spring", "Spring Framework", "Spring Framework Description"),
				new Topic("java", "Java core", "Java core Description"),
				new Topic("Javascript", "Javascript Framework", "Javascript Framework Description")
				);
	}
	
}
