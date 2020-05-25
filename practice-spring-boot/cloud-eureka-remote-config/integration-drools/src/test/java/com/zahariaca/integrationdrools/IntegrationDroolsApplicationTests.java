package com.zahariaca.integrationdrools;

import com.zahariaca.integrationdrools.pojo.Fare;
import com.zahariaca.integrationdrools.pojo.TaxiRide;
import com.zahariaca.integrationdrools.service.TaxiFareCalculatorService;
import com.zahariaca.integrationdrools.service.TaxiFareConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TaxiFareConfiguration.class)
public class IntegrationDroolsApplicationTests {
	@Autowired
	TaxiFareCalculatorService taxiFareCalculatorService;

	@Test
	public void contextLoads() {
	}



}
