import java.util.Date;
public interface Student_Interface {
    java.util.Date time_start = new Date();
    String affiliation = "NKU";
    String email = "abc@gmail.com";
    String phone = "859 913 1234";


    void takingCourse();
    void exam();
    void project();
    void attendClub();

    void test();

    //abstract void test();
}
