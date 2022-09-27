package chapter06

import scala.beans.BeanProperty

object Test03_Class {
    def main(args: Array[String]): Unit = {
        // 创建一个对象
        val student = new Student()
        //    student.name   // error, 不能访问private属性
        println(student.age)
        println(student.sex)
        student.sex = "female"
        println(student.sex)
    }
}

// 定义一个类，类和属性默认为public
class Student {
    // 定义属性
    private var name: String = "alice"
    @BeanProperty // 相当于对私有属性的get  set方法
    var age: Int = _ // 不给变量固定一个值，_相当于给了一个空值
    var sex: String = _
}
