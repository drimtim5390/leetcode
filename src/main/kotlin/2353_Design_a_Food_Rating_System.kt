import java.util.TreeSet

class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {

    data class RatingItem(val food: String, val rating: Int)

    private val foodToCuisineMap = mutableMapOf<String, String>()
    private val itemMap = mutableMapOf<String, Int>()
    private val ratingMap = mutableMapOf<String, TreeSet<RatingItem>>()

    init {
        for (i in 0 until foods.size) {
            val currentFood = foods[i]
            val cuisine = cuisines[i]
            val rating = ratings[i]

            itemMap[currentFood] = rating

            foodToCuisineMap[currentFood] = cuisine


            if (!ratingMap.containsKey(cuisine)) {
                ratingMap[cuisine] = TreeSet<RatingItem>({ a, b ->
                    if (a.rating == b.rating) {
                        a.food.compareTo(b.food)
                    } else {
                        b.rating.compareTo(a.rating)
                    }
                })
            }
            ratingMap[cuisine]!!.add(RatingItem(currentFood, rating))
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val cuisine = foodToCuisineMap[food]!!
        val oldRating = itemMap[food]!!
        ratingMap[cuisine]!!.remove(RatingItem(food, oldRating))
        itemMap[food] = newRating
        ratingMap[cuisine]!!.add(RatingItem(food, newRating))
    }

    fun highestRated(cuisine: String): String {
        val topRated = ratingMap[cuisine]!!
        val top = topRated.first()!!
        return top.food
    }
}
