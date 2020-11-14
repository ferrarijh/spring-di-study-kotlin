package jonathan.entity

class MyExam(
    var kor: Int = 0,
    var eng: Int = 0,
    var math: Int = 0,
    var com: Int = 0
) : Exam {

    override fun total(): Int {
        return kor + eng + math + com
    }

    override fun average(): Float {
        return total() / 4.0f
    }

    override fun print(){
        println("kor: $kor, eng: $eng, math: $math, com: $com")
    }
}
