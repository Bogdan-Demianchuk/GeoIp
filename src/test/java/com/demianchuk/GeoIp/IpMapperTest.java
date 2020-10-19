package com.demianchuk.GeoIp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.demianchuk.GeoIp.mapper.IpMapper;
import com.demianchuk.GeoIp.model.Ip;
import com.demianchuk.GeoIp.model.dto.IpResponseDot;
import com.demianchuk.GeoIp.repository.IpRepository;
import com.demianchuk.GeoIp.service.impl.LocalFileReaderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class IpMapperTest {
    Ip expected;
    @Autowired
    LocalFileReaderService localFileReaderService;
    @Autowired
    IpMapper ipMapper;
    @MockBean
    private IpRepository ipRepository;

    @BeforeEach
    public void setUp() {
        expected = new Ip();
        expected.setIpFrom(16778240L);
        expected.setIpTo(16779263L);
        expected.setCountryCode("AU");
        expected.setCountryName("Australia");
        expected.setCityName("Victoria");
        expected.setRegionName("Melbourne");
        expected.setLatitude(-37.814000);
        expected.setLongitude(144.963320);
    }

    @Test
    public void getIpFromLineTest() {
        String[] lines = new String[]{"16778240", "16779263", "AU", "Australia", "Victoria", "Melbourne", "-37.814000", "144.963320"};
        Ip actual = ipMapper.getIpFromLine(lines);
        assertEquals(actual, expected);
    }

    @Test
    public void getIpResponseDotFromIPv4Test() {
        Mockito.when(ipRepository.findIpByIPv4(16778240L)).thenReturn(expected);
        IpResponseDot actual = ipMapper.getIpResponseDotFromIPv4("1.0.4.0");
        IpResponseDot expectedResponseDot = new IpResponseDot();
        expectedResponseDot.setCanonicalIPv4Representation("1.0.4.0");
        expectedResponseDot.setCityName(expected.getCityName());
        expectedResponseDot.setCountryCode(expected.getCountryCode());
        expectedResponseDot.setCountryName(expected.getCountryName());
        expectedResponseDot.setIPv4(16778240L);
        expectedResponseDot.setLatitude(expected.getLatitude());
        expectedResponseDot.setLongitude(expected.getLongitude());
        expectedResponseDot.setRegionName(expected.getRegionName());
        assertEquals(actual, expectedResponseDot);
    }

    @Test
    public void convertIpAddressToDecimalTest() {
        Long actual = ipMapper.convertIpAddressToDecimal("1.0.4.0");
        Long expected = 16778240L;
        assertEquals(actual, expected);
    }
}
