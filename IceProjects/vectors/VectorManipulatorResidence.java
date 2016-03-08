import java.io.*;

public class VectorManipulatorResidence
{
  public static void main(String args[])  throws IOException 
  {
	  Ice.Communicator ic = null;
	  Ice.ObjectAdapter adapter;
	    
	  ic = Ice.Util.initialize(args);
    adapter = ic.createObjectAdapterWithEndpoints("VectorManipulatorAdapter", "default -p 10000");
    Ice.Object object = new VectorManipulatorI();
    adapter.add(object,ic.stringToIdentity("TheVectorManipulator"));
    adapter.activate();
    System.out.println("VecotrManipulatr server ready .... ");
    //ic.waitForShutdown();
    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("To Stop server pulse \"Return\" .... ");
    stdIn.readLine();
    ic.destroy();
  }
}
