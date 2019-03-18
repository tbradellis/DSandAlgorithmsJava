// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public HighArray(int max)         // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
   //-----------------------------------------------------------
   public boolean find(long searchKey)
      {                              // find specified value
      int j;
      for(j=0; j<nElems; j++)            // for each element,
         if(a[j] == searchKey)           // found item?
            break;                       // exit loop before end
      if(j == nElems)                    // gone to end?
         return false;                   // yes, can't find it
      else
         return true;                    // no, found it
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
   //-----------------------------------------------------------

   //

   public long removeMax(){
       if(a == null) {
           return -1;
       }
       long max = 0;
       for(int i =0 ; i <nElems; i++){
           max = (a[i] > max) ? a[i] : max;
       }

       delete(max);
       return max;
   }

   public long getMax(){
      if(a == null) {
         return -1;
      }
      long max = 0;
      for(int i =0 ; i <nElems; i++){
           max = (a[i] > max) ? a[i] : max;
      }
      return max;
   }
   public boolean delete(long value)
      {
      int j;
      for(j=0; j<nElems; j++)        // look for it
         if( value == a[j] )
            break;
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move higher ones down
            a[k] = a[k+1];
         nElems--;
         return true;
         }
      }


   public void display()
      {
      for(int j=0; j<nElems; j++)
         System.out.print(a[j] + " ");
      System.out.println("");
      }
   }


class HighArrayApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;
      HighArray arr;
      arr = new HighArray(maxSize);

      arr.insert(77);
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(00);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();
      long[] test = new long[maxSize];
      int i = 0;
      do{
          test[i] = arr.removeMax();
          ++i;

      }while(arr.getMax() != -1 && arr.getMax() != 0);

      for(long elem : test){
          System.out.print(elem + " ");
          if(elem == 0){
              System.out.print("0...n");
              break;
          }

      }
      System.out.println("");
      System.out.println("test long from remove: ");
      HighArray sortedArray = new HighArray(maxSize);
      sortedArray.display();
      System.out.println(arr.getMax());
      System.out.println(arr.removeMax());
      System.out.println(arr.getMax());


      int searchKey = 35;
      if( arr.find(searchKey) )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.delete(00);
      arr.delete(55);
      arr.delete(99);

      }
   }
