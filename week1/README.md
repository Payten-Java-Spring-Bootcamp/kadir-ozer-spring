## 1
Pass by value means that a copy of the actual parameter’s value is made in memory, i.e. the caller and callee have two independent variables with the same value. If the callee modifies the parameter value, the effect is not visible to the caller.

Overview:

  - Passes an argument by value.
  - Callee does not have any access to the underlying element in the calling code.
  - A copy of the data is sent to the callee.
  - Changes made to the passed variable do not affect the actual value.

Pass by reference (also called pass by address) means to pass the reference of an argument in the calling function to the corresponding formal parameter of the called function so that a copy of the address of the actual parameter is made in memory, i.e. the caller and the callee use the same variable for the parameter. If the callee modifies the parameter variable, the effect is visible to the caller’s variable.

Overview:

Passes an argument by reference.
Callee gives a direct reference to the programming element in the calling code.
The memory address of the stored data is passed.
Changes to the value have an effect on the original data.

![image!](https://blog.penjee.com/wp-content/uploads/2015/02/pass-by-reference-vs-pass-by-value-animation.gif)

## 2 
The advantage of immutable objects is that you know their data cannot change, so you don't have to worry about that.
You can pass them around freely without having to remember whether a method you pass them to could change them in a way your code is not prepared to handle.
That makes working with immutable data easier.

With multiple threads, this advantage is just more important because bugs based on multiple threads changing data in ways it's not supposed to be changed are usually not reproducible
they depend on timing and thus sometimes happen and sometimes not, which makes them very hard to analyze and fix.

### To create an immutable class in Java you have to do the following steps.

  - Declare the class as final so it can’t be extended.
  - Make all fields private so that direct access is not allowed.
  - Don’t provide setter methods for variables.
  - Make all mutable fields final so that its value can be assigned only once.
  - Initialize all the fields via a constructor performing deep copy.
  - Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
  
## 3

A library performs specific, well-defined operations. 
A framework is a skeleton where the application defines the "meat" of the operation by filling out the skeleton.
The skeleton still has code to link up the parts but the most important work is done by the application.


## 4

Java applications obtain objects in memory as needed. It is the task of garbage collection (GC) in the Java virtual machine (JVM) to automatically determine what memory is no longer being used by a Java application and to recycle this memory for other uses. Because memory is automatically reclaimed in the JVM, Java application developers are not burdened with having to explicitly free memory objects that are not being used.

The GC operation is based on the premise that most objects used in the Java code are short-lived and can be reclaimed shortly after their creation. Because unreferenced objects are automatically removed from the heap memory, GC makes Java memory-efficient.

Garbage collection frees the programmer from manually dealing with memory deallocation. As a result, certain categories of application program bugs are eliminated or substantially reduced by GC:

Dangling pointer bugs, which occur when a piece of memory is freed while there are still pointers to it, and one of those pointers is dereferenced. By then the memory may have been reassigned to another use with unpredictable results.
Double free bugs, which occur when the program tries to free a region of memory that has already been freed and perhaps already been allocated again.
Certain kinds of memory leaks, in which a program fails to free memory occupied by objects that have become unreachable, which can lead to memory exhaustion.

## 5
In computer science, a memory leak is a type of resource leak that occurs when a computer program incorrectly manages memory allocations in a way that memory which is no longer needed is not released.

In general, a Java memory leak happens when an application unintentionally (due to logical errors in code) holds on to object references that are no longer required. These unintentional object references prevent the built-in Java garbage collection mechanism from freeing up the memory consumed by these objects.

Common causes for these memory leaks are:

  - Excessive session objects
  - Insertion without deletion into Collection objects
  - Unbounded caches
  - Excessive operating system page swapping
  - Un-invoked listener methods
  - Poorly written custom data structures

## 6

Oracle has announced that it will release Long-term Support (LTS), that is, long-term Java versions every 3 years, as well as non-LTS, that is, short-term supported versions every 6 months. 
  - Java 7 (2011)
  - Java 8 (2014)
  - Java 9 (2017)
  - Java 10 (2018)
  
## 7

Stack Memory in Java is used for static memory allocation and the execution of a thread. It contains primitive values that are specific to a method and references to objects referred from the method that are in a heap.
Access to this memory is in Last-In-First-Out (LIFO) order. Whenever we call a new method, a new block is created on top of the stack which contains values specific to that method, like primitive variables and references to objects.
When the method finishes execution, its corresponding stack frame is flushed, the flow goes back to the calling method, and space becomes available for the next method.

  - It grows and shrinks as new methods are called and returned, respectively.
  - Variables inside the stack exist only as long as the method that created them is running.
  - It's automatically allocated and deallocated when the method finishes execution.
  - If this memory is full, Java throws java.lang.StackOverFlowError.
  - Access to this memory is fast when compared to heap memory.
  - This memory is threadsafe, as each thread operates in its own stack.
  
eap space is used for the dynamic memory allocation of Java objects and JRE classes at runtime. New objects are always created in heap space, and the references to these objects are stored in stack memory.

  - It's accessed via complex memory management techniques that include the Young Generation, Old or Tenured Generation, and Permanent Generation.
  - If heap space is full, Java throws java.lang.OutOfMemoryError.
  - Access to this memory is comparatively slower than stack memory
  - This memory, in contrast to stack, isn't automatically deallocated. It needs Garbage Collector to free up unused objects so as to keep the efficiency of the memory usage.
  - Unlike stack, a heap isn't threadsafe and needs to be guarded by properly synchronizing the code.

## 8

Both OpenJDK and Oracle JDK are created and maintained currently by Oracle only.

OpenJDK and Oracle JDK are implementations of the same Java specification passed the TCK (Java Technology Certification Kit).

Most of the vendors of JDK are written on top of OpenJDK by doing a few tweaks to [mostly to replace licensed proprietary parts / replace with more high-performance items that only work on specific OS] components without breaking the TCK compatibility.

Many vendors implemented the Java specification and got TCK passed. For example, IBM J9, Azul Zulu, Azul Zing, and Oracle JDK.

Almost every existing JDK is derived from OpenJDK.

As suggested by many, licensing is a change between JDKs.

Starting with JDK 11 accessing the long time support Oracle JDK/Java SE will now require a commercial license. You should now pay attention to which JDK you're installing as Oracle JDK without subscription could stop working.
