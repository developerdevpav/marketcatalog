package by.market.mapper;

import by.market.domain.units.UnitEntity;
import by.market.records.UnitEntityRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.UUID;

import static java.util.Objects.isNull;

@Mapper(config = MapperConfiguration.class)
public interface UnitEntityMapper extends MapstructMapper<UnitEntityRecord, UnitEntity> {

    @Mappings({
            @Mapping(source = "unitGroup.id", target = "unitGroup")
    })
    UnitEntityRecord toMap(UnitEntity entity);

    @Mappings({
            @Mapping(target = "unitGroup", qualifiedByName = "convertGroupUnit")
    })
    UnitEntity fromMap(UnitEntityRecord tdto);

    @Named("convertGroupUnit")
    default UnitEntity convert(UUID id) {
        if (isNull(id)) {
            return null;
        }

        UnitEntity unitEntity = new UnitEntity();

        unitEntity.setId(id);

        return unitEntity;
    }

}
