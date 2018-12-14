# object-differ
Compares Java object trees for serialization round-trip tests

This project contains classes that compare the contents of object graphs in Java. This is intended for use in testing
that a round trip through serialization and deserialization reproduces an identical transportation network
representation, and that the processs of building that transportation network is reproducible.

A system that can do a generalized semantic comparison of any tree of objects is quite complex. Here we try to implement
only the minimum feature set needed for our use case in serialization tests.

This code used to be embedded in the R5 project but is now a separate Maven / Git project so that it can be reused in
multiple projects, including R5 and OpenTripPlanner.

The object differ started out as a copy of the one supplied by @csolem via the Entur OTP branch at
https://github.com/entur/OpenTripPlanner/tree/protostuff_poc but has been mostly rewritten at this point.

TODO: configuration information, testing on complex objects within OTP.