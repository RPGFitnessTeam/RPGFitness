package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;


/**
 * Created by duya on 3/11/17.
 */

public class LogEntry {

    final int EXERCISE = 1;
    final int RECREATION = 1;
    final int CALISTHENICS = 2;
    final int AEROBICS = 3;
    final int WEIGHTLIFTING = 4;

    final int NUTRITION = 2;
    final int FR_VEG = 1;
    final int WATER = 2;
    final int SWEETS = 3;

    final int SLEEP = 3;
    final int QUALITY = 1;
    final int TIME = 2;

    final int WEIGHT = 4;
    final int CURRENT = 1;

    private String ID;
    private long date;
    private int activity;
    private int subType;
    private int duration = -1;
    private int distance = -1;
    private int count = -1; // also, duration
    private int intensity = -1; // also, quality of sleep
    private int weight = -1;
    private String typeName = null;

    // following should be come from database
    private String[][] subTypes; //depending on the activity
    private int[][][] firstDropdownValues; // depending on the activity and subtype
    private int[][][]secondDropdownValues;// depending on the activity and subtype
    private int[][][] thirdDropdownValues; // depending on the activity and subtype

    public LogEntry(String ID, int activity)
    {
        this.ID = ID;
        this.activity = activity;
        //set date;

        switch (activity) {
            case 1:
                typeName = "Exercise";
                break;
            case 2:
                typeName = "Nutrition";
                break;
            case 3:
                typeName = "Sleep";
                break;
            case 4:
                typeName = "Weight";
                break;
        }
    }

    public String[] getSubtypes()
    {
        return subTypes[this.activity];
    }
    public void setSubtype(int subType)
    {
        this.subType = subType;
    }
    public int[] getFirstDropdownValues()
    {
        return this.firstDropdownValues[this.activity][this.subType];
    }
    //Set typeName : String applies to only EXERCISE activity
    public void setFirstDropdownValues(String value)
    {
        switch(this.subType)
        {
            case RECREATION :
                this.typeName = value;
                break;
            case CALISTHENICS :
                this.typeName = value;
                break;
            case AEROBICS :
                this.typeName = value;
                break;
            case WEIGHTLIFTING :
                this.typeName = value;
                break;
        }
    }
    public int[] getSecondDropdownValues()
    {
        return this.secondDropdownValues[this.activity][this.subType];
    }
    //Set integer value 1
    public void setSecondDropdownValues(int value)
    {
        switch(this.activity)
        {
            case EXERCISE :
            {
                switch(this.subType)
                {
                    case RECREATION :
                        this.duration = value;
                        break;
                    case CALISTHENICS :
                        this.duration = value;// maybe count
                        break;
                    case AEROBICS :
                        this.distance = value;
                        break;
                    case WEIGHTLIFTING :
                        this.intensity = value;
                        break;
                    default : break;
                }
                break;
            }
            case NUTRITION :
            {
                this.count = value;
                break;
            }
            case SLEEP :
            {
                this.intensity = value;
                break;
            }
            case WEIGHT :
            {
                this.weight = value;
                break;
            }
            default : break;
        }
    }
    public int[] getThirdDropdownValues()
    {
        return this.thirdDropdownValues[this.activity][this.subType];
    }
    //Set integer value 2
    public void setThirdDropdownValues(int value)
    {
        switch(this.activity)
        {
            case EXERCISE :
            {
                switch(this.subType)
                {
                    case RECREATION :
                        this.intensity = value;
                        break;
                    case AEROBICS :
                        this.duration = value;
                    default : break;
                }
                break;
            }
            case SLEEP :
            {
                this.duration = value;
                break;
            }
            default : break;
        }
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public int getSubType() {
        return subType;
    }

    public void setSubType(int subType) {
        this.subType = subType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getTypeName() {
       return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
