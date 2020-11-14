package jonathan.ui

import jonathan.entity.Exam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component("console")
class GridExamConsole : ExamConsole {   //spring requires default constructor(with no

    @Autowired(required = false)
    @Qualifier("exam1")
    private var exam: Exam? = null

    override fun print() {
        System.out.printf("total\taverage\n")
        System.out.printf("%d\t%.3f\n", exam?.total(), exam?.average())
    }

//    fun setExam(e: Exam?) {
//        exam = e
//    }
}
