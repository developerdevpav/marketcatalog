package by.market.aspect.builder;

import by.market.aspect.records.CatcherMetadata;
import by.market.core.ResultCode;
import by.market.exception.ApiException;
import market.api.contract.ResponsePayload;

public interface ResponseBuilder {

    <T> ResponsePayload<T> buildSuccessful(final T data,
                                           final ResultCode resultCode,
                                           final CatcherMetadata metadata);

    ResponsePayload<?> buildThrowable(final Throwable exception,
                                      final CatcherMetadata metadata);

    <T extends ApiException> ResponsePayload<?> buildThrowable(final T apiException,
                                                               final CatcherMetadata metadata);

}
