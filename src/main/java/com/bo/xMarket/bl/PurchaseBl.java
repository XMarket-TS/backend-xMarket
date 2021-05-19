package com.bo.xMarket.bl;

import com.bo.xMarket.dao.ItemsDao;
import com.bo.xMarket.dao.PurchaseDao;
import com.bo.xMarket.dao.StockDao;
import com.bo.xMarket.dto.PurchaseRequest;
import com.bo.xMarket.model.Items;
import com.bo.xMarket.model.Purchase;
import com.bo.xMarket.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PurchaseBl {
    private PurchaseDao purchaseDao;
    private StockDao stockDao;
    private ItemsDao itemsDao;

    @Autowired
    public PurchaseBl(PurchaseDao purchaseDao, StockDao stockDao, ItemsDao itemsDao) {
        this.purchaseDao = purchaseDao;
        this.stockDao = stockDao;
        this.itemsDao = itemsDao;
    }

    public PurchaseRequest buyProducts(Integer userId, PurchaseRequest purchaseRequestList, Transaction transaction){
        Purchase purchase= new Purchase();
        purchase.setBuyDate(new Date());
        purchase.setBillingAddress(purchaseRequestList.getBillingAddress());
        purchase.setCity(purchaseRequestList.getCity());
        purchase.setCardId(purchaseRequestList.getCardId());
        purchase.setUserId(userId);
        purchase.setTransaction(transaction);
        purchaseDao.createPurchase(purchase);
        Integer purchaseId= purchaseDao.getLastIdPurchase();
        purchaseRequestList.getProductPurchases().forEach(productPurchase -> {
            Items item= new Items();
            item.setPurchaseId(purchaseId);
            item.setAmount(productPurchase.getUnit());
            item.setProductId(productPurchase.getProductId());
            itemsDao.addItemToPurchase(item);
            stockDao.updateStock(productPurchase.getUnit(),productPurchase.getProductId());
        });
        return purchaseRequestList;
    }
}
