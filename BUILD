load("@rules_java//java:defs.bzl", "java_library", "java_plugin")

java_plugin(
    name = "auto-annotation-plugin",
    processor_class = "com.google.auto.value.processor.AutoAnnotationProcessor",
    deps = [
        "@auto-value-annotations//jar",
        "@auto-value//jar",
    ],
)

java_plugin(
    name = "auto-value-plugin",
    processor_class = "com.google.auto.value.processor.AutoValueProcessor",
    deps = [
        "@auto-value-annotations//jar",
        "@auto-value//jar",
    ],
)

java_library(
    name = "auto-value-annotations",
    exported_plugins = [
        ":auto-annotation-plugin",
        ":auto-value-plugin",
    ],
    exports = ["@auto-value-annotations//jar"],
)

java_library(
    name = "cli",
    srcs = ["OptionUtil.java"],
    javacopts = ["-Xep:ImmutableAnnotationChecker:ERROR"],
    deps = [
        ":auto-value-annotations",
        "@args4j//jar",
        "@guava//jar",
    ],
)
