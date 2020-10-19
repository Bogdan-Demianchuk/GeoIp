package com.demianchuk.GeoIp.repository;

import com.demianchuk.GeoIp.model.Ip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpRepository extends CrudRepository<Ip, Long> {

    @Query("SELECT u FROM Ip u WHERE u.ipFrom <= ?1 and u.ipTo >= ?1")
    Ip findIpByIPv4(Long iPv4);
}
