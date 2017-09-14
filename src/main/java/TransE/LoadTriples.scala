package TransE

import org.apache.spark.sql.SparkSession

class LoadTriples (pathFile : String, 
                   columnSeperator : String,
                   header : String,
                   spark : SparkSession) {
  
  // responsible to load the training sets
  // a table with 3 columns, each line represent an example
  
  
  val dataframe = readFromFile()
  val (subjects,predicates) = (subject(), predicate())
  val triples = triplesToNumeric()
  val dim = getDimension()
  
  
  def readFromFile() = {
    spark.read.format("com.databricks.spark.csv")
            .option("header", header)
            .option("inferSchema", "false")
            .option("delimiter", columnSeperator)
            .load(pathFile)
  }
  
  def subject() = {
    val x = dataframe.select("_c0").collect.map(_.getString(0)) ++  // select the subject in the first column and having it as string  
        dataframe.select("_c2").collect.map(_.getString(0)) // adding the object in the third column
    
    x.distinct // remove the redundent elements in the list
  }
  
 def predicate() = {
    val x = dataframe.select("_c1").collect.map(_.getString(0))
    
    x.distinct
  }

  def getDimension() = {
    Array(subjects.length, predicates.length)
  } // allows the transformation of a Seq to a DataFrame in spark
  
  def triplesToNumeric() = {
    
    var aux = Seq[(Long, Long, Long)]()
    
    dataframe.collect().map {
      i => aux = aux :+ 
      (subjects.indexOf(i.getString(0)).toLong, 
       predicates.indexOf(i.getString(1)).toLong, 
       subjects.indexOf(i.getString(2)).toLong ) 
    }
    
    aux.toDF()
    
  }
  
  
  
}