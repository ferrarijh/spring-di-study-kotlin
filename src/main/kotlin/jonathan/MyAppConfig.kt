package jonathan

import jonathan.entity.Exam
import jonathan.entity.MyExam
import jonathan.ui.ExamConsole
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@ComponentScan("jonathan.ui")
@Configuration
open class MyAppConfig{
    @Bean
    open fun exam1(): Exam = MyExam()

}