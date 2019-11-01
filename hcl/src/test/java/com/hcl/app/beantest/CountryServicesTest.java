package com.hcl.app.beantest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.app.bean.Continent;
import com.hcl.app.bean.ContinentData;
import com.hcl.app.bean.Countries;
import com.hcl.app.service.CountryServices;

@RunWith(SpringRunner.class)
public class CountryServicesTest {

	CountryServices service;

	@Before
	public void init() {
		service = new CountryServices();
		ContinentData continentData = new ContinentData();
		List<Continent> continents = new ArrayList<Continent>();
		Continent cont = new Continent();
		cont.setContinent("Africa");
		List<Countries> counties = new ArrayList<>();
		Countries countries = new Countries();
		countries.setFlag("NG");
		countries.setName("Nigeria");
		counties.add(countries);
		cont.setCountries(counties);
		continents.add(cont);
		continentData.setContinents(continents);
		service.setContinentData(continentData);
	}

	@Test
	public void testGetFlagByContinents() {
		ResponseEntity<?> res = service.getFlagByCountry("", "Nigeria");
		String flag = (String) res.getBody();
		Assert.assertEquals("NG", flag);
	}

}
