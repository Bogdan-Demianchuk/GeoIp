package com.demianchuk.GeoIp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Ip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ipFrom;
    private Long ipTo;
    private String countryCode;
    private String countryName;
    private String cityName;
    private String regionName;
    private Double latitude;
    private Double longitude;
}
