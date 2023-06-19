package com.productcatalogue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalogue.dao.ProductDao;
import com.productcatalogue.dao.ProductRepository;
import com.productcatalogue.entity.ProductEntity;
import com.productcatalogue.model.Product;
import com.productcatalogue.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductDao productDao;

	// Save Product detail
	@Override
	public void createProduct(Product product) {
		productDao.createProduct(product);

	}

	@Override
	public void saveActiveProduct(ProductEntity product) {
		productRepository.saveAndFlush(product);
	}


	@Override
	public void dactivateProductById(ProductEntity product) {
		 productRepository.saveAndFlush(product);
	}

	@Override
	public void deactivateProduct(ProductEntity product) {
		productRepository.saveAndFlush(product);
	}



	@Override
	public List<Product> getProducts(Long familyId, String productName, Long productId, Integer limit,
			Integer offset, String orderBy) {
		return productDao.getProducts(familyId, productName, productId, limit, offset, orderBy);
	}

	@Override
	public Long getProductMapCount(Long familyId, Long productOwnerTypeId,
			Long locationId, Long partnerId) {
		return productDao.getProductMapCount(familyId, productOwnerTypeId,
				locationId, partnerId);
	}


	@Override
	public List<Product> getProductMap(Long familyId, Long productOwnerTypeId,
			Long locationId, Long partnerId, String searchText, Integer limit, Integer offset, String orderBy) {
		return productDao.getProductMap(familyId, productOwnerTypeId,
				locationId, partnerId, searchText, limit, offset, orderBy);
	}

	@Override
	public Long getProductCount(Long productId,Long familyId,String productName) {
		return productDao.getProductCount(productId,familyId,productName);
	}

}
