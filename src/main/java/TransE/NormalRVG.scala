package TransE

import scala.util.Random

object NormalRVG {
  val seed = new Random(System.currentTimeMillis())      
  def rand(mean : Double, sdt: Double) = { mean + seed.nextGaussian()*sdt   } 

}