package com.demianchuk.GeoIp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import com.demianchuk.GeoIp.model.Ip;
import com.demianchuk.GeoIp.service.impl.IpCsvParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IpCsvParserTest {
    @Autowired
    IpCsvParser ipCsvParser;

    @Test
    public void parseCsvFileCorrectPath() {
        List<Ip> actual = ipCsvParser.parseCsvFile("src/test/java/com/demianchuk/GeoIp/resources/CSVFileForTest");
        Ip ipFirst = new Ip(null, 16777216L, 16777471L, "US", "United States of America", "California", "Los Angeles", 34.052230, -118.243680);
        Ip ipSecond = new Ip(null, 16777472L, 16778239L, "CN","China","Fujian","Fuzhou",26.061390,119.306110);
        Ip ipThird = new Ip(null, 16778240L, 16779263L,"AU","Australia","Victoria","Melbourne",-37.814000,144.963320);
        Ip ipFourth = new Ip(null, 16779264L, 16781311L,"CN","China","Guangdong","Guangzhou",23.116670,113.250000);
        List<Ip> expected = List.of(ipFirst, ipSecond, ipThird, ipFourth);
        assertEquals(actual, expected);
    }
    @Test
    public void parseCsvFileUnCorrectPath() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            ipCsvParser.parseCsvFile("sa/as");});
        assertEquals("Can't read file", exception.getMessage());
    }
}
