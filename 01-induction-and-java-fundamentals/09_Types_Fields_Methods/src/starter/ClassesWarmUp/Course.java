package starter.ClassesWarmUp;

public class Course {
    private String name, tutor;
    private int duration;

    // amend this constructor to receive 3 params called
    // name, tutor and numberDays and then store them
    public Course()
    {

    }

    public String getDetails()
    {
        return String.format("Course - %, delivered by % for % days", 
                             name, tutor, "??????");
    }
}
