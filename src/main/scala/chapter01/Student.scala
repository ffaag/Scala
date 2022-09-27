package chapter01

/**
 * @author ZuYingFang
 * @time 2022-03-08 21:13
 * @description
 */
class Student(var name: String, var age: Int) {
    def printInfo(): Unit = {
        println(name + " " + age + " " + Student.school)
    }
}

// 引入伴生对象
object Student {
    val school: String = "qin"

    def main(args: Array[String]): Unit = {
        val alice = new Student("alice", 20)
        val bob = new Student("bob", 23)

        alice.printInfo()
        bob.printInfo()
    }
}
