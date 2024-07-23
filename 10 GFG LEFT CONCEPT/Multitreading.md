- Multithreading in Java is a process of executing multiple threads simultaneously.
- we use multithreading than multiprocessing because threads use a shared memory area. They don't allocate separate 
memory area so saves memory, and context-switching between the threads takes less time than process.
- Java Multithreading is mostly used in games, animation, etc.
- Thread scheduler decides which thread to run and which thread to wait

 - Concurrent :- Processes are swapping so fast, we think multiple processes are runnning in parallel
 - Parallelism :- Multiple tasks at a time
 - Single Processor :- only one processor is running, concurrency can be acheived
 - Multi Processor :- parallelism is only possible with multiple processors

 - core is smallest unit of processor(Quad core processor)
 - Thread is a process which runs on a core
 - one core can accomdate one thread at a time


MAIN THREAD IN JAVA :
 - Automatically gets created when a program starts its execution.
 - Main method represents the execution path of the main thread.
 - Long running process can block the main thread,introduce slowness in the app or can hang the app.
 - We can use child Thread/ worker thread to do some work.
 - Every thread has its own stack.


DAEMON THREAD
 - Low priority threads which run in the background to perform tasks such as garbage collection.
 - It provides services to user threads for background supporting tasks. It has no role in life than to serve user threads.
 - Its life depends on user threads. Gets exited after all the user threads get terminated.
 


PROCESS
 - Process are instance of running program and each process has its own m/m space, are independent and isolated from
 from each other
 - They dont share m/m directly and communicate through IPC(Inter-Process Communication) mechanism
 - creating and managing processes is resource-intensive bcoz each process requires ite own m/m and resources.
 - use when tasks needs to be isolated from each other, and creating them is more resource-intensive
 - 3 process are running and 1 process crashes then it is nt going to affect other process



THREADS
 - Threads are functionalities of process and they are working simultaneously in order to complete the task of process
 - Multiple threads can exits within the same process and share the same m/m space
 - Use when task can share resources and run concurrently within the same application,, making them less resource 
 intensive and suitable for parallel execution.
 - 3 threads are running and 1 threads crashes then it is nt going to affect other threads bcoz threads are 
 running all together in order to complete the major task of process



ADVANTAGES OF MULTITHREADING (also see n/b from page 33)
1) It doesn't block the user because threads are independent and we can perform multiple operations at same time.
2) You can perform many operations together, so it saves time.
3) Threads are independent, so it doesn't affect other threads if an exception occurs in a single thread.



MULTITASKING
- Multitasking is a process of executing multiple tasks simultaneously. We use multitasking to utilize the CPU 
as our CPU is very powerful Multitasking can be achieved in two ways:

   1) Process-based Multitasking (Multiprocessing)
       - ALlows multiple process to run concurrently. eg:- watching youtube and also making notes simultaneously
       - listening to music and browsing web and MS word

   2) Thread-based Multitasking (Multithreading)
       - Allows parts of some program to run concurrently. eg;- importing video file also viewing it
       - watching video on media player and also listening to what video player says



JAVA THREADS METHOD
 1) void start()                :- start the execution of the thread. JVM calls run() method on the thread
 2) void run()                  :- used to perform action for a thread
 3) void sleep(long milliseconds):- causes the currently executing thread to sleep(temporarily cease execution)
                                    for specified no. of milliseconds. doesnt release the lock
 4) static Thread currentThread :- return a reference of the currently executing thread object
 5) void join()                 :- waits for a thread to die
 6) void join(long milliseconds)        void resume()       void interrupt      
 7) void Thread currentThread() :- return the reference of currently executing thread
 8) Thread.state getState :- return the state of the thread
 6) int getPriority()     void setPriority()     String getName()       void setName()      boolean isAlive()
 void suspend()         void stop()     String toString()    boolean isDaemon()    void setDaemon()    
 7) static boolean holdLock() :- returns true if and only if current threads holds the computer lock on specified object
 8) void destroy :- used to destroy the thread group and all of its subgroups



