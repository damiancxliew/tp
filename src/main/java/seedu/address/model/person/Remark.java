package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/** A simple value object for a person's remark. */
public class Remark {

    /*
     * The first character of the remark must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";
    public static final String MESSAGE_CONSTRAINTS = "Remark can take any values, and it should not be blank";
    public final String value;

    public Remark(String remark) {
        requireNonNull(remark);
        checkArgument(isValidRemark(remark), MESSAGE_CONSTRAINTS);
        this.value = remark;
    }

    public static boolean isValidRemark(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Remark)) {
            return false;
        }

        Remark otherRemark = (Remark) other;
        return value.equals(otherRemark.value);
    }

    @Override public int hashCode() {
        return value.hashCode();
    }
}
