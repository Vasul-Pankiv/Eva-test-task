package com.example.evatesttask.controller;

import java.util.List;
import java.util.stream.Collectors;
import com.example.evatesttask.dto.response.ProductResponseDto;
import com.example.evatesttask.service.ProductService;
import com.example.evatesttask.service.mapper.ProductResponseDtoMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductService productService;
    private final ProductResponseDtoMapper productResponseDtoMapper;

    public ProductController(ProductService productService,
                             ProductResponseDtoMapper productResponseDtoMapper) {
        this.productService = productService;
        this.productResponseDtoMapper = productResponseDtoMapper;
    }

    @GetMapping(value = "/shop/product")
    @Transactional
    public List<ProductResponseDto> getProductsByNameFilter(
            @RequestParam String nameFilter) {
        return productService.getByNameFilter(nameFilter).map(productResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
