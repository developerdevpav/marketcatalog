package by.market.exception.i18

import org.springframework.context.i18n.LocaleContextHolder
import java.util.*

open class LocalProperties {

    companion object {

        fun getMessageForLocale(group: String, key: String): String {
            return ResourceBundle.getBundle(group, LocaleContextHolder.getLocale()).getString(key)
        }

    }

}
