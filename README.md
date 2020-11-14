# Spring Study (Kotlin)
* Spring requires default constructor.
* Spring enables utilizing XML file for configuration but 'annotation-only' method is more widely used.

In the example Spring will inject dependencies on `GridExampleConsole` with type `MyExam` which implements `Exam`.<br/>
Below evokes exception: (```No default constructor found; nested exception is java.lang.NoSuchMethodException```)
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

## @Autowired
* Widely used instead of configuring XML - ```setting.xml``` can be shortened with annotation ```@Autowired``` in front of member variable of dependent class.
* In the example, class ```GridExamConsole``` depends on ```MyExam``` instance.
* Can be placed in front of 1)setter, 2)property(field) and 3)constructor.

```@Autowired``` can be used as below.

setting.xml: 
```xml
...
    <context:annotation-config/>
    <bean id="exam" class="jonathan.entity.MyExam" p:kor="20" p:eng="20"/>
    <bean class="jonathan.ui.GridExamConsole"/>
...
```

GridExamConsole.kt:
```kotlin
...
    @Autowired
    private var exam: Exam? = null
...
```

Main.kt:
```kotlin
...
    val context: ApplicationContext = ClassPathXmlApplicationContext("setting.xml")
    val console: ExamConsole = context.getBean(ExamConsole::class.java)

    console.print()
...
```

## @Qualifier
* What if there's more than one bean instance of same type in ```setting.xml``` when using ```@Autowire```? (like below)

setting.xml:
```xml
    <context:annotation-config/>
    <bean id="exam2" class="jonathan.entity.MyExam" p:kor="20" p:eng="20"/>
    <bean id="exam1" class="jonathan.entity.MyExam" p:kor="10" p:eng="10"/>

    <bean class="jonathan.ui.GridExamConsole"/>
```
Spring doesn't know which one to choose between 'exam1' and 'exam2'. Here we need annotation ```@Qualifier```.
Specify which one to instantiate like below in ```GridExamConsole```(dependent class) with ```@Qualifier```. 
```kotlin
class GridExamConsole : ExamConsole {

    @Qualifier("exam1")
    @Autowired
    private var exam: Exam? = null
    
    ...
}
```
Then you'll get instance of ```MyExam``` with bean ```id="exam2"```.

## @Component
* Shortens ```setting.xml``` even more with annotation ```@Component```.

To utilize ```@Component``` add the annotation on top of the dependent class(here it's ```GridExamConsole```) and the XML as below.

setting.xml:
```xml
    <context:component-scan base-package="jonathan.ui"/>
    <bean id="exam1" class="jonathan.entity.MyExam" p:kor="10" p:eng="10"/>
```
<i>(```jonathan.ui``` is the package where ```GridConsoleExample``` is located)</i>

GridExamConsole:
```kotlin
@Component
class GridExamConsole : ExamConsole {

    @Autowired
    @Qualifier("exam1")
    private var exam: Exam? = null

...
}
```

## Getting rid of XML

`setting.xml` can be replaced with configuration class with annotation `@Configuration`.

setting.xml:
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<beans ...>
    <context:component-scan base-package="jonathan.ui"/>
    <bean id="exam1" class="jonathan.entity.MyExam"/>
...
</beans>
```

Above can be replaced with class below.

class MyAppConfig:
```kotlin
@ComponentScan("jonathan.ui")
@Configuration
open class MyAppConfig{
    @Bean
    open fun exam1(): Exam = MyExam()
}
```

Main.kt:
```kotlin
val context = AnnotationConfigApplicationContext(MyAppConfig::class.java)
val console = context.getBean("console") as ExamConsole

context.print()
```
<i>to use `.getBean("console")`, the dependent class(`GridExamConsole` here) should be annotated with `@Component("console")` as below:</i>
```kotlin
@Component("console")
class GridExamConsole : ExamConsole { ... }
```