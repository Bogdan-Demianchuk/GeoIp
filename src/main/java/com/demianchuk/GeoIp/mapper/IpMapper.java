package com.demianchuk.GeoIp.mapper;

import com.demianchuk.GeoIp.model.Ip;
import com.demianchuk.GeoIp.model.dto.IpResponseDot;
import com.demianchuk.GeoIp.repository.IpRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NoArgsConstructor
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
    IpRepository ipRepository;

    @Autowired
    public IpMapper(IpRepository ipRepository) {
        this.ipRepository = ipRepository;
    }


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

    public IpResponseDot getIpResponseDotFromIPv4(String iPv4) {
        IpResponseDot ipResponseDot = new IpResponseDot();
        Long canonicalIPv4Representation = convertIpAddressToDecimal(iPv4);
        Ip ipByIPv4 = ipRepository.findIpByIPv4(canonicalIPv4Representation);
        ipResponseDot.setCanonicalIPv4Representation(iPv4);
        ipResponseDot.setCityName(ipByIPv4.getCityName());
        ipResponseDot.setCountryCode(ipByIPv4.getCountryCode());
        ipResponseDot.setCountryName(ipByIPv4.getCountryName());
        ipResponseDot.setIPv4(canonicalIPv4Representation);
        ipResponseDot.setLatitude(ipByIPv4.getLatitude());
        ipResponseDot.setLongitude(ipByIPv4.getLongitude());
        ipResponseDot.setRegionName(ipByIPv4.getRegionName());
        return ipResponseDot;
    }

    public Long convertIpAddressToDecimal(String iPv4) {
        String[] ipAddressInArray = iPv4.split("\\.");
        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {
            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);
            result += ip * Math.pow(256, power);
        }
        return result;
    }
}
