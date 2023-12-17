package solving

fun main() {
    class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {

        val foodsIndex = mutableMapOf<String, Int>().apply {
            for (i in foods.indices) {
                this[foods[i]] = i
            }
        }

        val foodsList = mutableListOf<Food>().apply {
            for (i in foods.indices) {
                this.add(Food(foods[i], cuisines[i], ratings[i]))
            }
        }

        val cuisineFoods = mutableMapOf<String, MutableList<Food>>().apply {
            foodsList.forEach {
                if (this.contains(it.cuisine)) {
                    this[it.cuisine]!!.add(it)
                } else {
                    this[it.cuisine] = mutableListOf(it)
                }
            }
        }

        inner class Food(
            val name: String,
            val cuisine: String,
            var rating: Int
        )

        fun changeRating(food: String, newRating: Int) {
            foodsList[foodsIndex[food]!!].rating = newRating
        }

        fun highestRated(cuisine: String): String {
            val highestRating = cuisineFoods[cuisine]!!.maxBy { it.rating }.rating
            return cuisineFoods[cuisine]!!.filter { it.rating == highestRating }.minBy { it.name }.name
        }
    }
}
