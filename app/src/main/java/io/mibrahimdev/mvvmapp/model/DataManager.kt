package io.mibrahimdev.mvvmapp.model

/**
 * The DataManager acts as the model,
 * processing the data and containing the business logic.
 *
 * */
object DataManager {

    private val products: MutableMap<Int, Product>? =
        fakeProducts.associateBy { it.productId }.toMutableMap()

    fun retrieveProducts(): List<Product> {
        return products?.values?.toList().orEmpty()
    }

    fun updateFavorite(id: Int, isFavorite: Boolean, onSuccess: () -> Unit, onFailure: () -> Unit) {
        val product = products?.get(id)
        product?.copy(isFavorite = isFavorite)?.let { products?.put(id, it) }

        if (products?.get(id)?.isFavorite == isFavorite) {
            onSuccess()
        } else {
            onFailure()
        }
    }

    fun searchProducts(name: String): List<Product> {
        return products?.values?.filter { it.name.contains(name) }.orEmpty()
    }

}