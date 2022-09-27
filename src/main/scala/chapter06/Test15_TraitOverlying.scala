package chapter06

object Test15_TraitOverlying {
    def main(args: Array[String]): Unit = {
        val student = new Student15
        student.increase()

        // 钻石问题特征叠加
        val myFootBall = new MyFootBall
        println(myFootBall.describe()) // 从右往左，依次叠加
    }
}

// 定义球类特征
trait Ball {
    def describe(): String = "ball"
}

// 定义颜色特征
trait ColorBall extends Ball {
    var color: String = "red"

    override def describe(): String = color + "-" + super.describe()
}

// 定义种类特征
trait CategoryBall extends Ball {
    var category: String = "foot"

    override def describe(): String = category + "-" + super.describe()
}

// 定义一个自定义球的类
class MyFootBall extends CategoryBall with ColorBall {
    override def describe(): String = "my ball is a " + super[CategoryBall].describe() // 指定supe调用的方法
}

trait Knowledge15 {
    var amount: Int = 0

    def increase(): Unit = {
        println("knowledge increased")
    }
}

trait Talent15 {
    def singing(): Unit

    def dancing(): Unit

    def increase(): Unit = {
        println("talent increased")
    }
}

class Student15 extends Person13 with Talent15 with Knowledge15 {
    override def dancing(): Unit = println("dancing")

    override def singing(): Unit = println("singing")

    override def increase(): Unit = { // 产生混用情况，对方法进行重写
        super[Person13].increase() // 指定super对应的类或者特质，如果不指定是使用的最后那一个Knowledge15
    }
}