package com.hcl.app.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.app.bean.Continent;
import com.hcl.app.bean.ContinentData;
import com.hcl.app.bean.Countries;

@Service
public class CountryServices {

	static Logger log = Logger.getLogger(CountryServices.class.getName());

	@Autowired
	private ContinentData continentData;

	public ResponseEntity<?> getFlagByCountry(String continent, String country) {
		log.info("Entered Into getFlagByCountry("+continent+","+country);
		List<Continent> list = continentData.getContinents();
		if (continent != null && !continent.isEmpty()) {
			if (country != null && !country.isEmpty()) {
				for (Continent continent1 : list) {
					if (continent.equals(continent1.getContinent())) {
						return new ResponseEntity<String>(getCountry(continent1, country).getFlag(), HttpStatus.OK);
					}
				}

			} else {
				for (Continent continent1 : list) {
					if (continent.equals(continent1.getContinent())) {
						return new ResponseEntity<List<Countries>>(continent1.getCountries(), HttpStatus.OK);
					}
				}
			}
		} else {
			if (country != null && !country.isEmpty()) {
				for (Continent continent1 : list) {
					return new ResponseEntity<String>(getCountry(continent1, country).getFlag(), HttpStatus.OK);
				}
			}
		}
		return new ResponseEntity<String>("No Data found", HttpStatus.OK);
	}

	private Countries getCountry(Continent continent1, String country) {
		for (Countries countries1 : continent1.getCountries()) {
			if (country.equals(countries1.getName())) {
				return countries1;
			}
		}
		return null;
	}

	public ContinentData getContinentData() {
		return continentData;
	}

	public void setContinentData(ContinentData continentData) {
		this.continentData = continentData;
	}
	
	
}
