import utils.IntVectorHolder;


public class VectorManipulatorI implements utils._VectorManipulatorOperations 
{
 
  public void sort(int[] inVector, IntVectorHolder outVector, Ice.Current __current)
	{
	  int i, j, posMax, tmp;
	  
	  for(i=0;i<inVector.length-1;i++)
	  {
	    posMax=i;
	    for(j=i+1;j<inVector.length;j++)
	    {
	      if(inVector[j] < inVector[posMax]) posMax=j;
	    }
	    if(posMax != i)
	    {
	      tmp = inVector[posMax];
	      inVector[posMax] = inVector[i];
	      inVector[i]= tmp;
	    }
	    outVector.value=inVector;
	  }
	}

	public void copyWithoutDuplicates(int[] inVector, IntVectorHolder outVector, Ice.Current __current)
  {
	  int[] tmpVector;
	  int i, n=0;
    
	  tmpVector= new int[inVector.length];
	  for(i=0;i<inVector.length;i++)
	  {
	    if(!contains(tmpVector,0,i,inVector[i]))
	    {
	      tmpVector[n]=inVector[i];
	      n++;
	    }
	  }
	  outVector.value=new int[n];
	  for(i=0;i<n;i++) outVector.value[i]=tmpVector[i];
  }
	
	protected boolean contains(int[] vector, int begin, int end, int element)
	{
	  int i;
	  
	  for(i=begin;i<end;i++)
	    if(vector[i] == element) return true;
	  return false;
	}
}
