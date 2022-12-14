package chapter07

import scala.collection.mutable

object Test07_MutableSet {
    def main(args: Array[String]): Unit = {
        // 1. 创建set
        val set1: mutable.Set[Int] = mutable.Set(13, 23, 53, 12, 13, 23, 78)
        println(set1)

        println("==================")

        // 2. 添加元素
        val set2 = set1 + 11
        println(set1)
        println(set2)

        set1 += 11
        println(set1)

        val flag1 = set1.add(10) // flag是个布尔值，确定添加至是否在集合中，在集合中就返回false
        println(flag1)
        println(set1)
        val flag2 = set1.add(10)
        println(flag2)
        println(set1)

        println("==================")

        // 3. 删除元素
        set1 -= 11
        println(set1)

        val flag3 = set1.remove(10)
        println(flag3)
        println(set1)
        val flag4 = set1.remove(10)
        println(flag4)
        println(set1)

        println("==================")

        // 4. 合并两个Set
        val set3 = mutable.Set(13, 12, 13, 27, 98, 29)
        println(set1)
        println(set3)

        println("==================")
        val set4 = set1 ++ set3
        set1 ++= set3
        println(set1)
        println(set3)
        println(set4)


    }
}
