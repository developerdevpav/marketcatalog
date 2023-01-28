package by.market.mapper;

import by.market.domain.characteristics.single.StringCharacteristic;
import by.market.records.characteristics.StringCharacteristicRecord;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface StringCharacteristicMapper extends MapstructMapper<StringCharacteristicRecord, StringCharacteristic> {

    @Override
    @Mapping(source = "characteristic.id", target = "characteristic")
    @Mapping(source = "product.id", target = "product")
    StringCharacteristicRecord toMap(StringCharacteristic objectAbstractCharacteristic);

    @Override
    @InheritInverseConfiguration
    StringCharacteristic fromMap(StringCharacteristicRecord objectAbstractCharacteristicDTO);

}
