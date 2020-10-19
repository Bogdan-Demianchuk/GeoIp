package com.demianchuk.GeoIp.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.demianchuk.GeoIp.mapper.IpMapper;
import com.demianchuk.GeoIp.model.Ip;
import com.demianchuk.GeoIp.service.CsvParserService;
import com.demianchuk.GeoIp.service.FileReaderService;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.stereotype.Service;

@Service
public class IpCsvParser implements CsvParserService {
    private final FileReaderService fileRiderService;
    private final IpMapper ipMapper;

    public IpCsvParser(FileReaderService fileRiderService, IpMapper ipMapper) {
        this.fileRiderService = fileRiderService;
        this.ipMapper = ipMapper;
    }

    @Override
    public List<Ip> parseCsvFile(String path) {
        List<Ip> ipList = new ArrayList<>();
        CsvParserSettings csvParserSettings = new CsvParserSettings();
        csvParserSettings.setMaxCharsPerColumn(-1);
        CsvParser csvParser = new CsvParser(csvParserSettings);
        List<String> lines = fileRiderService.read(path);
        lines.remove(0);
        for (String line : lines) {
            String[] reviewContent = csvParser.parseLine(line);
            ipList.add(ipMapper.getIpFromLine(reviewContent));
        }
        return ipList;
    }
}
