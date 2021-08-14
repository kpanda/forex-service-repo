package com.example.forex.forexservicems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.forex.forexservicems.model.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
	ExchangeValue findByFromAndTo(String from, String to);
}
