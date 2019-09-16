module com.conveyal.kryo_tools {
    requires kryo;
    requires com.google.common;
    requires trove4j;
    requires slf4j.api;
    exports com.conveyal.kryo;
    exports com.conveyal.object_differ;
}