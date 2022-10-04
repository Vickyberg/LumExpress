package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.dtos.request.AddProductRequest;
import africa.volacode.lumexpress.data.dtos.request.GetAllItemsRequest;
import africa.volacode.lumexpress.data.dtos.request.UpdateProductRequest;
import africa.volacode.lumexpress.data.dtos.response.AddProductResponse;
import africa.volacode.lumexpress.data.dtos.response.UpdateProductResponse;
import africa.volacode.lumexpress.data.models.Product;
import org.springframework.data.domain.Page;

import java.io.IOException;


public interface ProductService {
    AddProductResponse addProduct(AddProductRequest request) throws IOException;
    UpdateProductResponse updateProductDetails(UpdateProductRequest request);
    Product getProductById(Long id);
    Page<Product> getAllProducts(GetAllItemsRequest getAllItemsRequest);
    String deleteProduct(Long id);
}
