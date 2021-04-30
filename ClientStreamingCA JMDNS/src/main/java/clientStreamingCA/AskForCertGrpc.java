package clientStreamingCA;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * new service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: cs.proto")
public final class AskForCertGrpc {

  private AskForCertGrpc() {}

  public static final String SERVICE_NAME = "AskForCert";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<clientStreamingCA.CRequest,
      clientStreamingCA.CResponse> getDoCertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DoCert",
      requestType = clientStreamingCA.CRequest.class,
      responseType = clientStreamingCA.CResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<clientStreamingCA.CRequest,
      clientStreamingCA.CResponse> getDoCertMethod() {
    io.grpc.MethodDescriptor<clientStreamingCA.CRequest, clientStreamingCA.CResponse> getDoCertMethod;
    if ((getDoCertMethod = AskForCertGrpc.getDoCertMethod) == null) {
      synchronized (AskForCertGrpc.class) {
        if ((getDoCertMethod = AskForCertGrpc.getDoCertMethod) == null) {
          AskForCertGrpc.getDoCertMethod = getDoCertMethod = 
              io.grpc.MethodDescriptor.<clientStreamingCA.CRequest, clientStreamingCA.CResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "AskForCert", "DoCert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientStreamingCA.CRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientStreamingCA.CResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AskForCertMethodDescriptorSupplier("DoCert"))
                  .build();
          }
        }
     }
     return getDoCertMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AskForCertStub newStub(io.grpc.Channel channel) {
    return new AskForCertStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AskForCertBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AskForCertBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AskForCertFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AskForCertFutureStub(channel);
  }

  /**
   * <pre>
   * new service
   * </pre>
   */
  public static abstract class AskForCertImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * client streaming
     * each service has a Request and a Response
     * </pre>
     */
    public io.grpc.stub.StreamObserver<clientStreamingCA.CRequest> doCert(
        io.grpc.stub.StreamObserver<clientStreamingCA.CResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getDoCertMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDoCertMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                clientStreamingCA.CRequest,
                clientStreamingCA.CResponse>(
                  this, METHODID_DO_CERT)))
          .build();
    }
  }

  /**
   * <pre>
   * new service
   * </pre>
   */
  public static final class AskForCertStub extends io.grpc.stub.AbstractStub<AskForCertStub> {
    private AskForCertStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AskForCertStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AskForCertStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AskForCertStub(channel, callOptions);
    }

    /**
     * <pre>
     * client streaming
     * each service has a Request and a Response
     * </pre>
     */
    public io.grpc.stub.StreamObserver<clientStreamingCA.CRequest> doCert(
        io.grpc.stub.StreamObserver<clientStreamingCA.CResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getDoCertMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * new service
   * </pre>
   */
  public static final class AskForCertBlockingStub extends io.grpc.stub.AbstractStub<AskForCertBlockingStub> {
    private AskForCertBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AskForCertBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AskForCertBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AskForCertBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * new service
   * </pre>
   */
  public static final class AskForCertFutureStub extends io.grpc.stub.AbstractStub<AskForCertFutureStub> {
    private AskForCertFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AskForCertFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AskForCertFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AskForCertFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_DO_CERT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AskForCertImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AskForCertImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DO_CERT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.doCert(
              (io.grpc.stub.StreamObserver<clientStreamingCA.CResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AskForCertBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AskForCertBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return clientStreamingCA.Cs.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AskForCert");
    }
  }

  private static final class AskForCertFileDescriptorSupplier
      extends AskForCertBaseDescriptorSupplier {
    AskForCertFileDescriptorSupplier() {}
  }

  private static final class AskForCertMethodDescriptorSupplier
      extends AskForCertBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AskForCertMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AskForCertGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AskForCertFileDescriptorSupplier())
              .addMethod(getDoCertMethod())
              .build();
        }
      }
    }
    return result;
  }
}
