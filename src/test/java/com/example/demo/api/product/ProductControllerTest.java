package com.example.demo.api.product;

import com.example.demo.api.ApplicationTest;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.*;


class ProductControllerTest extends ApplicationTest {
    @Test
    void get_product_id_1_should_return_product() throws Exception {
        var headers = new LinkedMultiValueMap<String, String>();
        headers.add("x-customer-id", "user-id-1");
        var request = new HttpEntity<>(headers);
        var response = restTemplate.exchange("/products/product-id-1", HttpMethod.GET, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(OK);
        JSONAssert.assertEquals("{\"id\":\"product-id-1\",\"name\":\"product-name-1\",\"priceInFen\":10000}", response.getBody(), false);
    }

    @Test
    void get_product_id_2_should_return_not_found() {
        var headers = new LinkedMultiValueMap<String, String>();
        headers.add("x-customer-id", "user-id-1");
        var request = new HttpEntity<>(headers);
        var response = restTemplate.exchange("/products/product-id-0", HttpMethod.GET, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(NOT_FOUND);
    }

    @Test
    void post_products_should_return_201() {
        var headers = new LinkedMultiValueMap<String, String>();
        headers.add("x-customer-id", "user-id-1");
        var body = Map.of("name", "new-product-name", "priceInFen", 20000);
        var request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange("/products", HttpMethod.POST, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(CREATED);
    }

    @Test
    void post_products_without_name_should_return_400() {
        var headers = new LinkedMultiValueMap<String, String>();
        headers.add("x-customer-id", "user-id-1");
        var body = Map.of("priceInFen", 20000);
        var request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange("/products", HttpMethod.POST, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(BAD_REQUEST);
    }

    @Test
    void post_products_with_empty_name_should_return_400() {
        var headers = new LinkedMultiValueMap<String, String>();
        headers.add("x-customer-id", "user-id-1");
        var request = new HttpEntity<>(Map.of("name", "", "priceInFen", 20000), headers);
        ResponseEntity<String> response = restTemplate.exchange("/products", POST, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(BAD_REQUEST);
    }

    @Test
    void post_products_with_empty_price_should_return_400() {
        var headers = new LinkedMultiValueMap<String, String>();
        headers.add("x-customer-id", "user-id-1");
        var request = new HttpEntity<>(Map.of("name", "new-product-name"), headers);
        ResponseEntity<String> response = restTemplate.exchange("/products", POST, request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(BAD_REQUEST);
    }
}