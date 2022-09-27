package chapter08

object Test05_MatchCaseClass {
    def main(args: Array[String]): Unit = {
        val student = Student1("alice", 18)

        // 针对对象实例的内容进行匹配
        val result = student match {
            case Student1("alice", 18) => "Alice, 18"
            case _ => "Else"
        }

        println(result)
    }
}

// 定义样例类，也就是自动帮我们创建了伴生对象并且实现了apply和unApply方法
case class Student1(name: String, age: Int)