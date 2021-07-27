import java.util.List;

/**
 * class provide information about who can placed in Cage
 */
public interface Condition {
    List<Species> isAvailableFor();
}