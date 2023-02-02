package by.market.exception.i18

import java.util.*

open class LocalProperties {

    companion object {

        fun getMessageForLocale(group: String, key: String, locale: Locale): String {
            return ResourceBundle.getBundle(group, locale).getString(key)
        }

    }

}
