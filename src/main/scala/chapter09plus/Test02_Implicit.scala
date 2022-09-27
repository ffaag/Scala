package chapter09plus

object Test02_Implicit {
    def main(args: Array[String]): Unit = {

        val new12 = new MyRichInt(12)
        println(new12.myMax(15))

        // 1. 隐式函数，使用implicit关键字声明
        implicit def convert(num: Int): MyRichInt = new MyRichInt(num)

        // 当想调用对象功能时，如果编译错误，那么编译器会尝试在当前作用域范围内查找能调用对应功能的转换规则，
        // 这个调用过程是由编译器完成的，所以称之为隐式转换。也称之为自动转换
        println(12.myMax(15))

        println("============================")

        // 2. 隐式类，构造方法声明为隐式
        implicit class MyRichInt2(val self: Int) {
            // 自定义比较大小的方法
            def myMax2(n: Int): Int = if (n < self) self else n

            def myMin2(n: Int): Int = if (n < self) n else self
        }

        println(12.myMin2(15))

        println("============================")

        // 3. 隐式参数，可以不传参，他自己根据参数类型去找符合条件的作为参数

        implicit val str: String = "alice"
        //    implicit val str2: String = "alice2"
        implicit val num: Int = 18

        def sayHello()(implicit name: String): Unit = {
            println("hello, " + name)
        }

        def sayHi(implicit name: String = "atguigu"): Unit = {
            println("hi, " + name)
        }

        // 没有传递参数
        sayHello
        sayHi

        // 简便写法
        def hiAge(): Unit = {
            println("hi, " + implicitly[Int])
        }

        hiAge()
    }
}

// 自定义类
class MyRichInt(val self: Int) {
    // 自定义比较大小的方法
    def myMax(n: Int): Int = if (n < self) self else n

    def myMin(n: Int): Int = if (n < self) n else self
}
