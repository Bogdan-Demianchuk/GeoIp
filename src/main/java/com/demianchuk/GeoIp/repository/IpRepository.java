package com.demianchuk.GeoIp.repository;

import com.demianchuk.GeoIp.model.Ip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpRepository extends CrudRepository<Ip, Long> {
}
