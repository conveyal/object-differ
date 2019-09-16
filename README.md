# kryo-tools

These are shared classes enabling Kryo serialization in a couple of projects: OTP and R5.

In package com.conveyal.kryo we define some custom serializers which are reused in both projects. This introduces transitive dependencies on Trove, Guava, and Kryo itself.

The package com.conveyal.object_differ contains library classes that check whether two Java object graphs are identical, for use in serialization round-trip tests. This diffing functionality is actually independent of Kryo and should remain so, but we only use it in serialization tests so it's bundled here with Kryo serializers in a single module.

This performs a semantic equality check between two object graphs in Java. This is intended for use in testing that a round trip through serialization and deserialization reproduces an identical transportation network representation, and that the processs of building that transportation network is reproducible. A system that can do a generalized semantic comparison of any tree of objects is quite complex. Here we try to implement only the minimum feature set needed for our use case in serialization tests.

This code used to be embedded in the R5 project but is now a separate Maven / Git project so that it can be reused in
multiple projects, including R5 and OpenTripPlanner.

The object differ started out as a copy of the one supplied by @csolem via the Entur OTP branch at
https://github.com/entur/OpenTripPlanner/tree/protostuff_poc but has been mostly rewritten at this point.

To use it in a Maven project include the following dependency:

```XML
        <dependency>
            <groupId>com.conveyal</groupId>
            <artifactId>kryo-tools</artifactId>
            <version>1.2.0</version>
            <scope>test</scope>
        </dependency>
```

This project was renamed from object-differ when serializers were added, so artifacts with versions 1.0 and 1.1 exist with that name.

TODO: configuration and usage information, testing on complex objects within OTP.

## Using object-differ with Java 11+ Modules

The object differ works by reflection, which is by default not allowed under the Java module system. Applications 
depending on the kryo-tools object differ will not work without some adjustments. Rather than simply opening large
amounts of classes to reflection all the time, a more targeted solution is to add exceptions only when running your
tests (since object-differ is only really intended for testing and not needed during normal program execution). See
this article:

https://sormuras.github.io/blog/2018-09-11-testing-in-the-modular-world.html#white-box-modular-testing-with-extra-java-command-line-options
