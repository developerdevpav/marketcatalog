package by.market.aspect.builder.impl;

import by.market.aspect.builder.StatusBuilder;
import by.market.core.ResultCode;
import by.market.exception.ApiException;
import market.api.contract.IStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

@DisplayName("Component of building IStatus")
class StatusBuilderImplTest {

    private final StatusBuilder statusBuilder = new StatusBuilderImpl();

    @Test
    @DisplayName("Creating a successful response status")
    void buildSuccessful() {
        final IStatus resultStatus = statusBuilder.buildSuccessful(ResultCode.SUCCESSFUL);

        Assertions.assertEquals(ResultCode.SUCCESSFUL.getCode(), resultStatus.getCode());
    }

    @Test
    @DisplayName("Creating a response status with an unknown exception")
    void buildThrowable() {
        final var nullPointerException = new NullPointerException("Объект не может быть NULL");
        final IStatus resultStatus = statusBuilder.buildThrowable(nullPointerException);

        Assertions.assertEquals(nullPointerException.getMessage(), resultStatus.getDetails());
        Assertions.assertEquals(ResultCode.UNKNOWN_ERROR.getCode(), resultStatus.getCode());
    }

    @Test
    void testBuildThrowable() {
        final var apiException = new ApiException("unsupported_operation", new Object[0], ResultCode.DATA_NOT_FOUND);
        LocaleContextHolder.setDefaultLocale(Locale.ENGLISH);

        final IStatus resultStatus = statusBuilder.buildThrowable(apiException);

        Assertions.assertEquals(ResultCode.DATA_NOT_FOUND.getCode(), resultStatus.getCode());
    }
}