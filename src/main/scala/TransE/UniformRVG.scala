package TransE

import scala.util.Random

object UniformRVG {
  val seed = new Random(System.currentTimeMillis())      
  def rand(lowerBound : Double , upperBound: Double) = {  
    lowerBound + (upperBound-lowerBound) * seed.nextDouble()    
  }
}