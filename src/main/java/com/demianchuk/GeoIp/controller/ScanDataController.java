package com.demianchuk.GeoIp.controller;

import java.util.List;
import com.demianchuk.GeoIp.model.Ip;
import com.demianchuk.GeoIp.repository.IpRepository;
import com.demianchuk.GeoIp.service.CsvParserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScanDataController {
    private final CsvParserService csvParserService;
    private final IpRepository ipRepository;

    public ScanDataController(CsvParserService csvParserService, IpRepository ipRepository) {
        this.csvParserService = csvParserService;
        this.ipRepository = ipRepository;
    }

    @GetMapping("/scan-data")
    public ResponseEntity putDataToDb() {
        List<Ip> list = csvParserService.parseCsvFile("src/main/resources/static/IP2LOCATION-LITE-DB5.CSV");
        for (Ip ip: list){
            ipRepository.save(ip);
        }
        return new ResponseEntity("data in db", HttpStatus.OK);
    }
}
