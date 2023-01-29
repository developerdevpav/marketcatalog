package by.market.exception.utils

import by.market.exception.MarketCatalogThrowable
import by.market.exception.i18.LocalProperties
import java.util.*

class LocalizationExceptionUtils {

    companion object {

        private const val DESCRIPTION_RESOURCE = "description_message";

        fun throwDescription(locale: Locale, throwable: MarketCatalogThrowable): String? {
            if (throwable.isLocalization().not() || throwable.getDescription().isNullOrEmpty()) {
                return throwable.getDescription()
            }

            var messageDescription =
                LocalProperties.getMessageForLocale(DESCRIPTION_RESOURCE, throwable.getDescription()!!, locale)

            throwable.getArgs().toList()
                .forEach {
                    if (messageDescription.contains("{}").not()) {
                        return@forEach;
                    }
                    messageDescription = messageDescription.replaceFirst("{}", it.toString())
                }

            return messageDescription
        }
    }

}