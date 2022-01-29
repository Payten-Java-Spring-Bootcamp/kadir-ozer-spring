## 1
Imperative Programming as the name suggests is a type of programming paradigm that describes how the program executes. Developers are more concerned with how to get an answer step by step. It comprises the sequence of command imperatives. In this, the order of execution is very important and uses both mutable and immutable data.
Declarative Programming as the name suggests is a type of programming paradigm that describes what programs to be executed. Developers are more concerned with the answer that is received. It declares what kind of results we want and leave programming language aside focusing on simply figuring out how to produce them. In simple words, it mainly focuses on end result. It expresses the logic of computation.
## 2

Indexing is a way to optimize the performance of a database by minimizing the number of disk accesses required when a query is processed. It is a data structure technique which is used to quickly locate and access the data in a database.
The disadvantages of indexes are as follows:
- They decrease performance on inserts, updates, and deletes.
- They take up space (this increases with the number of fields used and the length of the fields).
- Some databases will monocase values in fields that are indexed.
## 3

## 4
Speaking of ORM, most software developers need a library that implements the Object-Relational Mapping technique.

An ORM library pulls data in and manipulates it into objects in the programming language you are using, so you don't need to use sql anymore. You communicate directly with the database in the language you are using.

Disadvantages of ORM Technique

Learning ORM theory and technique can take time. ORM libraries are quite complex libraries.
ORM tools need to be configured and integrated into the application. (This integrated process can be done quickly and easily with other frameworks. For example, Spring Framework for Java, especially Spring Boot and Spring Data can be used)
In applications that require high performance or contain complex queries, ORM queries can offer poor performance if not optimized.
## 5

Domain Specific Language (DSL) is a programming language or specification language specified for a particular problem domain, a particular problem presentation technique, and/or a particular solution technique.

It is a programming language developed for a specific subject rather than a general programming language. Scanner and parser languages such as yacc, lex, or a database language such as sql can be given as examples. To give a different example: a language for performing boolean algebra operations, set theory language, web server performance profiling, etc. it could be. In other words, languages that are customized for any business imaginable are called domain specific languages. Its purpose is to simplify programming, often to improve performance.

## 6

## 7
While threads provide benefits for us in many ways, they are also a headache if they are used in an uncontrolled manner. Since threads also use the resources of the operating system, when they are used in an uncontrolled manner, we will quickly consume these resources. For example, even if it is necessary to run 4 threads in an environment where we have 2 processor cores, we must wait for the first 2 to finish and then create and run the other 2. Instead of following this event in this way, we can use the Thread pools provided by Java. Java offers us a class called Executor for the regular and controlled execution of thread count and operation.

To briefly summarize its usage:

ExecutorService asks us how many Threads we want to run at a given time.
This number can be specified with the newFixedThreadPool() method.
We add our threads to the executorService with the ExecutorService.submit() method.
As long as there is room in the "ExecutorService" pool, it creates a new thread with the Runnable objects added to it and starts it.
Transactions added later are queued and run as existing transactions are finished.
The shutdown() method, on the other hand, stops receiving new processes and ensures that existing processes are terminated.
awaitTermination() gives a certain time for the current processes to finish, after which the ExecutorService is closed completely.
## 8

Scalability is not a concept unique to programming languages. It is about how the system reacts to this increase with the increasing number of users in the system. The system infrastructure should be designed according to the number of users it addresses. For example, you wrote a program on android and you keep your data in a system that can handle requests from 100-200 users. When 10,000 people download this program from the play store and start using it, the system will become unable to respond to requests. In order to prevent these problems, there are cloud services such as Amazon and Azure today. How many users are connected and how many requests are made, payment is made per request.

Horizontal Scability & Vertical Scability

Vertical scalability is making your existing machine more powerful by increasing its CPU and RAM features. Horizontal scalability is adding more machines to your existing resource pool. With the use of load balancers in horizontal scalability, the load of the system is equally distributed to all machines.

With horizontal scalability, dynamically adding new machines to an existing resource pool is less costly, easier, and can be added as many times as desired. Vertical scalability, on the other hand, has an upper limit on the features you can add to a machine. In other words, you can increase the features that a single machine can be increased up to a certain point.
## 9

Sharding is partitioning in which the database is split into multiple smaller databases to improve performance and read time. Replication is basically an event to copy the database to multiple databases to provide a faster view and less response time. Content delivery networks are the best examples of this.
