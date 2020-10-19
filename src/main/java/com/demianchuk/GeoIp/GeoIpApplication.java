package com.demianchuk.GeoIp;

import com.demianchuk.GeoIp.service.impl.LocalFileReaderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeoIpApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoIpApplication.class, args);
	}
}
