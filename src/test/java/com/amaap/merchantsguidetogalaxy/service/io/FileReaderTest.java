package com.amaap.merchantsguidetogalaxy.service.io;

import com.amaap.merchantsguidetogalaxy.service.io.exception.NoDataFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FileReaderTest {

    @Test
    void shouldThrowExceptionIfFileDonNotHaveData() {
        // arrange
        FileReader fileReader = new FileReader();
        String path = "D:\\MerchantsGuideToGalaxy\\src\\main\\resources\\EmptyData.txt";

        // act & assert
        assertThrows(NoDataFoundException.class, () -> {
            fileReader.read(path);
        });

    }

}