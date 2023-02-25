package by.market.core

enum class ResultCode(val localCode: String, val code: Int, val type: ResultType) {

    SUCCESSFUL("messages.successful", 0, ResultType.SUCCESS),

    DATA_NOT_FOUND("messages.data_not_found", -404, ResultType.ERROR),

    UNKNOWN_ERROR("messages.unknown_error", -500, ResultType.ERROR),

    VALIDATION_ERROR("messages.validation_error", -100, ResultType.ERROR),
    ;

    companion object {

        fun findByCode(code: Int): ResultCode? {
            return ResultCode.values().find { resultCode -> resultCode.code == code }
        }

    }

}