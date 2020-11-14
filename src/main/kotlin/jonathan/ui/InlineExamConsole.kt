package jonathan.ui

import jonathan.entity.Exam

class InlineExamConsole constructor(private var exam: Exam?) : ExamConsole {
    override fun print() {
        System.out.printf("total: %d, average: %.3f", exam?.total(), exam?.average())
    }

//    override fun setExam(e: Exam?) {
//        exam = e
//    }
}
