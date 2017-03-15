package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

/**
 * Created by Arthur on 3/11/2017.
 */

public class Tips {
    private int message;
    private String id;
    private String type;
    private boolean beenVisited;
    private boolean thumbsUp;
    private boolean thumbsDown;


    public Tips() {
        message = 0;
        id = null;
        beenVisited = false;
        thumbsUp = false;
        thumbsDown = false;
    }

    public Tips(int message, String id, String type, boolean beenVisited, boolean thumbsUp,
                boolean thumbsDown) {
        this.message = message;
        this.id = id;
        this.type = type;
        this.beenVisited = beenVisited;
        this.thumbsUp = thumbsUp;
    }

    public int getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public boolean isBeenVisited() {
        return beenVisited;
    }

    public boolean isThumbsUp() {
        return thumbsUp;
    }

    public boolean isThumbsDown() {
        return thumbsDown;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBeenVisited(boolean beenVisited) {
        this.beenVisited = beenVisited;
    }

    public void setThumbsUp(boolean thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public void setThumbsDown(boolean thumbsDown) {
        this.thumbsDown = thumbsDown;
    }

}
