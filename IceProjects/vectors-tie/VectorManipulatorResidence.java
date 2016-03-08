public class VectorManipulatorResidence
{
  public static void main(String args[]) 
  {
    Ice.Communicator ic = null;
    Ice.ObjectAdapter adapter;
	    
    ic = Ice.Util.initialize(args);
    adapter = ic.createObjectAdapterWithEndpoints("VectorManipulatorAdapter", "default -p 10000");
    Ice.Object object = new utils._VectorManipulatorTie(new VectorManipulatorI());
    adapter.add(object,ic.stringToIdentity("TheVectorManipulator"));
    adapter.activate();
    System.out.println("VecotrManipulatr server ready .... ");
    ic.waitForShutdown();
    ic.destroy();
  }
}
