/**
  * Created by afshin on 02.09.17.
  */

package MXNet

import ml.dmlc.mxnet._
import ml.dmlc.mxnet.optimizer.SGD


object MXNetTest {

  def main(args: Array[String]) = {
    val a = NDArray.zeros(100, 50)
    val aux = NDArray.zeros(11886, 916, 11285)
    println("made a big matrix!")
    System.exit(1)
  }
}

