package jonathan.ui

import jonathan.entity.Exam

class GridExamConsole(private var exam: Exam? = null) : ExamConsole {   //spring requires default constructor(with no

    override fun print() {
        System.out.printf("total\taverage\n")
        System.out.printf("%d\t%.3f", exam?.total(), exam?.average())
    }

    override fun setExam(e: Exam?) {
        exam = e
    }
}
