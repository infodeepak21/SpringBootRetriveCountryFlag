package com.hcl.app.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.app.bean.Continent;
import com.hcl.app.bean.ContinentData;

@Configuration
public class DataSourceConfig {
	/*
	 * @Bean public DataSource getDataSource() { DataSourceBuilder dataSourceBuilder
	 * = DataSourceBuilder.create(); dataSourceBuilder.driverClassName("");
	 * dataSourceBuilder.url(""); dataSourceBuilder.username("");
	 * dataSourceBuilder.password(""); return dataSourceBuilder.build(); }
	 */

	@Bean(name = "getContinentData")
	public ContinentData getContinentData() {
		ContinentData data = new ContinentData();
		TypeReference<List<Continent>> typeReference = new TypeReference<List<Continent>>() {

		};
		ObjectMapper mapper = new ObjectMapper();
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/continents.json");
		try {
			List<Continent> contrList = mapper.readValue(inputStream, typeReference);
			data.setContinents(contrList);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

}
