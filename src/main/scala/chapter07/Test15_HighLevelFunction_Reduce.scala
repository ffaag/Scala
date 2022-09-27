package chapter07

/**
 * 归约聚合，通过指定的逻辑将集合中的数据进行聚合，从而减少数据，最终获得结果
 */

object Test15_HighLevelFunction_Reduce {
    def main(args: Array[String]): Unit = {
        val list = List(1, 2, 3, 4)

        // 1. reduce 默认为从左至右以此执行函数
        println(list.reduce(_ + _)) // (((1+2)+3)+4)
        println(list.reduceLeft(_ + _)) // (((1+2)+3)+4)
        println(list.reduceRight(_ + _)) // (1+(2+(3+4)))

        println("===========================")

        val list2 = List(3, 4, 5, 8, 10)
        println(list2.reduce(_ - _)) // -24
        println(list2.reduceLeft(_ - _))
        println(list2.reduceRight(_ - _)) // 3 - (4 - (5 - (8 - 10))), 6

        println("===========================")


        // 2. fold
        println(list.fold(10)(_ + _)) // ((((10 + 1) + 2) + 3) + 4)
        println(list.foldLeft(10)(_ - _)) // ((((10 - 1) - 2) - 3) - 4)
        println(list2.foldRight(11)(_ - _)) // (3 - (4 - (5 - (8 - (10 - 11))))),  -5
    }
}
