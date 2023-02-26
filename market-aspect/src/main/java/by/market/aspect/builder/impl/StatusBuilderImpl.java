package by.market.aspect.builder.impl;

import by.market.aspect.builder.StatusBuilder;
import by.market.core.ResultCode;
import by.market.exception.ApiException;
import by.market.exception.utils.LocaleUtils;
import market.api.contract.IStatus;
import market.api.contract.Status;
import org.springframework.stereotype.Component;

@Component
public class StatusBuilderImpl implements StatusBuilder {

    @Override
    public IStatus buildSuccessful(final ResultCode resultCode) {
        return new Status(
                resultCode.getCode(),
                LocaleUtils.Companion.localeMessage(resultCode),
                null
        );
    }

    @Override
    public IStatus buildThrowable(final Throwable throwable) {
        return new Status(
                ResultCode.UNKNOWN_ERROR.getCode(),
                LocaleUtils.Companion.localeMessage(ResultCode.UNKNOWN_ERROR),
                throwable.getMessage()
        );
    }

    @Override
    public <E extends ApiException> IStatus buildThrowable(E apiException) {
        return new Status(
                apiException.getCode().getCode(),
                LocaleUtils.Companion.localeMessage(apiException.getCode()),
                LocaleUtils.Companion.localeDescriptionWithThrowable(apiException)
        );
    }

}
