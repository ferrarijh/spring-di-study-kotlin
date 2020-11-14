# Spring Study (Kotlin)
* Spring requires default constructor.

In the example Spring will inject dependencies on ```GridExampleConsole```.<br/>
Below evokes exception: (```No default constructor found; nested exception is java.lang.NoSuchMethodException```:)
```kotlin
class GridExamConsole(private var exam: Exam?): ExamConsole{
    //...
}
```

Solution 1: (explicitly define constructors including default constructor)
```kotlin
class GridExamConsole: ExamConsole{
    private var exam: Exam?
    constructor(){  //default constructor!
        exam = null
    }
    constructor(e: Exam?){
        exam = e
    }
}
```

Solution 2: (BETTER)
```kotlin
//internally creates default constructor
class GridExamConsole(private var exam: Exam? = null): ExamConsole{
    //...
}
```