package com.demianchuk.GeoIp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import com.demianchuk.GeoIp.service.impl.LocalFileReaderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LocalFileReaderServiceTest {
    @Autowired
    LocalFileReaderService localFileReaderService;

    @Test
    public void localFileReaderServiceCorrectRead() {
        List<String> actual = localFileReaderService
                .read("src/test/java/com/demianchuk/GeoIp/resources/fileForReadByTest");
        List<String> expected = List.of("Hello Test", "Test is pass");
        assertEquals(actual, expected);
    }

    @Test
    public void localFileReaderServiceUnCorrectPath(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
                localFileReaderService.read("51/sdf");});
        assertEquals("Can't read file", exception.getMessage());
    }
}
