package by.market.aspect.catcher;

import by.market.api.contract.*;
import by.market.aspect.builder.ResponseBuilder;
import by.market.aspect.records.CatcherMetadata;
import by.market.aspect.service.MethodArgumentSearcher;
import by.market.aspect.annotation.ReqArg;
import by.market.core.ResultCode;
import by.market.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Objects;
import java.util.Optional;

@Aspect
@Service
@RequiredArgsConstructor
public class CatcherAspect {

    private final MethodArgumentSearcher methodArgumentSearcher;

    private final ResponseBuilder responseBuilder;

    @Around(value = "@annotation(by.market.aspect.catcher.annotation.Catcher)")
    public Object catching(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final var signature = (MethodSignature) proceedingJoinPoint.getSignature();

        final var method = signature.getMethod();
        final var parameters = method.getParameters();
        final var joinPointArgs = proceedingJoinPoint.getArgs();

        final var argument = methodArgumentSearcher.findByAnnotation(parameters, joinPointArgs, ReqArg.class);

        final var metadata = this.getMetadata(argument);

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
            final ResultCode resultCode = Optional.ofNullable(response.getStatus())
                    .map(IStatus::getCode)
                    .map(ResultCode.Companion::findByCode)
                    .orElse(ResultCode.SUCCESSFUL);

            return responseBuilder.buildSuccessful(response.getPayload(), resultCode, metadata);
        }

        return proceed;
    }

    private CatcherMetadata getMetadata(final Object object) {
        CatcherMetadata.CatcherMetadataBuilder builder = CatcherMetadata.builder();
        if (object instanceof final IRequest request) {
            builder.locale(request.getLocal()).rqId(request.getRqId());
        }
        return builder.build();
    }

}
