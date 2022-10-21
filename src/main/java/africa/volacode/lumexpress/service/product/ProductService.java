package africa.volacode.lumexpress.service.product;

import africa.volacode.lumexpress.data.dtos.request.AddProductRequest;
import africa.volacode.lumexpress.data.dtos.request.GetAllItemsRequest;
import africa.volacode.lumexpress.data.dtos.request.UpdateProductRequest;
import africa.volacode.lumexpress.data.dtos.response.AddProductResponse;
import africa.volacode.lumexpress.data.dtos.response.UpdateProductResponse;
import africa.volacode.lumexpress.data.models.Product;
import africa.volacode.lumexpress.exception.ProductNotFoundException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.data.domain.Page;

import java.io.IOException;


public interface ProductService {
    AddProductResponse addProduct(AddProductRequest request) throws IOException;
    UpdateProductResponse updateProductDetails(Long productId, JsonPatch patch) throws JsonPatchException, ProductNotFoundException;
    Product getProductById(Long id) throws ProductNotFoundException;
    Page<Product> getAllProducts(GetAllItemsRequest getAllItemsRequest);
    String deleteProduct(Long id);
}
