package jonathan.with.spring

import jonathan.MyAppConfig
import jonathan.entity.Exam
import jonathan.ui.ExamConsole
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

fun main(){

    /** with xml **/
//    val context: ApplicationContext = ClassPathXmlApplicationContext("setting-xml-least.xml")

    //get instance ref by its id in setting-xml-only.xml
//    ExamConsole console = (ExamConsole) context.getBean("mConsole");

    //get instance ref by its class name
//    val console: ExamConsole = context.getBean(ExamConsole::class.java)
//
//    console.print()

    //array with spring
//    val exams = context.getBean("exams") as ArrayList<Exam>
//    exams.forEach{
//        it.print()
//    }

    /** without xml **/
    val context = AnnotationConfigApplicationContext(MyAppConfig::class.java)
    val console = context.getBean("console") as ExamConsole
    console.print()
}