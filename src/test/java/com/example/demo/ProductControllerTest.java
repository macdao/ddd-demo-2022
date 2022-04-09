package com.example.demo;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;


@SpringBootTest(webEnvironment = RANDOM_PORT)
class ProductControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void get_product_id_1_should_return_product() throws Exception {
        var response = restTemplate.getForObject("/products/product-id-1", String.class);
        JSONAssert.assertEquals("{\"id\":\"product-id-1\",\"name\":\"product-name-1\"}", response, false);
    }

    @Test
    void post_product_should_return_201() {
        HttpEntity<Map<String, String>> request = new HttpEntity<>(Map.of("id", "new-product-id", "name", "new-product-name"));
        ResponseEntity<String> response = restTemplate.exchange("/products", POST, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(CREATED);
    }

    @Test
    void post_product_without_id_should_return_400() {
        HttpEntity<Map<String, String>> request = new HttpEntity<>(Map.of("name", "new-product-name"));
        ResponseEntity<String> response = restTemplate.exchange("/products", POST, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(BAD_REQUEST);
    }

    @Test
    void post_product_with_empty_id_should_return_400() {
        HttpEntity<Map<String, String>> request = new HttpEntity<>(Map.of("id", "", "name", "new-product-name"));
        ResponseEntity<String> response = restTemplate.exchange("/products", POST, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(BAD_REQUEST);
    }
}