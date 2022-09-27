package chapter08

object Test04_MatchObject {
    def main(args: Array[String]): Unit = {
        val student = new Student("alice", 19)

        // 针对对象实例的内容进行匹配
        // 当将 Student("alice", 18)写在 case 后时[case Student("alice", 18) => "Alice, 18"]，
        // 会默认调用 unapply方法(对象提取器)，student 作为 unapply 方法的参数，unapply 方法
        // 将 student 对象的 name 和 age 属性提取出来，与 Student("alice", 18)中的属性值进行匹配
        val result = student match {
            case Student("alice", 18) => "Alice, 18"
            case _ => "Else"
        }

        println(result)
    }
}

// 定义类
class Student(val name: String, val age: Int)

// 定义伴生对象
object Student {
    def apply(name: String, age: Int): Student = new Student(name, age)

    // 必须实现一个unapply方法，用来对对象属性进行拆解
    // case 中对象的 unapply 方法(提取器)返回 Some，且所有属性均一致，才算匹配成功,
    // 属性不一致，或返回 None，则匹配失败。
    // 若只提取对象的一个属性，则提取器为 unapply(obj:Obj):Option[T]
    // 若提取对象的多个属性，则提取器为 unapply(obj:Obj):Option[(T1,T2,T3…)]
    // 若提取对象的可变个属性，则提取器为 unapplySeq(obj:Obj):Option[Seq[T]]
    def unapply(student: Student): Option[(String, Int)] = {
        if (student == null) {
            None
        } else {
            Some((student.name, student.age))
        }
    }
}