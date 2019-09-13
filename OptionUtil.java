import com.google.auto.value.AutoAnnotation;
import com.google.common.collect.ImmutableList;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.OptionHandler;

/** Utilities to support creating new {@link Option} instances. */
public class OptionUtil {
  @AutoAnnotation
  @SuppressWarnings("rawtypes")
  public static Option newOption(
      String name,
      ImmutableList<String> aliases,
      String usage,
      String metaVar,
      boolean required,
      boolean help,
      boolean hidden,
      Class<? extends OptionHandler> handler,
      ImmutableList<String> depends,
      ImmutableList<String> forbids) {
    return new AutoAnnotation_OptionUtil_newOption(
        name, aliases, usage, metaVar, required, help, hidden, handler, depends, forbids);
  }
}
