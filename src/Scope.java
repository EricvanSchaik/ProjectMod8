import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eric on 01-Jul-17.
 */
public class Scope {

    private int newOffset;
    private Map<String, Integer> offsets = new HashMap<>();
    private Map<String, Type> varType = new HashMap<>();

    public Scope(int initialOffset) {
        newOffset = initialOffset;
    }

    public Integer offset(String id) {
        return offsets.get(id);
    }

    public Integer newOffset() {
        return newOffset;
    }

    public boolean put(String id, Type type) {
        boolean result = !offsets.containsKey(id);
        if (result) {
            offsets.put(id, newOffset);
            if (type == Type.INTEGER) {
                newOffset += 4;
                varType.put(id, Type.INTEGER);
            }
            else {
                newOffset += 4;
                varType.put(id, Type.BOOLEAN);
            }
        }
        return result;
    }

    public boolean contains(String id) {
        return offsets.containsKey(id);
    }

    public Type getType(String id) {
        return varType.get(id);
    }

}
