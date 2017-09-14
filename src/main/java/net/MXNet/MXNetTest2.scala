/**
  * Created by afshin on 02.09.17.
  */
package net.MXNet

import ml.dmlc.mxnet._
import ml.dmlc.mxnet.optimizer.SGD


object MXNetTest2 {

  def main(args: Array[String]) = {

    val a = NDArray.zeros(100, 200)
    val b = NDArray.zeros(100, 200)
    // save list of NDArrays
    NDArray.save("/Users/afshin/Downloads/mxnetarray", Map("A" -> a, "B" -> b))
    // save dictionary of NDArrays to AWS S3
    //NDArray.save("s3://path/to/s3/array", Map("A" -> a, "B" -> b))
    // save list of NDArrays to hdfs.
    //NDArray.save("hdfs://path/to/hdfs/array", Array(a, b))
    val from_file = NDArray.load("/Users/afshin/Downloads/mxnetarray")
    //val from_s3 = NDArray.load("s3://path/to/s3/array")
    //val from_hdfs = NDArray.load("hdfs://path/to/hdfs/array")
    val data = Symbol.Variable("data")
    val fc1 = Symbol.FullyConnected(name = "fc1")()(Map("data" -> data, "num_hidden" -> 128))
    val act1 = Symbol.Activation(name = "relu1")()(Map("data" -> fc1, "act_type" -> "relu"))
    val fc2 = Symbol.FullyConnected(name = "fc2")()(Map("data" -> act1, "num_hidden" -> 64))
    val net = Symbol.SoftmaxOutput(name = "out")()(Map("data" -> fc2))
    //:type net
    //ml.dmlc.mxnet.Symbol
    System.exit(1)
  }
}


