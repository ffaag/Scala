package chapter06

object Test04_Access {
    def main(args: Array[String]): Unit = {
        // 创建对象
        val person: Person = new Person()
        //    person.idCard    // error
        //    person.name    // error    只能当前类和子类访问到，这里到了伴生对象中，访问不到的
        println(person.age)
        println(person.sex)

        person.printInfo()

        // val 修饰对象，不能改变对象的引用（即：内存地址），可以改变对象属性的值。
        // var 修饰对象，可以改变对象的引用（即：内存地址），也可以改变对象属性的值。
        var worker: Worker = new Worker()
        worker = new Worker()
        worker.age = 23
        worker.printInfo()
    }
}

// 定义一个子类
class Worker extends Person {
    // 重写父类方法
    override def printInfo(): Unit = {
        //    println(idCard)    // error
        name = "bob"
        age = 25
        sex = "male"

        println(s"Worker: $name $sex $age")
    }

}