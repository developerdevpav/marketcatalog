package by.market.aspect.builder.impl;

import by.market.api.contract.ResponsePayload;
import by.market.api.contract.Status;
import by.market.aspect.builder.ResponseBuilder;
import by.market.aspect.records.CatcherMetadata;
import by.market.core.ResultCode;
import by.market.exception.ApiException;
import by.market.exception.utils.LocaleUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ResponseBuilderImpl implements ResponseBuilder {

    @Override
    public <T> ResponsePayload<T> buildSuccessful(final T data,
                                                  final ResultCode resultCode,
                                                  final CatcherMetadata metadata) {
        final var response = new ResponsePayload<T>();

        response.setRqId(metadata.getRqId());
        response.setStatus(new Status(
                resultCode.getCode(),
                LocaleUtils.Companion.localeMessage(resultCode),
                null
        ));
        response.setPayload(data);

        return response;
    }

    @Override
    public ResponsePayload<?> buildThrowable(final Throwable exception,
                                             final CatcherMetadata metadata) {
        final var response = new ResponsePayload<>();

        response.setRqId(metadata.getRqId());
        response.setStatus(
                new Status(
                        ResultCode.UNKNOWN_ERROR.getCode(),
                        Objects.requireNonNull(LocaleUtils.Companion.localeMessage(ResultCode.UNKNOWN_ERROR)),
                        exception.getMessage()
                )
        );

        return response;
    }

    @Override
    public <T extends ApiException> ResponsePayload<?> buildThrowable(T apiException,
                                                                      final CatcherMetadata metadata) {
        final var response = new ResponsePayload<T>();

        response.setRqId(metadata.getRqId());
        response.setStatus(
                new Status(
                        ResultCode.UNKNOWN_ERROR.getCode(),
                        Objects.requireNonNull(LocaleUtils.Companion.localeMessage(ResultCode.UNKNOWN_ERROR)),
                        LocaleUtils.Companion.localeDescriptionWithThrowable(apiException)
                )
        );

        return response;
    }

}
