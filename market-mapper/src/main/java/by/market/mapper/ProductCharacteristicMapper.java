package by.market.mapper;

import by.market.domain.characteristics.Characteristic;
import by.market.records.characteristics.ProductCharacteristicRecord;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class, uses = DataTypeMapper.class)
public interface ProductCharacteristicMapper extends MapstructMapper<ProductCharacteristicRecord, Characteristic> {
}
