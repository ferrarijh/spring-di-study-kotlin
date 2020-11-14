package jonathan.with.spring

import jonathan.ui.ExamConsole
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

fun main(){

    val context: ApplicationContext = ClassPathXmlApplicationContext("setting.xml")

    //get instance ref by its id in setting.xml
    //ExamConsole console = (ExamConsole) context.getBean("mConsole");

    //get instance ref by its class name

    //get instance ref by its id in setting.xml
    //ExamConsole console = (ExamConsole) context.getBean("mConsole");

    //get instance ref by its class name
    val console: ExamConsole = context.getBean(ExamConsole::class.java)

    console.print()
}