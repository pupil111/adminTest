package com.zy.modelTest.Singleton;

public class TestSynchronized {    
    public void test1() {    
         synchronized(this) {    
              int i = 5;    
              while( i-- > 0){    
                   System.out.println(Thread.currentThread().getName() + " : " + i);    
                   try{    
                        Thread.sleep(500);    
                   } catch (InterruptedException ie){    
                   }    
              }    
         }    
    }    
      
    public synchronized void isSyncA() {    
         int i = 5;    
         while( i-- > 0){    
              System.out.println(Thread.currentThread().getName() + " : " + i);    
              try {    
                   Thread.sleep(500);    
              }   
              catch (InterruptedException ie){    
              }    
         }    
    }  
    
    public void isSyncB(){
    	System.out.println(Thread.currentThread().getName() + " : 11111111111");
    	synchronized (this) {
    		int i = 5;    
            while( i-- > 0){    
                 System.out.println(Thread.currentThread().getName() + " : " + i);    
                 try {    
                      Thread.sleep(500);    
                 }catch (InterruptedException ie){    
                 }    
            } 
		}
    	System.out.println(Thread.currentThread().getName() + " : 222222222");
    }
    
    
    public static synchronized void cSyncA(){    
         int i = 5;    
         while( i-- > 0) {    
              System.out.println(Thread.currentThread().getName() + " : " + i);    
              try{    
                   Thread.sleep(500);    
              }catch (InterruptedException ie){    
              }    
         }    
    }
    public synchronized void cSyncB() {   
    	synchronized (TestSynchronized.class) {
    		int i = 5;    
            while( i-- > 0) {    
                 System.out.println(Thread.currentThread().getName() + " : " + i);    
                 try{    
                      Thread.sleep(500);    
                 }catch (InterruptedException ie){    
                 }    
            } 
		}
    }
    public static void main(String[] args) {    
    	 final TestSynchronized myt1 = new TestSynchronized();
         final TestSynchronized x = new TestSynchronized();  
         final TestSynchronized y = new TestSynchronized();
         //同一个实例，不同的synchronized方法，对象锁有约束（同一个对象——对象锁）——a. x.isSyncA()与x.isSyncB()
         /*Thread test1 = new Thread(  new Runnable() {  public void run() { x.isSyncA();  }  }, "test1"  );    
         Thread test2 = new Thread(  new Runnable() {  public void run() { x.isSyncB();   }  }, "test2"  );*/
         
         //不同的实例，同一个synchronized方法，对象锁没有约束（不同的对象——对象锁）——b. x.isSyncA()与y.isSyncA() 
         /*Thread test1 = new Thread(  new Runnable() {  public void run() {  x.isSyncA();  }  }, "test1"  );    
         Thread test2 = new Thread(  new Runnable() {  public void run() { y.isSyncA();   }  }, "test2"  );*/
         
         //不同的实例，不同的static synchronized方法，类锁具有约束（不同的对象，类锁）c. x.cSyncA()与y.cSyncB()  
         /*Thread test1 = new Thread(  new Runnable() {  public void run() {  x.cSyncA();  }  }, "test1"  );    
         Thread test2 = new Thread(  new Runnable() {  public void run() { y.cSyncB();   }  }, "test2"  );*/
         
         //与实例无关，对象锁和类锁互不影响——d. x.isSyncA()与Something.cSyncA()
         /*Thread test1 = new Thread(  new Runnable() {  public void run() {  x.isSyncA();  }  }, "test1"  );    
         Thread test2 = new Thread(  new Runnable() {  public void run() {x.cSyncA();   }  }, "test2"  );*/
         
         
         //同一个实例，不同的synchronized方法，对象锁有约束（同一个对象——对象锁）——a. x.isSyncA()与x.isSyncB()
         Thread test1 = new Thread(  new Runnable() {  public void run() { x.isSyncB();  }  }, "test1"  );    
         Thread test2 = new Thread(  new Runnable() {  public void run() { x.isSyncB();   }  }, "test2"  );
         
         
         test1.start();
         test2.start();
         
  
    }   
    
}