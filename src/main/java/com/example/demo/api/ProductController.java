package com.example.demo.api;

import com.example.demo.application.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable String productId) {
        return productService.getProduct(productId).map(product -> {
            GetProductResponse getProductResponse = new GetProductResponse(product.getId().value(), product.getName());
            return ResponseEntity.ok(getProductResponse);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postProducts(@RequestBody @Valid CreateProductRequest request) {
        productService.createProduct(request.getId(), request.getName());
    }
}
