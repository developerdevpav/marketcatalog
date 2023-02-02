package by.market.aspect.catcher.annotation;

import by.market.core.ResultCode;

public @interface ThrowMatcher {

    Class<Throwable> throwable();

    ResultCode code();

}
