package tasks

import akka.stream.scaladsl.OrElse

import scala.math.random
import scala.util.Random
import scala.util.Random.{nextInt, nextPrintableChar}

object Training extends App {

  val listInit1 = List(1,2,3,4,2,1)  // инициализация
  val listInit2: List[Int] = (67 to 71).toList

  val listWithOtherHead =  5 +: listInit1 // добавление элемента в начало списка
  val listWithOtherTail = listInit1 :+ 6 // добавление элемента в конец списка

 val listToString = listInit1.foreach(println) // показ всех элементов списка
  println(listInit1)

val droppedList =  listInit1.drop(listInit1.length)   // удаление всех элементов списка
  println(droppedList)

    val listSize = listInit1.length  // определение количества элементов списка *length = size*
  println(listSize)

  val listIsEmpty = listInit1.isEmpty  // проверка списка на пустоту
println(listIsEmpty)

  val listDeleteHead  = listInit1.drop(listInit1.headOption getOrElse 0 ) // удаление первого элемента  *рассмотреть headOption, lastOption*
  println(listDeleteHead)

  val listDeleteTail = listInit1.reverse.drop(listInit1.headOption getOrElse 0 ).reverse // удаление последнего элемента
  println(listDeleteTail)

  val findByList = listInit1.indexOf(3)   // поиск данного значения в списке
  println(findByList)

     val maxValueOfList = listInit1.max   // поиск наибольшего и найменьшего значений в списке
  println(maxValueOfList)

  val minValueOfList = listInit1.min // найменьшего
  println(minValueOfList)

  val deleteByValue = listInit1.filterNot(in => in == 2) // Удаление элемента списка с данным значением
  println(deleteByValue)

  val listMap = listInit1.map(in =>
    if(in == 2) { 222
    } else {
      in
    }
  )  // Изменение всех элементов списка с данным значением на новое.
  println(listMap)



      // Определить, является ли массив симметричным относительно середины
  // !думаю что нужно разделить список на 2 части по средине
  // и проверить их на различие, вернуть значение Boolean


      val distinctListWithLength = listInit1.distinct.length // Определение, сколько различных значений содержится в списке.
  println(distinctListWithLength)

   val distinctList = listInit1.toSet.toList
  // Удаление из списка элементов, значения которых уже встречались в предыдущих элементах.
  println(distinctList)

     val reverseList = listInit1.reverse // Изменение порядка элементов на обратный.

  val sort1 = listInit1.sortWith(_ > _)
  println(sort1)
  println(listInit1.sorted)
  val sort2 = listInit1.sortWith(_ < _)
  println(sort2)
       // СОРТИРОВКА, посмотреть(чётность, от большего к меньшему)!!!
       // обьединение списков

  val sortListByParity = listInit1.filter(_ % 2 == 0)
println(sortListByParity)
val sortByParity = listInit1.count(x =>{x % 2 == 0})  // выводит количество четных символов
println(sortByParity)



val combList = listInit1 ++ listInit2
  println(combList)
  val combList1 = listInit1 ::: listInit2
  println(combList1)
  val combList2 = List.concat(listInit1, listInit2)
  println(combList2)


  println(" ")
println("next")
println("next")
println("next")
  println(" ")

val line: String = "lines"

  val newLine = (1 to 3).toSeq.map(_ => line).mkString(",")   // Дана строка. Вывести ее три раза через запятую и показать количество символов в ней.
  println(newLine)
  println(newLine.length)

  val charOption = Map("true" -> line(line.length / 2), "false" -> 0)
  val character = line(0)    //     Дана строка. Вывести первый, последний и средний (если он есть)) символы.
  val character2 = line(line.length - 1)
  val character3 = line(line.length / 2)  // сделать option
  val findMiddle = line.count(x =>{line.length % 2 == 0})
  val v1  = if (findMiddle == 0) {
    println(charOption.get("true"))
  } else {
    charOption.get("false")
  }
  println(v1)
  println(character)
  println(character2)

    println(" ")


    println(line.take(3))
  if (line.length > 5) {
    println(line.takeRight(3))  // Дана строка. Вывести первые три символа и последний три символа, если длина строки больше 5. Иначе вывести первый символ столько раз, какова длина строки.
  } else {
    line.map(_=> println(line(0)))
  }

//  val combString = Seq(1,2,3,4,5,6,7,8,9,10)

//  val n10 = Seq(1,2,3,4,5,6,7,8,9,10).map(
//    n =>
//      if (n%2 == 0) nextInt(100)
//      else "a")
//  println(n10)
 //Сформировать строку из 10 символов. На четных позициях должны находится четные цифры, на нечетных позициях - буквы.




}
