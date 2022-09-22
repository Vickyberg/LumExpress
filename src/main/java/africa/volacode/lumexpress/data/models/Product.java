package africa.volacode.lumexpress.data.models;

import jdk.jfr.Category;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

public class Product {
    private Long id;
    private String name ;
    private BigDecimal price;
    private int quantity;
    private List<Category> category;
    private String imageUrl;

}
