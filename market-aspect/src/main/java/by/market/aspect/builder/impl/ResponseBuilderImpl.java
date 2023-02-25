package by.market.aspect.builder.impl;

import by.market.api.contract.IStatus;
import by.market.api.contract.ResponsePayload;
import by.market.api.contract.Status;
import by.market.aspect.builder.ResponseBuilder;
import by.market.aspect.builder.StatusBuilder;
import by.market.aspect.records.CatcherMetadata;
import by.market.core.ResultCode;
import by.market.exception.ApiException;
import by.market.exception.utils.LocaleUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class ResponseBuilderImpl implements ResponseBuilder {

    private final StatusBuilder statusBuilder;

    @Override
    public <T> ResponsePayload<T> buildSuccessful(final T data,
                                                  final ResultCode resultCode,
                                                  final CatcherMetadata metadata) {
        final var status = statusBuilder.buildSuccessful(resultCode);

        return new ResponsePayload<T>(
                metadata.getRqId(),
                status,
                metadata.getSourceSystem(),
                metadata.getSourcePerformer(),
                data
        );
    }

    @Override
    public ResponsePayload<?> buildThrowable(final Throwable exception,
                                             final CatcherMetadata metadata) {
        final var resultStatus = statusBuilder.buildThrowable(exception);

        return new ResponsePayload<>(
                metadata.getRqId(),
                resultStatus,
                metadata.getSourceSystem(),
                metadata.getSourcePerformer(),
                null
        );
    }

    @Override
    public <T extends ApiException> ResponsePayload<?> buildThrowable(final T apiException,
                                                                      final CatcherMetadata metadata) {
        final var resultStatus = statusBuilder.buildThrowable(apiException);

        return new ResponsePayload<T>(
                metadata.getRqId(),
                resultStatus,
                metadata.getSourceSystem(),
                metadata.getSourcePerformer(),
                null
        );
    }

}
