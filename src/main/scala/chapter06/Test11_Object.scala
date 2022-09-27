package chapter06

object Test11_Object {
    def main(args: Array[String]): Unit = {
        //    val student = new Student11("alice", 18)
        //    student.printInfo()

        val student1 = Student11.newStudent("alice", 18)
        student1.printInfo()

        val student2 = Student11.apply("bob", 19)
        student2.printInfo()

        val student3 = Student11("bob", 19) // 这里构造器私有化为啥还可以私有化呢？是因为这个写法默认就是调用apply方法，同上面是一样的
        student3.printInfo()
    }
}

// 定义类，主构造器私有化，这样就不能在其他地方new对象了，只能在伴生对象中创建一个新建对象的方法，私有构造器在伴生对象里面实可以使用的
class Student11 private(val name: String, val age: Int) {
    def printInfo() {
        println(s"student: name = ${name}, age = $age, school = ${Student11.school}")
    }
}

// 伴生对象，伴生类可以使用其对应的伴生对象中的所有函数和属性
object Student11 {
    val school: String = "atguigu"

    // 定义一个类的对象实例的创建方法
    def newStudent(name: String, age: Int): Student11 = new Student11(name, age)

    def apply(name: String, age: Int): Student11 = new Student11(name, age)
}