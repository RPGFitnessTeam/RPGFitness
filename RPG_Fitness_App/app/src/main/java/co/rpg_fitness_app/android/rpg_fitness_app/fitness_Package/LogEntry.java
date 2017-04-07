package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;



import java.io.Serializable;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class LogEntry implements Serializable{

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
    private String typeName = "";

    public LogEntry(int activity)
    {
        this.ID = UUID.randomUUID().toString();;
        this.activity = activity;
        //Todo: set date;
    }


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
    public static String[] getSecondDropdownValues(int activity, int subType)
    {
        String[][][] secondDropdownValues =
        {{      {"15 min", "30 min", "45 min", "1 hour", "2 hour", "3 hour"},
                {"15 min", "30 min", "45 min", "1 hour", "2 hour", "3 hour"},
                {"1 mile","2 mile","3 mile","4 mile","5 mile","6 mile","7 mile","8 mile","9 mile", "10 mile","15mile", "20 mile"},
                {"1 = very light","2 = light","3 = moderate", "4 = heavy","5 = very heavy"}
        }, {    {"1","2","3","4","5","6","7","8","9","10"},
                {"1","2","3","4","5","6","7","8","9","10"},
                {"1","2","3","4","5","6","7","8","9","10"}
        }, {    {"1 = very poor", "2 = poor", "3 = fine", "4 = good", "5 = very good"}
        }, {    {"40 kg","45 kg","50 kg","55 kg", "60 kg", "65 kg", "70 kg","75 kg", "80 kg", "85 kg", "90 kg", "95 kg", "100 kg"}
        }};

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
    public static String[] getThirdDropdownValues(int activity, int subType)
    {
        String[][][] thirdDropdownValues =
            {{
                    {"1 = very light","2 = light","3 = moderate", "4 = heavy","5 = very heavy"},
                    {},
                    {"15 min", "30 min", "45 min", "1 hour", "1 hour", "2 hour", "2 hour", "3 hour"},
                    {}
            },      {{}
            },      {{"1 hour", "2 hour", "3 hour", "4 hour", "5 hour", "6 hour", "7 hour", "8 hour",
                    "9 hour", "10 hour", "11 hour", "12 hour", "13 hour", "14 hour", "15 hour"}},
                    {{}}};
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

        return dayOfWeek + ", " + month + " " + day + "th";
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getActivity() {

        switch(this.activity)
        {
            case EXERCISE: return "Exercise";
            case NUTRITION: return "Nutrition";
            case SLEEP: return "Sleep";
            case WEIGHT: return "Weight";

            default:return "Unknown";
        }

    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public String getSubType() {

        if(this.subType == -1)
        {
            return "";
        }
        else{

            return getSubtypes(this.activity)[this.subType] + "";
        }
    }

    public void setSubType(int subType) {
        this.subType = subType;
    }

    public int getDuration() {
        return duration;
    }

    public String getFirstDropdown()
    {
        if(this.activity == EXERCISE) {
            return "Type = " + this.typeName;
        }
        else return "";
    }

    public String getSecondDrop()
    {
        switch(this.activity)
        {
            case EXERCISE :
            {
                switch(this.subType) {
                    case RECREATION:
                        if (this.duration == 1 || this.duration == 2 || this.duration == 3) {
                            return "Duration = " + this.duration + " hour";
                        }
                        else
                        {
                            return "Duration = " + this.duration + " min";
                        }
                    case CALISTHENICS:
                        if (this.duration == 1 || this.duration == 2 || this.duration == 3) {
                            return "Duration = " + this.duration + " hour";
                        }
                        else {
                            return "Duration = " + this.duration + " min";
                        }
                    case AEROBICS:
                        return "Distance = " + this.distance + " mile";
                    case WEIGHTLIFTING:
                        switch (this.intensity)
                        {
                            case 1: return "Intensity = very light";
                            case 2: return "Intensity = light";
                            case 3: return "Intensity = moderate";
                            case 4: return "Intensity = heavy";
                            case 5: return "Intensity = very heavy";
                            default:return "";
                        }
                    default: return "";
                }
            }
            case NUTRITION :
            {
                switch(this.subType)
                {
                    case FR_VEG: return "Servings = " + this.count;
                    case WATER: return "Glasss = " + this.count;
                    case SWEETS: return "Servings = " + this.count;
                    default: return "";
                }
            }
            case SLEEP :
            {
                switch (this.intensity)
                {
                    case 1: return "Quality of Sleep = very poor";
                    case 2: return "Quality of Sleep = poor";
                    case 3: return "Quality of Sleep = fine";
                    case 4: return "Quality of Sleep = good";
                    case 5: return "Quality of Sleep = very good";
                    default:return "";
                }
            }
            case WEIGHT :
            {
                return "Current Weight = " + this.weight + " kg";
            }
            default : return "";
        }
    }
    public String getThirdDrop()
    {
        switch(this.activity)
        {
            case EXERCISE :
            {
                switch(this.subType) {
                    case RECREATION:
                        switch (this.intensity)
                        {
                            case 1: return "Intensity = very light";
                            case 2: return "Intensity = light";
                            case 3: return "Intensity = moderate";
                            case 4: return "Intensity = heavy";
                            case 5: return "Intensity = very heavy";
                            default:return "";
                        }
                    case AEROBICS:
                        if (this.duration == 1 || this.duration == 2 || this.duration == 3) {
                            return "Duration = " + this.duration + " hour";
                        }
                        else
                        {
                            return "Duration = " + this.duration + " min";
                        }
                    default: return "";
                }
            }
            case SLEEP :
            {
                return "Duration = " + this.duration + " hour";
            }
            default: return "";
        }
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
