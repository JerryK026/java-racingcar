package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdditionalString {
  private static final String DEFAULT_DELIMITER = ",|:";
  private static final String EMPTY = "";
  private static final Integer HEAD_INDEX = 0;
  private static final Integer DELIMITER_INDEX = 1;
  private static final Integer CONTENT_INDEX = 2;

  private final String value;
  private List<String[]> cache;

  AdditionalString(String value) {
    this.value = emptyIfNull(value);
    this.cache = new ArrayList<>();
  }

  public String[] split() {
    if (!cache.isEmpty()) {
      return cache.get(HEAD_INDEX);
    }

    if (this.value.isEmpty()) {
      return new String[]{};
    }

    Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(this.value);

    String target = this.value;
    String delimiter = this.DEFAULT_DELIMITER;
    if (matcher.find()) {
      delimiter += "|" + matcher.group(this.DELIMITER_INDEX);
      target = matcher.group(this.CONTENT_INDEX);
    }

    String[] result = target.split(delimiter);
    putCache(result);

    return result;
  }

  private String emptyIfNull(String value) {
    return value == null ? this.EMPTY : value;
  }

  private void putCache(String[] value) {
    this.cache.add(value);
    Collections.unmodifiableList(this.cache);
  }
}
