package hr.tvz.wauj.vjezbe.app.course;

public class CourseDTO{

    private String name;
    private Integer numberOfECTS;

    public CourseDTO(String name, Integer numberOfECTS) {
        this.name = name;
        this.numberOfECTS = numberOfECTS;
    }

    public CourseDTO(String name) {

    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "CourseDTO{" +
                "name='" + name + '\'' +
                ", numberOfECTS=" + numberOfECTS +
                '}';
    }
}
