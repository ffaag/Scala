package chapter08

object Test02_MatchTypes {
    def main(args: Array[String]): Unit = {
        // 1. 匹配常量
        def describeConst(x: Any): String = x match {
            case 1 => "Int one"
            case "hello" => "String hello"
            case true => "Boolean true"
            case '+' => "Char +"
            case _ => "" // 匹配输入的值，但不做处理
        }

        println(describeConst("hello"))
        println(describeConst('+'))
        println(describeConst(0.3))

        println("==================================")

        // 2. 匹配类型
        def describeType(x: Any): String = x match {
            case i: Int => "Int " + i
            case s: String => "String " + s
            case list: List[String] => "List " + list
            case array: Array[Int] => "Array[Int] " + array.mkString(",")
            case a => "Something else: " + a // 一样匹配输入的值，并且可以拿到这个值
        }

        println(describeType(35))
        println(describeType("hello"))
        println(describeType(List("hi", "hello")))
        println(describeType(List(2, 23)))
        println(describeType(Array("hi", "hello")))
        println(describeType(Array(2, 23)))

        // 3. 匹配数组，对集合精准匹配
        for (arr <- List(
            Array(0),
            Array(1, 0),
            Array(0, 1, 0),
            Array(1, 1, 0),
            Array(2, 3, 7, 15),
            Array("hello", 1, 30),
        )) {
            val result = arr match {
                case Array(0) => "0"
                case Array(1, 0) => "Array(1, 0)"
                case Array(x, y) => "Array: " + x + ", " + y // 匹配两元素数组
                case Array(0, _*) => "以0开头的数组" // 匹配以0开头的数组
                case Array(x, 1, z) => "中间为1的三元素数组"
                case _ => "something else"
            }

            println(result)
        }

        println("=========================")

        // 4. 匹配列表
        // 方式一
        for (list <- List(
            List(0),
            List(1, 0),
            List(0, 0, 0),
            List(1, 1, 0),
            List(88),
            List("hello")
        )) {
            val result = list match {
                case List(0) => "0"
                case List(x, y) => "List(x, y): " + x + ", " + y
                case List(0, _*) => "List(0, ...)"
                case List(a) => "List(a): " + a
                case _ => "something else"
            }
            println(result)
        }

        // 方式二
        val list1 = List(1, 2, 5, 7, 24)
        val list = List(24)

        list match {
            // 这里用的双冒号是匹配的单个数字，比如first匹配第一个，second匹配第二个，rest匹配剩下的列表
            case first :: second :: rest => println(s"first: $first, second: $second, rest: $rest")
            case _ => println("something else")
        }


        println("===========================")
        // 5. 匹配元组
        for (tuple <- List(
            (0, 1),
            (0, 0),
            (0, 1, 0),
            (0, 1, 1),
            (1, 23, 56),
            ("hello", true, 0.5)
        )) {
            val result = tuple match {
                case (a, b) => "" + a + ", " + b // 匹配两个元素
                case (0, _) => "(0, _)" // 匹配两个元素，第一个为0
                case (a, 1, _) => "(a, 1, _) " + a // 匹配三个元素，中间为1
                case (x, y, z) => "(x, y, z) " + x + " " + y + " " + z
                case _ => "something else"
            }
            println(result)
        }
    }
}
