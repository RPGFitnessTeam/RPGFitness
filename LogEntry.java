package fitnessrpg.fitnessrpg;


import java.text.SimpleDateFormat;
import java.util.Date;

public class LogEntry {

    final int EXERCISE = 0;
    final int RECREATION = 0;
    final int CALISTHENICS = 1;
    final int AEROBICS = 2;
    final int WEIGHTLIFTING = 3;

    final int NUTRITION = 1;
    final int FR_VEG = 0;
    final int WATER = 1;
    final int SWEETS = 2;

    final int SLEEP = 2;
    final int QUALITY = 0;
    final int TIME = 1;

    final int WEIGHT = 3;
    final int CURRENT = 0;

    private String ID = null;
    private long date = -1;
    private int activity = -1;
    private int subType = -1;
    private int duration = -1;
    private int distance = -1;
    private int count = -1; // also, duration
    private int intensity = -1; // also, quality of sleep
    private int weight = -1;
    private String typeName = null;


    public LogEntry(String ID, int activity)
    {
        this.ID = ID;
        this.activity = activity;
        //Todo: set date;
    }

    //Todo: DATA BASE
    public static String[] getSubtypes(int option)
    {
        String[][] subTypes = {
                {"Recreation", "Calisthenics", "Aerobics", "Weightlifting"},
                {"Fruits and Vegetables", "Water", "Sweets"},
                {},
                {}
        }; //depending on the activity
        return subTypes[option];
    }
    public void setSubtype(int subType)
    {
        this.subType = subType;
    }
    public static String[] getFirstDropdownValues(int activity, int subType)
    {
        String[][][] firstDropdownValues =
                {
                        {
                                {
                                        "Soccer", "Kayaking"
                                },
                                {
                                        "pushups", "yoga"
                                },
                                {
                                        "jogging", "biking"
                                },
                                {
                                        "group1", "group2", "group3"
                                }

                        },
                        {

                        },
                        {

                        },
                        {

                        }

                }
                ;
        return firstDropdownValues[activity][subType];
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
    public static int[] getSecondDropdownValues(int activity, int subType)
    {
        int[][][] secondDropdownValues =
        {{{1, 2, 3},{4,5,6},{7,8},{9,10,11,12}},{{1,2},{3,6,7,8,},{9}},{{5,6,7}},{{8,9,10}}};

        return secondDropdownValues[activity][subType];
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
    public static int[] getThirdDropdownValues(int activity, int subType)
    {
        int[][][] thirdDropdownValues =
            {{{1, 2, 3},{},{7,8},{}},{{}},{{9, 10, 11, 12, 13}},{{}}};
        ;
        return thirdDropdownValues[activity][subType];
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

    public String getDate()
    {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        String day = dayFormat.format(this.date);

        SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
        String month = monthFormat.format(this.date);

        SimpleDateFormat weekdayFormat = new SimpleDateFormat("EE");
        String dayOfWeek = weekdayFormat.format(this.date);

        return dayOfWeek + ", " + month + " " + day + "7th";
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
