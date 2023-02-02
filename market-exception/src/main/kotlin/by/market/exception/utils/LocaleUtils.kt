package by.market.exception.utils

import by.market.core.ResultCode
import by.market.exception.MarketCatalogThrowable
import by.market.exception.constants.BundleGroup
import by.market.exception.i18.LocalProperties
import java.util.*

class LocaleUtils {

    companion object {

        fun localeMessage(locale: by.market.core.Locale, resultCode: ResultCode): String {
            return LocalProperties.getMessageForLocale(
                BundleGroup.CODE_RESOURCE.value,
                resultCode.localCode,
                convertLocale(locale)
            )
        }

        fun localeDescriptionWithThrowable(locale: by.market.core.Locale, throwable: MarketCatalogThrowable): String? {
            if (throwable.isLocalization().not() || throwable.getDescription().isNullOrEmpty()) {
                return throwable.getDescription()
            }

            var messageDescription = LocalProperties.getMessageForLocale(
                BundleGroup.DESCRIPTION_RESOURCE.value,
                throwable.getDescription()!!,
                convertLocale(locale)
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

        fun convertLocale(locale: by.market.core.Locale): Locale {
            return when (locale) {
                by.market.core.Locale.RU -> Locale.getDefault()
                by.market.core.Locale.EN -> Locale.ENGLISH
            }
        }

    }

}