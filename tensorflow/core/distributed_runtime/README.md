# Distributed TensorFlow

This directory contains the initial open-source implementation of the
distributed TensorFlow runtime, using [gRPC](http://grpc.io) for inter-process
communication.

To learn how to use the distributed runtime to create a TensorFlow cluster,
see the [Distributed TensorFlow](https://www.tensorflow.org/deploy/distributed) How-To.

## gRPC service discovery via lookup file

If GRPC_LOOKUP_FILE environment variable is set, TensorFlow will treat 
addresses as ```<name>:<index>```.  It will resolve ```<name>:<index>``` to 
```<host>:<port>``` using lookup file.

Lookup file has format:
```
<name>:<index>=<host>:<port>
```