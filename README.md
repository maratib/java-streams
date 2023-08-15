# Java Streams (Filter, Map, Reduce)

## Streams bring functional programming to Java 8+
## Advantages of Streams:-
- Will make you more efficient Java Programmer
- Make heavy use of `Lambda Expressions`
- ParallelStreams make it very easy to multi-thread operations

## A Stream pipeline consists of a `Source`, <br /> followed by zero or more `intermediate operations`, <br /> and a `terminal operation`.

![Stream Operations](./assets/img1.png "Stream Operations")

## Stream Source
Streams can be created from `Collections`, `Lists`, `ints`, `longs`, `doubles`, `arrays` and `lines of file` etc.

## Intermediate Operations
- Such as `filter`, `map` or `sort`
- Returns a stream so that we can chain multiple intermediate operations.
- Order matters do `filter first` then `sort` to improve the performance
- For larger datasets use ParallelStream to enable multiple threads.
- Includes: `anyMatch()`, `distinct()`, `filter()`, `findFirst()`, `flatMap()`, `map()`, `skip()`, `sorted()` etc.

## Terminal Operations
- Returns either void or a non-stream result.
- Only one terminal operation is allowed.
- Such as `forEach`, `collect` or `reduce`
- `forEach` applies the same function to each element.
- `collect` saves the elements into a collection.
- other options `reduce` the strem to s single summary element.
- Includes: `count()`, `max()`, `min()`, `reduce()`, `summaryStatistics()`



### IntStream
```java
            IntStream // source
                .range(1, 10) // intermediate operation
                .skip(5) // intermediate operation
                .forEach(System.out::println); // terminal operatio
```
### Sort Stream
```java
            Stream // source
                .of("Waleed", "Musa", "Maratib") // intermediate operation
                .sorted() // intermediate operation
                .findFirst() // intermediate operation
                .ifPresent(System.out::println); // terminal operation
```
### Filter and Sort Stream
```java
            Stream // source
                .of("Waleed", "Musa", "Maratib") // intermediate operation
                .filter(x -> x.startsWith("M"))
                .sorted() // intermediate operation
                .forEach(System.out::println); // terminal
```
### Files Lines
```java
        //data.txt
        // A,1,3.7
        // B,2,2.8
        // C,3,1.9
        // D,4,2.7
        // E
        // F,6,3.4
        
        Stream<String> rows = Files.lines(Paths.get("./assets/data.txt"));
        int rowCount = (int) rows
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println("Rows Count: " + rowCount);

        rows.close();
```