package by.market.aspect.builder;

import by.market.core.ResultCode;
import by.market.exception.ApiException;
import market.api.contract.IStatus;

/**
 * The builder of response status
 */
public interface StatusBuilder {

    /**
     * The method build a success status by result code {@link ResultCode}
     *
     * @param resultCode result code
     * @return the status response
     */
    IStatus buildSuccessful(final ResultCode resultCode);

    /**
     * The method build a success status by throwable {@link Throwable}
     *
     * @param throwable exception
     * @return the status response
     */
    IStatus buildThrowable(final Throwable throwable);

    /**
     * The method build a success status by API throwable {@link ApiException}
     *
     * @param apiException API exception
     * @return the status response
     */
    <E extends ApiException> IStatus buildThrowable(final E apiException);

}
