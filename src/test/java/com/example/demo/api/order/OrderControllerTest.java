package com.example.demo.api.order;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class OrderControllerTest {
    @Autowired
    TestRestTemplate restTemplate;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void post_orders_should_return_201() {
        var request = Map.of("productId", "product-id-1",
                "amount", 5,
                "deliveryAddress", Map.of("contactName", "Josh", "contactPhone", "13888888888", "address", "Shanghai"));
        ResponseEntity<String> response = restTemplate.postForEntity("/orders", request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(CREATED);

        jdbcTemplate.queryForObject("select * from `order` where amount = ?", (resultSet, rowNum) -> {
            assertThat(resultSet.getString("id")).isNotBlank();
            return null;
        }, 5);
    }
}