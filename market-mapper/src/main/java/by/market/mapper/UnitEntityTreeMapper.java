package by.market.mapper;

import by.market.nosql.TreeUnit;
import by.market.records.TreeUnitRecord;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface UnitEntityTreeMapper extends MapstructMapper<TreeUnitRecord, TreeUnit> {}
