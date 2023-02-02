package by.market.exception.utils

import by.market.core.ResultCode
import by.market.exception.MarketCatalogThrowable
import by.market.exception.constants.BundleGroup
import by.market.exception.i18.LocalProperties

class LocaleUtils {

    companion object {

        fun localeMessage(resultCode: ResultCode): String {
            return LocalProperties.getMessageForLocale(BundleGroup.CODE_RESOURCE.value, resultCode.localCode)
        }

        fun localeDescriptionWithThrowable(throwable: MarketCatalogThrowable): String? {
            var messageDescription =
                if (throwable.getLocalizationCode().isNullOrEmpty()) {
                    null
                } else {
                    LocalProperties.getMessageForLocale(
                        BundleGroup.DESCRIPTION_RESOURCE.value,
                        throwable.getLocalizationCode()!!
                    )
                }

            if (messageDescription.isNullOrBlank()) {
                return messageDescription
            }

            throwable.getArgs().toList()
                .forEach {
                    if (messageDescription!!.contains("{}").not()) {
                        return@forEach
                    }
                    messageDescription = messageDescription!!.replaceFirst("{}", it.toString())
                }

            return messageDescription
        }

    }

}