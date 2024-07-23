PRODUCT AND CONSUMER PROBLEM

SYNCHRONISED UNDER CONCURENCY
 - In multithreaded environment if there is shared resource or shared object then inconsistency or ambiguity can be 
 observed in the output or data because sometime thread 1 is executed and sometime thread 2 is executed
 - SOLUTION is SYNCHRONISATION
 - Synchronised Method is more time(approx 2 times) then Synchronised Block


THERE ARE 2 WAYS TO ACHEIVE SYNCHRONISATION
 1) SYNCHRONISED METHOD
     - A synchronized method is a method that is declared with the synchronized keyword. 
     - When a thread invokes a synchronized method, it acquires the lock for the object that the method belongs to 
     and will release the lock when it complete its entire task which means that only one thread can execute that 
     method at a time for a given object instance. 


                public class SynchronizedCounter {
                    private int count = 0;

                    public synchronized void increment() {
                        count++;
                    }

                    public synchronized void decrement() {
                        count--;
                    }

                    public synchronized int getCount() {
                        return count;
                    }
            }


  2) SYNCHRONISED BLOCK
     - Synchronized blocks are more granular than synchronized methods. 
     - They allow you to synchronize only a portion of the code within a method. 
     - This can improve performance by reducing the scope of synchronization, allowing other threads to execute 
     non-critical sections of code concurrently.
     - A synchronized block is defined using the synchronized keyword followed by an object reference, which acts 
     as a lock. Only one thread can execute the synchronized block for that particular object at a time.


                    public void updateResource() {
                        // Code that can be accessed by multiple threads
                        // ...

                        synchronized (this) {
                            // Critical section that needs synchronization
                            // Access shared resources
                        }

                        // More code that can be accessed by multiple threads
                        // ...
                    }




EXECUTOR SERVICE (THREAD POOL) (PAGE 66)
 - A framework of creating and managing threads.    
     - THREAD CREATION: Provides various methods for creating threads and pool of threads.
     - THREAD MANAGEMENT: Manages the life cycle of thread in thread pool.
     - TASK SUBMISIION AND EXECUTION: Provides method for submitting the task for execution in thread pool.

WHY THREADPOOL
 - Creating a thread is an expensive operation and it should be minimized.
 - Having worker threads minimizes the overhead due to thread creation because the executor service has to create a
  thread pool only once and then it can reuse the threads for executing any task.
 - Tasks are submitted to a thread pool via an internal queue called BLOCKING QUEUE.
 - Threadpool is the pool of thread that we have specified that these many threads are there for execution

     ExecutorService executorService  = Executors.newFixedThreadPool(5);
     ExecutorService executorService  = Executors.newSingleThreadExecutor();
     executorService.submit(() -> { 
        System.out.println(“task running in:” + Thread.currentThread.getName());
     }


 - BLOCKING QUEUE: whatever request we are sending to the executor service, Blocking queue will hold the request 
 unless and until there is a task from the task pool which are available to pick up the data
   1) ArrayBlockingQueue : mandatory to specify the capacity
   2) LinkedBlockingqueue : optional to specify the capacity


 - THREADPOOL: Whenever we are creating the executor service, we specify that these are the number of threads that i
 would require for the executions of all task which i would be submitting in the executor service

 - CORE POOL SIZE (CPS): No of threads we want to create

 - MAX POOL SIZE (MPS): we can expand our threadpool till this size. 

 - KEEP ALIVE TIME (KAT): 
    - for eg we r expanding our thread pool from 4 to 10, additional thread from 5 to 10 are dynamically created as 
    and when our no. of task are getting  increased and blocking queue are nt able to hold these tasks. It doesnot
    want that all these 10 threads should remain in memory forever
    - Additional time that we have created. It will wait for the given time. If its not processing for any task then
    it would simply terminate that thread.
    - Thread in maxpoolsize should wait for how much time to get terminated
    - It is applicable only for maxpoolsize not for corepoolsize



