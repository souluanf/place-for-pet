package com.fiap.placeforpet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAppTests {


    @Test
    void main() {
        Assertions.assertDoesNotThrow(() -> SpringApp.main(new String[]{}));
    }

}
