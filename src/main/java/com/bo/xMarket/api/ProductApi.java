package com.bo.xMarket.api;

import com.bo.xMarket.bl.ProductBl;
import com.bo.xMarket.bl.TransactionBl;
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
@RequestMapping(value = "") // TODO: change mapping to "products"
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
    } // TODO: Move to ManagerApi

    @RequestMapping(value = "/user/{userid}/branchOffice/{branchoffice}/category/{categoryid}", params = {"page", "size"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> productsbycategory(@PathVariable("userid") Integer id, @PathVariable("branchoffice") Integer idbranch, @PathVariable("categoryid") Integer idcategory, @RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return productBl.productListbyCategory(id, idbranch, idcategory, page, size);
    } // TODO: Move to UserApi :c

    @RequestMapping(value = "/user/{userid}/branchOffice/{branchoffice}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> productsbycategory(@PathVariable("userid") Integer id, @PathVariable("branchoffice") Integer idbranch) {
        return productBl.productListbyBranchId(id, idbranch);
    } // TODO: Change method name

    @RequestMapping(value = "/manager/{personId}/product", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product addProduct(@PathVariable("personId") Integer managerId, @RequestBody ProductRequest productRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        return productBl.addProduct(managerId, productRequest, transaction);
    }

    @RequestMapping(value = "/product/{productid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductSpecificResponse productInfo(@PathVariable("productid") Integer id) {
        return productBl.productInfo(id);
    }

    @RequestMapping(value = "/product/{productid}/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void productDelete(@PathVariable("productid") Integer productid, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        productBl.productDelete(productid);
    }

    @RequestMapping(value = "/manager/{personId}/products", params = {"search", "page", "size"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<ProductResponse> getproductlistsearch(@RequestParam("search") String product, @RequestParam("page") Integer page, @RequestParam("size") Integer size, @PathVariable("personId") Integer personId) {
        String a = product + "%";
        return productBl.listproductsearch(a, personId, page, size);
    } // TODO: Move to ManagerApi

    @RequestMapping(value = "/product", params = {"page", "size"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<ProductResponse> findPaginated(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return productBl.findPaginated(page, size);
    }

    @RequestMapping(value = "/manager/{personId}/product/{productId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductRequest updateproduct(@RequestBody ProductRequest productRequest, @PathVariable("personId") Integer personId, @PathVariable("productId") Integer productId) {
        return productBl.update(productRequest, personId, productId);
    } // TODO: Move to ManagerApi

    @RequestMapping(value = "/product/branchOffice/{idbranch}/category/{idcategory}", params = {"search", "page", "size"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> searchformovil(@RequestParam("search") String product, @RequestParam("page") Integer page, @RequestParam("size") Integer size, @PathVariable("idcategory") Integer categoryId, @PathVariable("idbranch") Integer branchId) {
        String a = product + "%";
        return productBl.searchmovil(a, categoryId, branchId, page, size);
    }

    @RequestMapping(value = "/product/qr/hash", params = {"hash"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse findProductByHash(@RequestParam("hash") String hash) {
        return productBl.findProductByHash(hash);
    }
}
