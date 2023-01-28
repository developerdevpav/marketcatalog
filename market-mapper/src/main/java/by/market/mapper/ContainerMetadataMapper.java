package by.market.mapper;

import by.market.domain.system.ContainerMetadata;
import by.market.records.system.ContainerMetadataRecord;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface ContainerMetadataMapper extends MapstructMapper<ContainerMetadataRecord, ContainerMetadata> {
}
