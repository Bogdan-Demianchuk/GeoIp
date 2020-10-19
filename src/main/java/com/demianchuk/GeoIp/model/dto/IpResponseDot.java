package com.demianchuk.GeoIp.model.dto;

import lombok.Data;

@Data
public class IpResponseDot {
    private String canonicalIPv4Representation;
    private String cityName;
    private String countryCode;
    private String countryName;
    private Long iPv4;
    private Double latitude;
    private Double longitude;
    private String regionName;
}
