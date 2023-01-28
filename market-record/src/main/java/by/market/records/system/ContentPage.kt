package by.market.records.system

class ContentPage<T>(val content: MutableList<T>, val total: Long, val page: Int = 0, val size: Int = 10)