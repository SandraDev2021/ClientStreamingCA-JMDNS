/*package clientStreamingCA;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.ServiceInfo;

import cSJmDNS.SimpleServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class ClientCStream {
	
	private static final Logger logger = Logger.getLogger(ClientCStream.class.getName());
	
	public static void main (String[] args) throws InterruptedException {
		System.out.println("Hello, I'm a gRPC client");
		
		ServiceInfo serviceInfo;
		serviceInfo = SimpleServiceDiscovery.run();
		int port =50053; //serviceInfo.getPort();
		String host = "localhost";
		//int port = 50053;
		
		/*ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
			.usePlaintext()
			.build();*/
		
		
	/*ClientCStream main = new ClientCStream();
		main.run();
		
	}// end of main method

	private void run() throws InterruptedException {
	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
				.usePlaintext()
				.build();
	// call the function
	doClientCStreamingCall(channel);
	
	System.out.println("Shutting down channel");
	channel.shutdown();
		
	}// end of method run
	
	
	private void doClientCStreamingCall(ManagedChannel channel) throws InterruptedException {

		// create a client(stub) - asynchronous client
	AskForCertGrpc.AskForCertStub asyncClient = AskForCertGrpc.newStub(channel);
	try {	
		
		
		StreamObserver<CRequest> requestObserver = asyncClient.doCert(new StreamObserver<CResponse>() {

			@Override
			public void onNext(CResponse value) {
				// we get a response from the server
				System.out.println("Received a response from the server");
				System.out.println(value.getConfirmation());
			}

			@Override
			public void onError(Throwable t) {
				// we get an error from the server
				
			}

			@Override
			public void onCompleted() {
				// the server is done sending us data
			System.out.println("Server has completed sending us something");
				// onCompleted will be called right after onNext()
				
			}
			
		});
		
		//message1
		System.out.println("sending message1");
		requestObserver.onNext(CRequest.newBuilder().setCourse("Door security course").build());
		//message2
		System.out.println("sending message2");
		requestObserver.onNext(CRequest.newBuilder().setCourse("Static security course").build());
		//message3
		System.out.println("sending message3");
		requestObserver.onNext(CRequest.newBuilder().setCourse("Combined security course").build());
		
		//the client is done sending data
		requestObserver.onCompleted();
		
		}catch(StatusRuntimeException e) {
	    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
	    
	    return;		
	    
    } finally {
    	//shutdown channel
    	channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
    
	}
}
*/
package clientStreamingCA;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;

import cSJmDNS.SimpleServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ClientCStream {
	
	public static void main (String[] args) {
		System.out.println("Hello, I'm a gRPC client");
		
		ClientCStream main = new ClientCStream();
		main.run();
		
		
	}// end of main method

	private void run() {
	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
			.usePlaintext()
			.build();
	
	// call the function
	doClientCStreamingCall(channel);// call the method doClientStreaming
	
	//implementing the discovery for the service certificate
	// it should retrieve the functions implemented in the class SimpleServiceDiscovery 
		ServiceInfo serviceInfo;
		serviceInfo = SimpleServiceDiscovery.run();
		int port =50051; //serviceInfo.getPort();
		String host = "localhost";
		
		
	System.out.println("Shutting down channel");
	channel.shutdown();
		
	}// end of method run

	private void doClientCStreamingCall(ManagedChannel channel) {

			// create a client(stub) - asynchronous client
		AskForCertGrpc.AskForCertStub asyncClient = AskForCertGrpc.newStub(channel);
		
		CountDownLatch latch = new CountDownLatch(1);
		
		StreamObserver<CRequest> requestObserver = asyncClient.doCert(new StreamObserver<CResponse>() {

			@Override
			public void onNext(CResponse value) {
				// we get a response from the server
				System.out.println("Received a response from the server");
				System.out.println(value.getConfirmation());
			}

			@Override
			public void onError(Throwable t) {
				// we get an error from the server
				
			}

			@Override
			public void onCompleted() {
				// the server is done sending us data
			System.out.println("Server has completed sending us data");
				// onCompleted will be called right after onNext()
				latch.countDown();
			}
			
		});
		//message1
		System.out.println("sending message1");
		requestObserver.onNext(CRequest.newBuilder().setCourse("Door security course").build());
		//message2
		System.out.println("sending message2");
		requestObserver.onNext(CRequest.newBuilder().setCourse("Static security course").build());
		//message3
		System.out.println("sending message3");
		requestObserver.onNext(CRequest.newBuilder().setCourse("Combined security course").build());
		
		//the client is done sending data
		requestObserver.onCompleted();
		
		try {
			latch.await(3L,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
	
	

}