LIFECYCLE OF A THREAD(THREAD STATES)    (see page 64 of notebook)
 - In Java, a thread always exists in any one of the following states. These states are:
     1) New 
         - Whenever a new thread is created, it is always in the new state. For a thread in the new state, the 
         code has not been run yet and thus has not begun its execution

     2) Active
         - When a thread invokes the start() method, it moves from the new state to the active state.
             1) Runnable
                 - Runnable: A thread, that is ready to run is then moved to the runnable state. In the runnable 
                 state, the thread may be running or may be ready to run at any given instant of time. It is the
                  duty of the thread scheduler to provide the thread time to run, i.e., moving the thread the
                   running state.
                 - A program implementing multithreading acquires a fixed slice of time to each individual 
                 thread. Each and every thread runs for a short span of time and when that allocated time slice 
                 is over, the thread voluntarily gives up the CPU to the other thread, so that the other threads
                  can also run for their slice of time. Whenever such a scenario occurs, all those threads that 
                  are willing to run, waiting for their turn to run, lie in the runnable state. In the runnable 
                  state, there is a queue where the threads lie.

             2)  Running: 
                  - When the thread gets the CPU, it moves from the runnable to the running state.

        - Generally, the most common change in the state of a thread is from runnable to running and again back to runnable

     3) Blocked / Waiting
         - Whenever a thread is inactive for a span of time (not permanently) then, either the thread is in the 
         blocked state or is in the waiting state.
         - For example, a thread (let's say its name is A) may want to print some data from the printer. However,
          at the same time, the other thread (let's say its name is B) is using the printer to print some data.
        Therefore, thread A has to wait for thread B to use the printer. Thus, thread A is in the blocked state.
        -  A thread in the blocked state is unable to perform any execution and thus never consume any cycle of 
        the Central Processing Unit (CPU). Hence, we can say that thread A remains idle until the thread scheduler reactivates thread A, which is in the waiting or blocked state.
        - When the main thread invokes the join() method then, it is said that the main thread is in the waiting
         state. The main thread then waits for the child threads to complete their tasks. When the child threads 
         complete their job, a notification is sent to the main thread, which again moves the thread from waiting
         to the active state.

         - If there are a lot of threads in the waiting or blocked state, then it is the duty of the thread
          scheduler to determine which thread to choose and which one to reject, and the chosen thread is then
          given the opportunity to run.

     4) Timed Waiting
        - Sometimes, waiting for leads to starvation. For example, a thread (its name is A) has entered the 
        critical section of a code and is not willing to leave that critical section. In such a scenario, another 
        thread (its name is B) has to wait forever, which leads to starvation. To avoid such scenario, a timed 
        waiting state is given to thread B. Thus, thread lies in the waiting state for a specific span of time, and 
        not forever. A real example of timed waiting is when we invoke the sleep() method on a specific thread. The 
        sleep() method puts the thread in the timed wait state. After the time runs out, the thread wakes up and 
        start its execution from when it has left earlier.

     5) Terminated
         - A thread reaches the termination state because of the following reasons:
             - When a thread has finished its job, then it exists or terminates normally.

         - Abnormal termination: 
         It occurs when some unusual events such as an unhandled exception or segmentation fault.
         - A terminated thread means the thread is no more in the system. In other words, the thread is dead, and
          there is no way one can respawn (active after kill) the dead thread.



CREATING A THREAD IN JAVA

   - Commonly used Constructors of Thread class:
       1) Thread()
       2) Thread(String name)
       3) Thread(Runnable r)
       4) Thread(Runnable r,String name)

   - Starting a thread:
     - The start() method of Thread class is used to start a newly created thread. It performs the following tasks:
     - A new thread starts(with new callstack).
     - The thread moves from New state to the Runnable state.
     - When the thread gets a chance to execute, its target run() method will run.

 1) BY EXTENDING THREAD CLASS

 2) BY IMPLEMENTING RUNNABLE INTERFACE
 
THREAD CLASS
 - A class which is used to create a thread.
 - Multiple methods, like start() run() etc with no abstract method.
 - Each Thread creates a unique object and gets associated with it. 
 - Once a class extends Thread class, It can not extend other class(No multiple Inheritance)

RUNNABLE INTERFACE
 - Functional Interface used to override the run of a thread.
 - One abstract method.
 - Multi threads share the same object.
 - Can extend another class as it implements the interface for the thread.


