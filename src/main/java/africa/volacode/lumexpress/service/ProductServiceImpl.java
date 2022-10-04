package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.dtos.request.AddProductRequest;
import africa.volacode.lumexpress.data.dtos.request.GetAllItemsRequest;
import africa.volacode.lumexpress.data.dtos.request.UpdateProductRequest;
import africa.volacode.lumexpress.data.dtos.response.AddProductResponse;
import africa.volacode.lumexpress.data.dtos.response.UpdateProductResponse;
import africa.volacode.lumexpress.data.models.Category;
import africa.volacode.lumexpress.data.models.Product;
import africa.volacode.lumexpress.data.repository.ProductRepository;
import africa.volacode.lumexpress.exception.ProductNotFoundException;
import africa.volacode.lumexpress.service.cloud.CloudService;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ModelMapper mapper = new ModelMapper();
    private final CloudService cloudService;
    @Override
    public AddProductResponse addProduct(AddProductRequest request) throws IOException {
       Product product = mapper.map(request, Product.class);
       product.getCategories().add(Category.valueOf(request.getProductCategory().toUpperCase(Locale.ROOT)));
       var imageUrl = cloudService.upload(request.getImage().getBytes(), ObjectUtils.emptyMap());
       log.info("cloudinary image url::{}",imageUrl);
       product.setImageUrl(imageUrl);
       Product savedProduct = productRepository.save(product);

       return buildCreateProductResponse(savedProduct);
    }

    private AddProductResponse buildCreateProductResponse(Product savedProduct) {
         return AddProductResponse.builder()
                 .code(201)
                 .productId(savedProduct.getId())
                 .message("product added successfully")
                 .build();    }

    @Override
    public UpdateProductResponse updateProductDetails(UpdateProductRequest request) {
       var foundProduct = productRepository.findById(request.getProductId()).orElseThrow(() -> new ProductNotFoundException(
               String.format("product with id %d not found", request.getProductId())
       ));

        return null;
    }

    @Override
    public Product getProductById(Long id) {
      return   productRepository.findById(id).orElseThrow(
              () -> new ProductNotFoundException(
                      String.format("Product with id %d not found ", id)));
//      if (foundProduct.isPresent()) return foundProduct.get();
//        throw new ProductNotFoundException(
//                String.format("product with id %d not found", id)
//        );
    }

    @Override
    public Page<Product> getAllProducts(GetAllItemsRequest getAllItemsRequest) {
        Pageable pageSpecs = PageRequest.of(getAllItemsRequest.getPageNumber()-1
                ,getAllItemsRequest.getNumberOfItemsPerPage()
        );
        Page<Product> products = productRepository.findAll(pageSpecs);
        return products;
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }
}
