package com.demianchuk.GeoIp.model.dto;

import lombok.Data;

@Data
public class IpDto {
    private String canonicalIPv4Representation;
    private String cityName;
    private String countryCode;
    private String countryName;
    private Long IPv4;
    private Double latitude;
    private Double longitude;
    private String regionName;
}
