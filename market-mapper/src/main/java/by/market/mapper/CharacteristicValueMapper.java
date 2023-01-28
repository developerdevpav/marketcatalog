package by.market.mapper;

import by.market.domain.characteristics.AbstractCharacteristic;
import by.market.records.characteristics.AbstractCharacteristicRecord;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface CharacteristicValueMapper extends MapstructMapper<AbstractCharacteristicRecord<Object>, AbstractCharacteristic<Object>> {

    @Override
    @Mapping(source = "characteristic.id", target = "characteristic")
    @Mapping(source = "product.id", target = "product")
    AbstractCharacteristicRecord<Object> toMap(AbstractCharacteristic<Object> objectAbstractCharacteristic);

    @Override
    @InheritInverseConfiguration
    AbstractCharacteristic<Object> fromMap(AbstractCharacteristicRecord<Object> objectAbstractCharacteristicDTO);

}
