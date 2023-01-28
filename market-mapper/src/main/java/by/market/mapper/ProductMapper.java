package by.market.mapper;

import by.market.domain.Product;
import by.market.records.product.ProductRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface ProductMapper extends MapstructMapper<ProductRecord, Product> {

    @Override
    @Mapping(source = "category.id", target = "category")
    ProductRecord toMap(Product product);

    @Override
    @Mapping(source = "category", target = "category.id")
    Product fromMap(ProductRecord productDTO);

}
