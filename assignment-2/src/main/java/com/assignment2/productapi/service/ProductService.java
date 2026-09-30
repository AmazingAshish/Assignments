package com.assignment2.productapi.service;

import com.assignment2.productapi.entity.Product;
import com.assignment2.productapi.exception.ProductNotFoundException;
import com.assignment2.productapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = getProduct(id);
        product.update(updatedProduct.getName(), updatedProduct.getPrice(), updatedProduct.getQuantity());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.delete(getProduct(id));
    }
}
