package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.dtos.request.AddProductRequest;
import africa.volacode.lumexpress.data.dtos.request.GetAllItemsRequest;
import africa.volacode.lumexpress.data.dtos.request.UpdateProductRequest;
import africa.volacode.lumexpress.data.dtos.response.AddProductResponse;
import africa.volacode.lumexpress.data.dtos.response.UpdateProductResponse;
import africa.volacode.lumexpress.data.models.Product;
import africa.volacode.lumexpress.service.product.ProductService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jackson.jsonpointer.JsonPointerException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.ReplaceOperation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;
    AddProductRequest request;
    AddProductResponse response;

    @BeforeEach
    void setUp() throws IOException {
        Path path = Paths.get("C:\\Users\\Olamide\\Documents\\SpringBootProject\\lum-express\\src\\" +
                "main\\resources\\static\\peak.jpg");
        MultipartFile file = new MockMultipartFile("peak", Files.readAllBytes(path));
        request = buildGetProductRequest(file);
        response = productService.addProduct(request);
    }

    private AddProductRequest buildGetProductRequest(MultipartFile file) {
        return AddProductRequest.builder()
                .name("Milk")
                .productCategory("Beverages")
                .price(BigDecimal.valueOf(30.00))
                .quantity(10)
                .image(file)
                .build();
    }


    @Test
    void addProductTest() {


        assertThat(response).isNotNull();
        assertThat(response.getProductId()).isGreaterThan(0L);
        assertThat(response.getCode()).isEqualTo(201);
        assertThat(response.getMessage()).isNotNull();
    }

    @Test
    void updateProductDetailsTest() throws JsonPointerException, IOException, JsonPatchException {

        ObjectMapper mapper = new ObjectMapper();
        UpdateProductResponse updateResponse = null;
      try {
          JsonNode value = mapper.readTree("\"eggs\"");
          JsonPatch patch = new JsonPatch(List.of(new ReplaceOperation(
                  new JsonPointer("/name"),value
          )));
   updateResponse = productService.updateProductDetails(1L,patch);
      }catch (Exception e){
          e.printStackTrace();
      }

                    assertThat(updateResponse).isNotNull();
        assertThat(updateResponse.getStatusCode()).isEqualTo(200);
        assertThat(productService.getProductById(1L).getName()).isEqualTo("eggs");
    }

    private UpdateProductRequest buildUpdateRequest() {
        return UpdateProductRequest.builder()
                .price(BigDecimal.valueOf(40.00))
                .productId(1L)
                .description("its just milo")
                .quantity(10)
                .build();
    }

    @Test
    void getProductByIdTest()  {
       Product foundProduct = productService.getProductById(response.getProductId());
       assertThat(foundProduct).isNotNull();
       assertThat(foundProduct.getId()).isEqualTo(response.getProductId());
    }

    @Test
    void getAllProductsTest() throws IOException {
        productService.addProduct(request);
        var getItemsRequest = buildGetItemsRequest();
        Page<Product> productsPage = productService.getAllProducts(getItemsRequest);
        log.info("page contents :: {}",productsPage);
       assertThat(productsPage).isNotNull();
       assertThat(productsPage.getTotalElements()).isGreaterThan(0);
    }

    private GetAllItemsRequest buildGetItemsRequest() {
        return GetAllItemsRequest.builder()
                .numberOfItemsPerPage(8)
                .pageNumber(1)
                .build();
    }

    @Test
    void deleteProductTest() {
        assertThat(productService.deleteProduct(response.getProductId()));
        
    }
}