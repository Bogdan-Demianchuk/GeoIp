package com.demianchuk.GeoIp;

import com.demianchuk.GeoIp.controller.ScanDataController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GeoIpApplicationTests {
	@Autowired
	ScanDataController scanDataController;

    @Test
    void contextLoads() {
    }

    @Test
    public void onlinETesting() {
		 scanDataController.getLocalByIp("1.0.86.0");

    }
}
