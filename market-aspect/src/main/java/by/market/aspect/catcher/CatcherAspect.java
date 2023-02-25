package by.market.aspect.catcher;

import by.market.api.contract.IResponsePayload;
import by.market.api.contract.IStatus;
import by.market.aspect.annotation.ReqArg;
import by.market.aspect.builder.ResponseBuilder;
import by.market.aspect.service.CatcherMetadataBuilder;
import by.market.aspect.service.MethodArgumentSearcher;
import by.market.core.ResultCode;
import by.market.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Aspect
@Service
@RequiredArgsConstructor
public class CatcherAspect {

    private final MethodArgumentSearcher methodArgumentSearcher;

    private final ResponseBuilder responseBuilder;

    private final CatcherMetadataBuilder catcherMetadataBuilder;

    @Around(value = "@annotation(by.market.aspect.catcher.annotation.Catcher)")
    public Object catching(final ProceedingJoinPoint proceedingJoinPoint) {
        final var signature = (MethodSignature) proceedingJoinPoint.getSignature();

        final var method = signature.getMethod();
        final var parameters = method.getParameters();
        final var joinPointArgs = proceedingJoinPoint.getArgs();

        final var argument = methodArgumentSearcher.findByAnnotation(parameters, joinPointArgs, ReqArg.class);

        final var metadata = catcherMetadataBuilder.build(argument);

        Object proceed;

        try {
            proceed = proceedingJoinPoint.proceed(joinPointArgs);
        } catch (ApiException ex) {
            return responseBuilder.buildThrowable(ex, metadata);
        } catch (Throwable throwable) {
            return responseBuilder.buildThrowable(throwable, metadata);
        }

        if (Objects.isNull(proceed)) {
            return responseBuilder.buildSuccessful(null, ResultCode.SUCCESSFUL, metadata);
        }

        if (proceed instanceof final IResponsePayload<?> response) {
            final var resultCode = this.getCodeOrDefault(response.getStatus(), ResultCode.SUCCESSFUL);
            return responseBuilder.buildSuccessful(response.getPayload(), resultCode, metadata);
        }

        return proceed;
    }

    private ResultCode getCodeOrDefault(final IStatus status, final ResultCode defaultStatus) {
        return Optional.of(status)
                .map(IStatus::getCode)
                .map(ResultCode.Companion::findByCode)
                .orElse(ResultCode.SUCCESSFUL);
    }

}