EXECUTOR SERVICE METHODS
 1) ExecutorService executor = Executors.newFixedThreadPool(n); 
     - Here, Thread will not go beyond n
     - CPS = n    MPS = n    KAT = 0
 
 2) ExecutorService executor = Executors.newSingleThreadExecutor()  
     - if in newFixedThreadPool(1) then performance wise both are same and only 1 thread will get executed
     - CPS = n    MPS = n    KAT = 0
     - Message will never be in blocking queue. As soon as message will be in BQ, it will immediately go to thread 
     pool. BQ cannot take request unless and until 1st request is taken by the ThreadPool
     - Depending on the no. of request, it will keep on increasing the request in the thread pool
     - IO TASK : make sense to have concurrency/parallelism
     - CPU Intensive : Increasing thread size beyond the CPU cores, then it degrades performance

 3) ExecutorService executor = Executors.newCachedThreadPool();  
     - 
     - CPS = n    MPS = n    KAT = 0

 4) ScheduledExecutorService scheduledExecService = Executors.newScheduledThreadPool(n);  
     - we will specify some delays
     - Delayed work queue i.e it wait for a given time and then ur thread would pick the task
     - CPS = n    MPS = MAX_VALUE    KAT = 

   - whenever we r starting the executor service, it is nt gettting stopped automatically. so, as a developer it is
   our responsiblity that once we dont  do any further task then i should be shutting all of them bcoz if we willnot
   shut those thread then those thread would be live. It is basically a signal to executor server that after this 
   dont accept any request
   - if after shutdown of executorService anything we submit will give exceptionand will get rejected bcoz we have 
   told executor service to not accept any request

 - SHUT DOWN: Stops accepting new tasks and waits for the previously submitted task to execute and then terminates
  the executor.

 - SHUT DOWN NOW: interrupts the running task and shuts down immediately.

 - boolean awaitTermination(long timeout, TimeUnit unit):	
      - This method blocks the task to enter ExecutorService until all the tasks have completed after the shutdown 
      request, or the given timeout occurs, or the current thread is interrupted, whichever happens first.
     - It specifies that wait for maximum this much time, I think that my executor service will able to complete the
     task within this time, if it is not able to complete then simply go and start ur execution
           - if 4000ms and work completes in 3 sec then main thread would start after 3 sec but if it completes in
               6sec, then MAIN would start after 4 sec

  5) CUSTOM EXECUTOR SERVICE
       - CPS 4   MPS 10     ARRAY BLOCKING QUEUE 3

       ExecutorService ex = new ThreadPoolExecutor(4, 10, 60 keepAliveTime, TimeUnit.seconds, new ArrayBlockingQueue<>(3))
         - till the time it can take the request, it will take the request after that time it will fail to take any 
         request bcoz our blocking queue was full, we have reached our maximum thread pool size that is when our 
         task getting rejected

       ExecutorService ex = new ThreadPoolExecutor(4, 10, 60 keepAliveTime, TimeUnit.seconds, new LinkedBlockingQueue<>())
         - ideally all our request will be submitted bcoz now we r telling that our queue must be of idefnite size 
         and we can simply hold as many request as we can
         - we can also tell the capacity of linked blocking queue now in this also it will fail after that point of
          time


OPTIMAL NUMBER OF THREADS

        I/O Bound Tasks:
        Threads = number of cores * (1+ wait time/service time) 
        CPU Bound Tasks:
        threads = number of cores + 1

CUSTOM EXECUTORSERVICE METHODS
   - We provide the custom size of the pool, maximum size of the pool, time to alive for that pool threads and 
   blocking queue implementation.

            int corePoolSize = 5;
            int maxPoolSize = 10;
            long keepAliveTime = 5000;
            ExecutorService threadPool = new ThreadPoolExecutor(
                        corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>()
                        );


CONCURRENCY ISSUES(PROBLEM ARISES WITH MULTITHREADING)
   - Thread Interference Error(Race Conditions)
   - Memory Consistency Issue


THREAD INTERFERENCE ERROR(ERROR CONDITION):-
   - When multiple threads try to read and write with a shared variable concurrently, and these read and write
    operations overlap in execution, then the final outcome depends on the order in which the reads and writes take
     place and which is unpredictable. This phenomenon is known as race condition.

                Eg: Multithreads incrementing the visitors count.
                Solution: Using Atomic or using synchronized


MEMORY CONSISTENCY ERROR :- 
   - Memory Inconsistency errors occur when different threads have inconsistent views of thread.This happens when 
   shared data gets updated by one thread but it is not propagated to the next thread and the thread ends up using
    the older data.
   - Processor also tries to optimize things, for instance a processor might read the current value of a variable
    from a temporary register, instead of the main memory.
   - Eg: One Thread is singling another thread to stop by changing the value of a variable.

           Solution: Using a Volatile Keyword.
           Volatile: Instead of reading the data from temporary registers, value will get read from the main memory.


SYNCHRONIZED
 - It can be a code block or method.
 - Degrades the performance.
 - Can block threads.
 - Synchronize the value of all variables between thread memory and main memory.


VOLATILE
 - Volatile is a field modifier and cannot be used with method or function or block.
 - Improves performance.
 - Cannot block threads.
 - Synchronizes the thread memory and the main memory of one variable


CALLABLE AND FUTURE 
 - A callable is similar to runnable except it can return a result and throw a checked exception.
 - The concept of Future is similar to promises in other languages like javascript. It represents the results of a
  computation that will be completed at a later point of time in future.
 - ExecutorService.submit() method returns immediately and gives you a future.
 - The get method blocks until the task is completed. The future API also provides an isDone() method to check 
 whether the task is completed or not.
 - The future.get() method will throw a TimeoutException if the task is not completed within the specified time.


RUNNABLE
 - Part of java.lang package.
 - Cannot return result of computation 
 - Cannot throw a checked exception
 - Need to override run() method.
 - Can be used with Thread class and ExecutorService.
 - Can create thread using runnable


CALLABLE
 - Part of java.util.concurrent package.
 - Can return result of computation.
 - Can throw checked exceptions.
 - Need to override call() method.
 - Can only be used with ExecutorService but not with Thread class.
 - Cannot create thread using callable



BEST PRACTISES
   1) Reusing ExecutorService: Avoid creating new instances frequently; reuse existing ones.
   2) Proper Shutdown: Always ensure the executor service is properly shut down to free resources.
   3) Handling Exceptions: Properly handle exceptions thrown by tasks to prevent unexpected behavior.


BASIC USAGES
   1) Creating an ExecutorService: Use factory methods from the Executors class.
   2) Submitting Tasks: Use submit() or execute() methods.
   3) Shutting Down: Use shutdown() and shutdownNow() methods to terminate the executor service.

