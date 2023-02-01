package by.market.aspect.catcher.annotation;

import by.market.exception.ResultCode;

public @interface ThrowMatcher {

    Class<Throwable> throwable();

    ResultCode code();

}
