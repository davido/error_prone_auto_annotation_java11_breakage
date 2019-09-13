==== Reproducer for Error Prone issue

To reproduce, run:

```
  $ bazel build :cli
```

with Java 8 vs. Java 11.

While Java 8 doesn't have any issue with the provided code,
Java 11 is failing with:

```
 bazel build :cli
INFO: Writing tracer profile to '/home/davido/.cache/bazel/_bazel_davido/b78564ff4088c32bd1290c7e0b234fc2/command.profile.gz'
INFO: Analyzed target //:cli (0 packages loaded, 0 targets configured).
INFO: Found 1 target...
ERROR: /home/davido/projects/error_prone_auto_annotation_java11_breakage/BUILD:30:1: Building libcli.jar (1 source file) and running annotation processors (AutoAnnotationProcessor, AutoValueProcessor) failed (Exit 1)
bazel-out/k8-fastbuild/bin/_javac/cli/libcli_sourcegenfiles/AutoAnnotation_OptionUtil_newOption.java:11: error: [ImmutableAnnotationChecker] annotations should be immutable: 'AutoAnnotation_OptionUtil_newOption' has field 'aliases' of type 'java.lang.String[]', arrays are mutable
  private final String[] aliases;
                         ^
    (see https://errorprone.info/bugpattern/ImmutableAnnotationChecker)
bazel-out/k8-fastbuild/bin/_javac/cli/libcli_sourcegenfiles/AutoAnnotation_OptionUtil_newOption.java:25: error: [ImmutableAnnotationChecker] annotations should be immutable: 'AutoAnnotation_OptionUtil_newOption' has field 'depends' of type 'java.lang.String[]', arrays are mutable
  private final String[] depends;
                         ^
    (see https://errorprone.info/bugpattern/ImmutableAnnotationChecker)
bazel-out/k8-fastbuild/bin/_javac/cli/libcli_sourcegenfiles/AutoAnnotation_OptionUtil_newOption.java:27: error: [ImmutableAnnotationChecker] annotations should be immutable: 'AutoAnnotation_OptionUtil_newOption' has field 'forbids' of type 'java.lang.String[]', arrays are mutable
  private final String[] forbids;
                         ^
    (see https://errorprone.info/bugpattern/ImmutableAnnotationChecker)
Target //:cli failed to build
Use --verbose_failures to see the command lines of failed build steps.
INFO: Elapsed time: 0.430s, Critical Path: 0.35s
INFO: 0 processes.
FAILED: Build did NOT complete successfully
```
