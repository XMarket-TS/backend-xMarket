package com.bo.xMarket.api;

import com.bo.xMarket.bl.ProductBl;
import com.bo.xMarket.bl.TransactionBl;
import com.bo.xMarket.dto.OfferRequest;
import com.bo.xMarket.dto.ProductRequest;
import com.bo.xMarket.dto.ProductResponse;
import com.bo.xMarket.dto.ProductSpecificResponse;
import com.bo.xMarket.model.Product;
import com.bo.xMarket.model.Transaction;
import com.bo.xMarket.util.TransactionUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "")
public class ProductApi {
    private final ProductBl productBl;
    private final TransactionBl transactionBl;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductApi.class);

    @Autowired
    public ProductApi(ProductBl productBl, TransactionBl transactionBl) {
        this.productBl = productBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(value = "/manager/{personId}/products", params = {"page", "size"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<ProductResponse> ListProducts(@PathVariable("personId") Integer id, @RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return productBl.productList(id, page, size);
    }

    @RequestMapping(value = "/user/{userid}/branchOffice/{branchoffice}/category/{categoryid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> productsbycategory(@PathVariable("userid") Integer id, @PathVariable("branchoffice") Integer idbranch, @PathVariable("categoryid") Integer idcategory) {
        return productBl.productListbyCategory(id, idbranch, idcategory);
    }

    @RequestMapping(value = "/user/{userid}/branchOffice/{branchoffice}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> productsbycategory(@PathVariable("userid") Integer id, @PathVariable("branchoffice") Integer idbranch) {
        return productBl.productListbyBranchId(id, idbranch);
    }

    @RequestMapping(value = "/admin/{userid}/branchOffice/{branchoffice}/product", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product addProduct(@PathVariable("userid") Integer id, @PathVariable("branchoffice") Integer idbranch, @RequestBody ProductRequest productRequest, HttpServletRequest request) {
        LOGGER.warn(id.toString());
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        return productBl.addProduct(productRequest, idbranch, transaction);
    }

    @RequestMapping(value = "/product/{productid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductSpecificResponse productInfo(@PathVariable("productid") Integer id) {
        return productBl.productInfo(id);
    }

    @RequestMapping(value = "/product/{productid}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void productDelete(@PathVariable("productid") Integer productid, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        productBl.productDelete(productid);
    }

    @RequestMapping(value = "/product/offers/{productid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OfferRequest> productOffers(@PathVariable("productid") Integer id) {

        return productBl.productOffers(id);
    }

    @RequestMapping(value = "/manager/{personId}/products", params = {"search", "page", "size"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<ProductResponse> getproductlistsearch(@RequestParam("search") String product, @RequestParam("page") Integer page, @RequestParam("size") Integer size, @PathVariable("personId") Integer personId) {
        String a = product + "%";
        return productBl.listproductsearch(a, personId, page, size);
    }

    @RequestMapping(value = "/product", params = {"page", "size"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<ProductResponse> findPaginated(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return productBl.findPaginated(page, size);
    }

    @RequestMapping(value = "/manager/{personId}/product/{productId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductRequest updateproduct(@RequestBody ProductRequest productRequest, @PathVariable("personId") Integer per, @PathVariable("productId") Integer productId) {

        return productBl.update(productRequest, per, productId);
    }
}
