package jonathan.entity

class MyExam : Exam {
    private val kor = 0
    private val eng = 0
    private val math = 0
    private val com = 0
    override fun total(): Int {
        return kor + eng + math + com
    }

    override fun average(): Float {
        return total() / 4.0f
    }
}
