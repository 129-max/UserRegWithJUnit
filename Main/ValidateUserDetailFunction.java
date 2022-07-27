@FunctionalInterface
public interface ValidateUserDetailFunction {
    boolean validate(String detail, String regex);
}
