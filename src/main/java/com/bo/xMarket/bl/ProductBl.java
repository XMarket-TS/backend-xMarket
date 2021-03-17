package com.bo.xMarket.bl;

import com.bo.xMarket.dao.ProductDao;
import com.bo.xMarket.dao.TransactionDao;
import com.bo.xMarket.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBl {
    private ProductDao productDao;
    private TransactionDao transactionDao;

    @Autowired
    public ProductBl(ProductDao productDao, TransactionDao transactionDao) {
        this.productDao = productDao;
        this.transactionDao = transactionDao;
    }

    public List<Product> productList(Integer id){
        return productDao.listproducts(id);
    }
}
