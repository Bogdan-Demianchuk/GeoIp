package com.demianchuk.GeoIp.controller;

import com.demianchuk.GeoIp.mapper.IpMapper;
import com.demianchuk.GeoIp.model.dto.IpResponseDot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetIpInfoController {
    private final IpMapper ipMapper;

    public GetIpInfoController(IpMapper ipMapper) {
        this.ipMapper = ipMapper;
    }

    @GetMapping("/geoip/{ip}")
    public IpResponseDot getLocalByIp(@PathVariable String ip) {
        return ipMapper.getIpResponseDotFromIPv4(ip);
    }
}