ISSUES WITH MULTITHREADING

 1. Race Conditions
      - Race conditions occur when multiple threads access and modify shared data concurrently, leading to
       unpredictable results. For instance, if two threads increment a shared counter without synchronization, the
       final value may not reflect all increments due to overlapping operations. This issue arises because the
       operations are not atomic, meaning they can be interrupted by other threads.

                            class Counter {
                                private int count = 0;

                                public void increment() {
                                    count++; // This operation is not atomic
                                }
                            }

 2. Deadlocks
       - Deadlocks happen when two or more threads are blocked indefinitely, each waiting for the other to release 
       a resource. This situation typically arises from circular dependencies where Thread A holds a lock needed by
        Thread B, and Thread B holds a lock needed by Thread A.

                            class Resource {
                                synchronized void method1(Resource other) {
                                    // Do something
                                    other.method2(this);
                                }

                                synchronized void method2(Resource other) {
                                    // Do something else
                                    other.method1(this);
                                }
                            }

 3. Memory Consistency Errors
       - Memory consistency errors occur when different threads have inconsistent views of shared data.
        For example, one thread may read a variable while another thread is updating it, leading to one thread 
        seeing a stale or inconsistent value. This problem can arise without proper synchronization mechanisms in
         place.

                            class SharedData {
                                private int value;

                                public void setValue(int val) {
                                    this.value = val;
                                }

                                public int getValue() {
                                    return this.value; // May read an inconsistent state
                                }
                            }


PREVENTIONS TECHNIQUES

 1) SYNCHRONISATION: Use the synchronized keyword to control access to shared resources, ensuring that only one 
 thread can read or write at a time.
 2) VOLATILE VARIABLES: Use the volatile keyword for variables accessed by multiple threads to ensure visibility of 
 changes across threads.
 3) IMMUTABLE OBJECTS: Design classes to be immutable wherever possible. Immutable objects cannot change state 
 after construction, eliminating the need for synchronization.
 4) HIGH LEVEL CONCURRENCY CONSTRUCTS: Utilize classes from the java.util.concurrent package, such as 
 ExecutorService, Semaphore, and CountDownLatch, to manage concurrency more effectively.
FINE-GRAINED LOCKING: Instead of locking entire methods, lock only the critical sections of code to minimize 
contention.



COMPLETABLE FUTURE (CODE IN .JAVA)
 - enhances the capabilities of the traditional Future interface by allowing for asynchronous programming and
  providing a way to build complex asynchronous workflows.

KEY FEATURES OF COMPLETABLE FUTURE: 
 1) Asynchronous Computation: CompletableFuture allows you to run tasks asynchronously without blocking the main
  thread. This is achieved using methods like supplyAsync, which executes a task in a separate thread.
 2) Non-blocking Operations: Unlike the traditional Future, CompletableFuture supports non-blocking operations,
  enabling you to register callbacks that can be executed upon completion of the task.
 3) Chaining and Composing: CompletableFuture supports method chaining, allowing you to combine multiple
  asynchronous computations. Methods like thenApply, thenCombine, and thenCompose enable you to define what to do 
  with the result of a previous computation.
 4) Exception Handling: It provides robust exception handling capabilities with methods like exceptionally, which 
 allows you to specify a fallback value if the computation fails.
 5) Completion Stages: CompletableFuture implements the CompletionStage interface, which allows for building 
 multi-stage asynchronous computations, making it easier to manage complex workflows.



LIMITATIONS OF FUTURE, AND WHY IS COMPLETABLE FUTURE REQUIRED ? 
 1) Futures cannot perform further action until the result is available, and it doesn’t notify us of its completion.
 It provides us a ‘get’ method which blocks until the result is available.
 2) It is not possible to attach a callback function that can be invoked automatically once the result is available.
 3) Multiple futures cannot be chained together -> send the response of the first future as an input to the second future.
 4) There is no exception handling in the Future APIs.


METHODS OF COMPLETABLE FUTURE 
 1) runAsync() :- for providing an instance of Runnable (void return type)
 2) supplyAsync() :- for providing an instance of Supplier (custom return type)
 3) thenApply() :- takes the output of the previous function call and makes modifications to it.
 4) thenAccept() :- Usually used as the last callback method, takes the result of the previous future and will then return void. 
 5) thenRun() :- Usually used as the last callback method, does not have access to the previous future result. It takes a runnable which is executed when the previous future is completed.
 6) thenApplyAsync() :- Similar to thenApply(), but is executed by another thread.
 7) thenAcceptAsync() :- Similar to thenAccept(), but is executed by another thread.
 8) thenRunAsync() :- Similar to thenRun(), but is executed by another thread.

