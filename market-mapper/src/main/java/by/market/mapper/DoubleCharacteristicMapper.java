package by.market.mapper;

import by.market.domain.characteristics.single.DoubleCharacteristic;
import by.market.records.characteristics.DoubleCharacteristicRecord;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface DoubleCharacteristicMapper extends MapstructMapper<DoubleCharacteristicRecord, DoubleCharacteristic> {

    @Override
    @Mapping(source = "characteristic.id", target = "characteristic")
    @Mapping(source = "product.id", target = "product")
    DoubleCharacteristicRecord toMap(DoubleCharacteristic objectAbstractCharacteristic);

    @Override
    @InheritInverseConfiguration
    DoubleCharacteristic fromMap(DoubleCharacteristicRecord objectAbstractCharacteristicDTO);

}
