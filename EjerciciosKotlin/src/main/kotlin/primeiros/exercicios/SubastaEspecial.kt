package primeiros.exercicios
fun main() {
    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")

}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    //if(bid!=null && bid.amount>0) return bid.amount else return minimumPrice
    //return bid?.let{if(it.amount<0) minimumPrice else it.amount} ?: minimumPrice
    return bid?.takeIf{it.amount > 0}?.amount ?: minimumPrice
}
