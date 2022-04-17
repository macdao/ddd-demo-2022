package com.example.demo.api.order;

import com.example.demo.api.ApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FORBIDDEN;

class OrderControllerTest extends ApplicationTest {

    @Test
    void post_orders_should_return_201() {
        var body = Map.of("productId", "product-id-1",
                "amount", 5,
                "deliveryAddress", Map.of("contactName", "Josh", "contactPhone", "13888888888", "address", "Shanghai"));
        var headers = new LinkedMultiValueMap<String, String>();
        headers.add("x-customer-id", "user-id-1");
        var request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange("/orders", HttpMethod.POST, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(CREATED);

        jdbcTemplate.queryForObject("select * from `order` where amount = ?", (resultSet, rowNum) -> {
            assertThat(resultSet.getString("id")).isNotBlank();
            return null;
        }, 5);
    }

    @Test
    void post_orders_without_customer_id_should_return_403() {
        var body = Map.of("productId", "product-id-1",
                "amount", 5,
                "deliveryAddress", Map.of("contactName", "Josh", "contactPhone", "13888888888", "address", "Shanghai"));
        var headers = new LinkedMultiValueMap<String, String>();
        var request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange("/orders", HttpMethod.POST, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(FORBIDDEN);
    }
}