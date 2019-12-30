package by.market.resources.system.implementation.system

import by.market.facade.system.ContainerMetadataFacade
import by.market.mapper.dto.system.ContainerMetadataFrontEnd
import by.market.resources.system.implementation.BaseMutableResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/container-metadata")
class ContainerMetadataResource(facade: ContainerMetadataFacade)
    : BaseMutableResource<ContainerMetadataFrontEnd, ContainerMetadataFacade>(facade)
