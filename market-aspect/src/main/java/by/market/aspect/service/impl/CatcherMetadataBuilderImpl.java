package by.market.aspect.service.impl;

import by.market.aspect.records.CatcherMetadata;
import by.market.aspect.service.CatcherMetadataBuilder;
import market.api.contract.IRequest;
import org.springframework.stereotype.Component;

@Component
public class CatcherMetadataBuilderImpl implements CatcherMetadataBuilder {

    @Override
    public CatcherMetadata build(Object object) {
        final var builder = CatcherMetadata.builder();

        if (object instanceof final IRequest request) {
            builder.rqId(request.getId())
                    .sourceSystem(request.getSourceSystem())
                    .sourcePerformer(request.getSourcePerformer());
        }

        return builder.build();
    }

}
