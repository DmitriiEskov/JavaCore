package finaltasks;

import java.util.HashMap;
import java.util.List;

/**
 * Class for analyzing a difference between two different List collections.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 12.05.2019
 */
public class Analize {

    /**
     * Returns differences between two List collections.
     * @param previous - first collection
     * @param current - second collection
     * @return Info class with all differences (additions, deletions, modifications) between previous and current
     */
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        HashMap<Integer, User> map = new HashMap<>();
        current.forEach(user -> {
            if (user != null) {
                map.put(user.getID(), user);
            }
        });
        previous.forEach(e1 -> {
            if (e1 != null) {
                if (map.containsKey(e1.getID())) {
                    if (!map.get(e1.getID()).getName().equals(e1.getName())) {
                        info.increaseChanged();
                    } else {
                        info.increaseUnchanged();
                    }
                } else {
                    info.increaseDeleted();
                }
            }
        });
        info.setAdded(map.size() - info.getChanged() - info.getUnchanged());
        return info;
    }
}