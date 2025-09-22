import java.util.TreeSet

class MovieRentingSystem(n: Int, entries: Array<IntArray>) {
    private data class Movie(val shop: Int, val movie: Int, val price: Int)

    private val movieToShop = mutableMapOf<Int, MutableMap<Int, Movie>>()
    private val movies = mutableMapOf<Int, TreeSet<Movie>>()
    private val rented = TreeSet<Movie>(compareBy<Movie> { it.price }.thenBy { it.shop }.thenBy { it.movie })

    init {
        entries.map { Movie(it[0], it[1], it[2]) }.forEach { mov ->
            if (!movieToShop.contains(mov.movie)) {
                movieToShop[mov.movie] = mutableMapOf<Int, Movie>()
            }
            if (!movies.contains(mov.movie)) {
                movies[mov.movie] = TreeSet(compareBy<Movie> { it.price }.thenBy { it.shop })
            }
            movieToShop[mov.movie]!![mov.shop] = mov
            movies[mov.movie]!!.add(mov)
        }
    }

    fun search(movie: Int): List<Int> {
        return movies[movie]?.take(5)?.map { it.shop } ?: emptyList()
    }

    fun rent(shop: Int, movie: Int) {
        val mov = movieToShop[movie]!![shop]!!
        movies[movie]!!.remove(mov)
        rented.add(mov)
    }

    fun drop(shop: Int, movie: Int) {
        val mov = movieToShop[movie]!![shop]!!
        movies[movie]!!.add(mov)
        rented.remove(mov)
    }

    fun report(): List<List<Int>> {
        return rented.take(5).map { arrayListOf(it.shop, it.movie) }
    }
}