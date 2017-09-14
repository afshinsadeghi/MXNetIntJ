package TransE

import org.apache.spark.sql.SparkSession

class TransE_Model (S : LoadTriples,
                    gamme : Double,
                    k  : Int,
                    spark : SparkSession) {
  


                    
  val E = S.subjects
  val L = S.predicates
  
  var lBold = Array.ofDim[Double](S.subjects.length, k)
  
  for(i <- 1 to S.subjects.length)
  {
    for(j <- 1 to k)
    {
      lBold(i)(j) = UniformRVG.rand(-6.0 / Math.sqrt(k), 6.0 / Math.sqrt(k))
    }
  }
  
  for(i <- 1 to S.subjects.length)
  {
    var sum : Double = 0
    for(j<- 1 to k )
    {
      sum += Math.pow( lBold(i)(j), 2.0 )
    }
    for(j<- 1 to k )
    {
      lBold(i)(j) /= Math.sqrt(sum) 
    }    
  }
  
  
  var eBold = Array.ofDim[Double](S.subjects.length, k)
  
  for(i <- 1 to S.subjects.length)
  {
    for(j <- 1 to k)
    {
      eBold(i)(j) = UniformRVG.rand(-6.0 / Math.sqrt(k), 6.0 / Math.sqrt(k))
    }
  }
  
  for(i <- 1 to S.subjects.length)
  {
    var sum : Double = 0
    for(j<- 1 to k )
    {
      sum += Math.pow( eBold(i)(j), 2.0 )
    }
    for(j<- 1 to k )
    {
      eBold(i)(j) /= Math.sqrt(sum) 
    }    
  }
    
}