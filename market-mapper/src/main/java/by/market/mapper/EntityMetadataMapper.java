package by.market.mapper;


import by.market.domain.system.EntityMetadata;
import by.market.records.system.EntityMetadataRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class, uses = ContainerMetadataMapper.class)
public interface EntityMetadataMapper extends MapstructMapper<EntityMetadataRecord, EntityMetadata> {

    @Override
    @Mapping(source = "container.id", target = "container")
    EntityMetadataRecord toMap(EntityMetadata entityMetadata);

    @Override
    @Mapping(source = "container", target = "container.id")
    EntityMetadata fromMap(EntityMetadataRecord entityMetadataDTO);

}
