/*package clientStreamingCA;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import cSJmDNS.SimpleServiceRegistration;
import clientStreamingCA.AskForCertGrpc.AskForCertImplBase;
import io.grpc.BindableService;
import io.grpc.ClientStreamTracer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ServerCStream extends AskForCertGrpc.AskForCertImplBase {
	
	private static final Logger logger = Logger.getLogger(ServerCStream.class.getName());
	
	public static void main (String[] args) throws InterruptedException, IOException {
		
		System.out.println("Hello gRPC");
		//JOHN'S JMDNS
	//	ServerCStream serverCS = new ServerCStream();

		int port = 50053;
		String service_type = "_grpc2._tcp.local.";
		String service_name = "GrpcServer2";
		SimpleServiceRegistration ssr2 = new SimpleServiceRegistration();
		ssr2.run(port, service_type ,service_name);

	    
		try {
			Server server = ServerBuilder.forPort(port)
			    .addService(new ClientStreamingCAImpl())
			    .build()
			    .start();
			System.out.println("\nServer for ClientStreaming Started");
			
			 server.awaitTermination();

			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    logger.info("Server started, listening on " + port);
	    		    
	   
	}
	
	//end of John's jmDNS
	
	 static class ClientStreamingCAImpl extends AskForCertGrpc.AskForCertImplBase{
		
		public StreamObserver<CRequest> doCert(StreamObserver<CResponse> responseObserver){
			StreamObserver<CRequest> requestObserver = new StreamObserver<CRequest>() {
				
				String confirmation = " ";

				@Override
				public void onNext(CRequest value) {
					// Client sends a message
					// every time a client sends a message,it will receive this confirmation
					// this is the only message the client will receive
					confirmation += "Hello "  + value.getCourse() + " is confirmed ";
				}

				@Override
				public void onError(Throwable t) {
					// Client sends an error
					
				}

				@Override
				public void onCompleted() {
					// client is done
					// here, the server will return a response to the client
					responseObserver.onNext(CResponse.newBuilder().setConfirmation(confirmation).build());
					// this is when want to return a response (respondeObserver)
				responseObserver.onCompleted();	
				}
				
			};
			
			
			
			return requestObserver;
			
		}
		
	
		
		
	}// end of class AskForCertGrpcImpl

}// end of ServerCStream*/

 package clientStreamingCA;

import java.io.IOException;

import cSJmDNS.SimpleServiceRegistration;
import clientStreamingCA.AskForCertGrpc.AskForCertImplBase;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ServerCStream {
	
	public static void main (String[] args) throws InterruptedException, IOException {
		System.out.println("Hello gRPC");
		
		int port = 50051;
		String service_type = "_grpc2._tcp.local.";
		String service_name = "GrpcServer2";
		SimpleServiceRegistration ssr2 = new SimpleServiceRegistration();
		ssr2.run(port, service_type ,service_name);

		
	try {
		Server server = ServerBuilder.forPort(50051)
				.addService(new ClientStreamingCAImpl()).build();
			
			server.start();
	
	Runtime.getRuntime().addShutdownHook(new Thread(() -> {
		System.out.println(" Received Shutdown Request");
		server.shutdown();
		System.out.println("Successfully stopped the server");
		
	}));
	
	server.awaitTermination();
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		
	}// end of main method
	
	static class ClientStreamingCAImpl extends AskForCertGrpc.AskForCertImplBase{
		
		public StreamObserver<CRequest> doCert(StreamObserver<CResponse> responseObserver){
			StreamObserver<CRequest> requestObserver = new StreamObserver<CRequest>() {
				
				String confirmation = " ";

				@Override
				public void onNext(CRequest value) {
					// Client sends a message
					// every time a client sends a message,it will receive this confirmation
					// this is the only message the client will receive
					confirmation += "Hello "  + value.getCourse() + " is confirmed ";
				}

				@Override
				public void onError(Throwable t) {
					// Client sends an error
					
				}

				@Override
				public void onCompleted() {
					// client is done
					// here, the server will return a response to the client
					responseObserver.onNext(CResponse.newBuilder().setConfirmation(confirmation).build());
					// this is when want to return a response (respondeObserver)
				responseObserver.onCompleted();	
				}
				
			};
			
			
			
			return requestObserver;
			
		}
		
	
		
		
	}// end of class AskForCertGrpcImpl

}// end of ServerCStream

 
