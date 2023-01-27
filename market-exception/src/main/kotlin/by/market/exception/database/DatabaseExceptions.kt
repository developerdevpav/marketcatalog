package by.market.exception.database

interface DatabaseException {

    fun getMsg(): String

    fun getCode(): Int

}

open class EntityNotFoundException(
        override val message: String,
        private val code: Int = 404
) : java.lang.RuntimeException(message), DatabaseException {

    override fun getCode(): Int = code

    override fun getMsg(): String = message

}

open class RequestInNotValidException(
        override val message: String,
        private val code: Int = 400
) : java.lang.RuntimeException(message), DatabaseException {

    override fun getCode(): Int = code

    override fun getMsg(): String = message

}
