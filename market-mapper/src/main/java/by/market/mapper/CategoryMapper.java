package by.market.mapper;

import by.market.domain.system.Category;
import by.market.records.system.CategoryRecord;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface CategoryMapper extends MapstructMapper<CategoryRecord, Category> {

    @Override
    @Mapping(source = "parentCategory.id", target = "parent")
    CategoryRecord toMap(Category category);

    @Override
    @InheritInverseConfiguration
    Category fromMap(CategoryRecord categoryDTO);
}
