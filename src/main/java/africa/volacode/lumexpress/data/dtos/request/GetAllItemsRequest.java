package africa.volacode.lumexpress.data.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductRequest {
    private int numberOfProductsPerPage;
    private int pageNumber;
    
}
