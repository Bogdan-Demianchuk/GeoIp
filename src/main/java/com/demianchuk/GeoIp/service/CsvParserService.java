package com.demianchuk.GeoIp.service;

import java.util.List;

public interface CsvParserService<T> {
    List<T> parseCsvFile(String path);
}
