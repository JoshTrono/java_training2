@Configuration
@ComponentScan(basePackages = "INPUT PACKAGE WHERE BEAN CLASSES ARE")
public class AppConfig {

    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl();
    }

    @Bean
    public StudentController studentController(StudentService studentService) {
        return new StudentController(studentService);
    }
}