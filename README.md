# final_annotation

Translates `@Final` annotation to `final` modifier at compile time. This
makes it possible to enforce that the code being compiled treat the
annotated fields as final, while retaining the ability to easily compile
the same source to bytecode that does not contain the `final` modifier
(which can be useful if e.g. instrumentation of that bytecode requires
that fields not be final). Adapted from java8-change by John Shepard.

To run:

1. `ant jar`
2. `javac -cp final_annotation.jar:final_annotation_processor.jar src/uk/org/cinquin/final_annotation/FinalTest.java` :
there should be a compile error
3. `cd src; javac uk/org/cinquin/final_annotation/FinalTest.java` :
there should not be any compile error

Will probably need to be adapted to run with OpenJDK 9.

# References
 * [java8-change](https://github.com/j-shepard/java8-change)
 * [lombok](https://github.com/rzwitserloot/lombok)
 * [checker-framework](https://github.com/typetools/checker-framework/)
 * [ForceAssertions](https://github.com/akuhn/javac/tree/master/fa)
