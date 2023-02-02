package by.market.core

enum class ResultCode(val localCode: String, val code: Int) {

    SUCCESSFUL("messages.successful", 0),

    DATA_NOT_FOUND("messages.data_not_found", -404),

    UNKNOWN_ERROR("messages.unknown_error", -500),

    VALIDATION_ERROR("messages.validation_error", -100)

}