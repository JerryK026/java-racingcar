package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdditionalString {
  private static final String DEFAULT_DELIMITER = ",|:";
  private static final String EMPTY = "";
  private static final Integer DELIMITER_INDEX = 1;
  private static final Integer CONTENT_INDEX = 2;

  private final String value;

  AdditionalString(String value) {
    this.value = emptyIfNull(value);
  }

  public String[] split() {
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

    return target.split(delimiter);
  }

  private String emptyIfNull(String value) {
    return value == null ? this.EMPTY : value;
  }
}
