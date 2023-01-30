package by.market.exception.utils

import by.market.exception.MarketCatalogThrowable
import by.market.exception.constants.BundleGroup
import by.market.exception.i18.LocalProperties
import java.util.*

class LocalMessageUtils {

    companion object {

        fun throwText(locale: Locale, throwable: MarketCatalogThrowable): String? {
            if (throwable.isLocalization().not() || throwable.getDescription().isNullOrEmpty()) {
                return throwable.getDescription()
            }

            var messageDescription = LocalProperties.getMessageForLocale(
                BundleGroup.DESCRIPTION_RESOURCE.value,
                throwable.getDescription()!!,
                locale
            )

            throwable.getArgs().toList()
                .forEach {
                    if (messageDescription.contains("{}").not()) {
                        return@forEach
                    }
                    messageDescription = messageDescription.replaceFirst("{}", it.toString())
                }

            return messageDescription
        }

    }

}