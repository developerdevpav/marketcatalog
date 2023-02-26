package by.market.aspect.builder.impl;

import by.market.aspect.builder.ResponseBuilder;
import by.market.aspect.builder.StatusBuilder;
import by.market.aspect.records.CatcherMetadata;
import by.market.core.ResultCode;
import by.market.exception.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import market.api.contract.ResponsePayload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ResponseBuilderImpl implements ResponseBuilder {

    private final StatusBuilder statusBuilder;

    @Override
    public <T> ResponsePayload<T> buildSuccessful(final T payload,
                                                  final ResultCode resultCode,
                                                  final CatcherMetadata metadata) {
        final var resultStatus = statusBuilder.buildSuccessful(resultCode);

        return ResponsePayload.<T>builder()
                .payload(payload)
                .rqId(metadata.getRqId())
                .sourceSystem(metadata.getSourceSystem())
                .sourcePerformer(metadata.getSourcePerformer())
                .status(resultStatus)
                .build();
    }

    @Override
    public ResponsePayload<?> buildThrowable(final Throwable exception, final CatcherMetadata metadata) {
        final var resultStatus = statusBuilder.buildThrowable(exception);

        return ResponsePayload.builder()
                .payload(null)
                .rqId(metadata.getRqId())
                .sourceSystem(metadata.getSourceSystem())
                .sourcePerformer(metadata.getSourcePerformer())
                .status(resultStatus)
                .build();
    }

    @Override
    public <T extends ApiException> ResponsePayload<?> buildThrowable(final T apiException,
                                                                      final CatcherMetadata metadata) {
        final var resultStatus = statusBuilder.buildThrowable(apiException);

        return ResponsePayload.builder()
                .payload(null)
                .rqId(metadata.getRqId())
                .sourceSystem(metadata.getSourceSystem())
                .sourcePerformer(metadata.getSourcePerformer())
                .status(resultStatus)
                .build();
    }

}
