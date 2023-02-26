package by.market.facade.impl

import by.market.domain.BaseEntity
import by.market.mapper.MapstructMapper
import by.market.records.BaseEntityRecord
import by.market.services.ISystemService

open class BaseSystemFacade<TDto : BaseEntityRecord, TEntity : BaseEntity, TService : ISystemService<TEntity>>
    (entityService: TService, mapper: MapstructMapper<TDto, TEntity>) :
    AbstractFacade<TService, TDto, TEntity>(entityService, mapper)
