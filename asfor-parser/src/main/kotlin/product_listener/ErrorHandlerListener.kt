@file:Suppress("EXPERIMENTAL_API_USAGE")

package product_listener

import abstraction.IProductListener
import org.jsoup.nodes.Document

class ErrorHandlerListener(private val listener: IProductListener) : IProductListener {
  override fun onLoadDocument(doc: Document, pageNumber: UInt) {
    try {
      listener.onLoadDocument(doc, pageNumber)
    } catch (e: Exception){
      println("Error 'onLoadDocument' - $e")
    }
  }

  override fun <TItem> onLoadPageItems(doc: Document, items: List<TItem>, pageNumber: UInt) {
    try {
      listener.onLoadPageItems(doc, items, pageNumber)
    } catch (e: Exception){
      println("Error 'onLoadPageItems' - $e")
    }
  }
}
