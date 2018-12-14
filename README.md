# object-differ
Library to check that two Java object graphs are identical, for use in serialization round-trip tests.

This project is a small library that performs a semantic equality check between two object graphs in Java. This is intended for use in testing that a round trip through serialization and deserialization reproduces an identical transportation network representation, and that the processs of building that transportation network is reproducible. A system that can do a generalized semantic comparison of any tree of objects is quite complex. Here we try to implement only the minimum feature set needed for our use case in serialization tests.

This code used to be embedded in the R5 project but is now a separate Maven / Git project so that it can be reused in
multiple projects, including R5 and OpenTripPlanner.

The object differ started out as a copy of the one supplied by @csolem via the Entur OTP branch at
https://github.com/entur/OpenTripPlanner/tree/protostuff_poc but has been mostly rewritten at this point.

To use it in a Maven project include the following dependency:

```XML
        <dependency>
            <groupId>com.conveyal</groupId>
            <artifactId>object-differ</artifactId>
            <version>1.0.0</version>
            <scope>test</scope>
        </dependency>
```

TODO: configuration and usage information, testing on complex objects within OTP.
