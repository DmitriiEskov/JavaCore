package finaltasks;

/**
 * Class for counting changes between two versions of a collection.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 12.05.2019
 */
public class Info {

    /**
     * Number of additions.
     */
    private int added;

    /**
     * Number of changes. User is defined to be changed if their name is changed.
     */
    private int changed;

    /**
     * Number of deletions.
     */
    private int deleted;

    /**
     * Number of unchanged users.
     */
    private int unchanged;

    /**
     * Increases this.unchanged.
     */
    public void increaseUnchanged() {
        this.unchanged++;
    }

    /**
     * Increases this.changed.
     */
    public void increaseChanged() {
        this.changed++;
    }

    /**
     * Increases this.deleted.
     */
    public void increaseDeleted() {
        this.deleted++;
    }

    /**
     * Sets this.added.
     */
    public void setAdded(int i) {
        this.added = this.added + i;
    }

    /**
     * Returns this.added.
     */
    public int getAdded() {
        return this.added;
    }

    /**
     * Returns this.changed.
     */
    public int getChanged() {
        return this.changed;
    }

    /**
     * Returns this.deleted.
     */
    public int getDeleted() {
        return this.deleted;
    }

    /**
     * Returns this.unchanged.
     */
    public int getUnchanged() {
        return this.unchanged;
    }
}