package com.example.evatesttask.service.impl;

import java.util.stream.Stream;
import com.example.evatesttask.model.Product;
import com.example.evatesttask.repository.ProductRepository;
import com.example.evatesttask.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Stream<Product> getByNameFilter(String nameFilter) {
        System.out.println("Start filtering filtered");
        Stream<Product> collect = productRepository.streamAllBy().parallel()
                .filter(product -> !product.getName().matches(nameFilter));
        System.out.println("All rows were filtered");
        return collect;
    }
}
