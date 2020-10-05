package com.demianchuk.GeoIp.mapper;

import com.demianchuk.GeoIp.model.Ip;
import org.springframework.stereotype.Component;

@Component
public class IpMapper {
    private static final int IP_FROM = 0;
    private static final int IP_TO = 1;
    private static final int COUNTRY_CODE = 2;
    private static final int COUNTRY_NAME = 3;
    private static final int CITY_NAME = 4;
    private static final int REGION_NAME = 5;
    private static final int LATITUDE = 6;
    private static final int LONGITUDE = 7;

    public Ip getIpFromLine(String[] lines) {
        Ip ip = new Ip();
        ip.setIpFrom(Long.valueOf(lines[IP_FROM]));
        ip.setIpTo(Long.valueOf(lines[IP_TO]));
        ip.setCountryCode(lines[COUNTRY_CODE]);
        ip.setCountryName(lines[COUNTRY_NAME]);
        ip.setCityName(lines[CITY_NAME]);
        ip.setRegionName(lines[REGION_NAME]);
        ip.setLatitude(Double.valueOf(lines[LATITUDE]));
        ip.setLongitude(Double.valueOf(lines[LONGITUDE]));
        return ip;
    }
}
