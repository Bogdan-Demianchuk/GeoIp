package com.demianchuk.GeoIp.service;

import java.util.List;

public interface FileReaderService {
    List<String> read(String path);
}
