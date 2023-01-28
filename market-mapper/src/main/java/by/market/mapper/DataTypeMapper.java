package by.market.mapper;

import by.market.domain.system.DataType;
import by.market.records.system.DataTypeRecord;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface DataTypeMapper extends MapstructMapper<DataTypeRecord, DataType> {
}
