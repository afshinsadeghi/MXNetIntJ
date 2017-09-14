package TransE

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object Main extends App{

  Logger.getLogger("org").setLevel(Level.OFF)
  Logger.getLogger("akka").setLevel(Level.OFF)

    println( "Hello World!" )
    
    
    val sk = SparkSession.builder().master("local").appName("TransE").getOrCreate()
    
    val dataset = new LoadTriples("../resources/valid.txt",
                                  "\t",
                                  "false",
                                  sk)
                                  
    for(i <- 1 to 100)
    {
      println(UniformRVG.rand(-2,3))
    }


}
