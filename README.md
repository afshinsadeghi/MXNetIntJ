## Description 

This is a  Maven SCALA project to work with MXNet in MacOS and IntelliJ IDE

## Installation Notes: 

### 

1.MXNet double binding problem(https://www.slf4j.org/codes.html) can be resolved by removing one of binded classes in the 
included libraries.

### 

2. Included MXnet for maven in po.xml is version mxnet-full_2.10-osx-x86_64-cpu
This verison requires opencv version 2.4.13
For that in MacOS instead of  brew install  opencv@2
execute
brew install  opencv@2 

If you have already installed opencv version 3 unlink that using brew unlink and link the opencv version 2 aftwrwards.


###

Scala MXNet Tutorials

https://mxnet.incubator.apache.org/api/scala/

Scala MXNet examples

https://github.com/apache/incubator-mxnet/tree/master/scala-package/examples/src/main/scala/ml/dmlc/mxnetexamples
more 

