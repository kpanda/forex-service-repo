package com.example.forex.forexservicems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.forex.forexservicems.aspects.Logging;
import com.example.forex.forexservicems.model.ExchangeValue;
import com.example.forex.forexservicems.repository.ExchangeValueRepository;

@RestController
public class ForexController {

	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeValueRepository exchangeValueRepository;

	@Logging
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue
	(@PathVariable String from, @PathVariable String to){

		ExchangeValue exchangeValue = 
				exchangeValueRepository.findByFromAndTo(from, to);
		
		/*
		 * exchangeValue.setPort(
		 * Integer.parseInt(environment.getProperty("local.server.port")));
		 */

		return exchangeValue;
	}

}
