import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConditionImpl implements Condition{
    List<Species> list;
    ConditionImpl(Species... list){
        this.list = new ArrayList<>(Arrays.asList(list));
    }
    @Override
    public List<Species> isAvailableFor() {
        return this.list;
    }
}
