package by.market.aspect.service.impl;

import by.market.api.contract.IRequest;
import by.market.aspect.records.CatcherMetadata;
import by.market.aspect.service.CatcherMetadataBuilder;
import org.springframework.stereotype.Component;

@Component
public class CatcherMetadataBuilderImpl implements CatcherMetadataBuilder {

    @Override
    public CatcherMetadata build(Object object) {
        final var builder = CatcherMetadata.builder();

        if (object instanceof final IRequest request) {
            builder.rqId(request.getRqId());
            builder.sourceSystem(request.getSourceSystem());
            builder.sourcePerformer(request.getSourcePerformer());
        }

        return builder.build();
    }

}
