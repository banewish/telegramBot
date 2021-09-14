package tasks

object Training extends App {

  val listInit1 = List(1,2,3,4,2)  // инициализация
  val listInit2: List[Int] = (67 to 71).toList
  val listWithOtherHead =  5 +: listInit1 // добавление элемента в начало списка
  val listWithOtherTail = 6 :: listInit1 // добавление элемента в конец списка

 val listToString = listInit1.foreach(elem => println(elem.toString)) // показ всех элементов списка
  println(listInit1)

val droppedList =  listInit1.drop(listInit1.length)   // удаление всех элементов списка
  println(droppedList)

    val listSize = listInit1.length  // определение количества элементов списка *length = size*
  println(listSize)

  val listIsEmpty = listInit1.isEmpty  // проверка списка на пустоту
println(listIsEmpty)

  val listDeleteHead = listInit1.drop(listInit1.head)  // удаление первого элемента
  println(listDeleteHead)

  val listDeleteTail = listInit1.init   // удаление последнего элемента
  println(listDeleteTail)

  val findByList = listInit1.indexOf(3)   // поиск данного значения в списке
  println(findByList)

     val maxValueOfList = listInit1.max   // поиск наибольшего и найменьшего значений в списке
  println(maxValueOfList)

  val minValueOfList = listInit1.min // найменьшего
  println(minValueOfList)

  val deleteByValue = listInit1.filter(in => in != 2) // Удаление элемента списка с данным значением
  println(deleteByValue)  // Удаление элемента списка с данным значением ???

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

   val distinctList = listInit1.distinct   // Удаление из списка элементов, значения которых уже встречались в предыдущих элементах.
  println(distinctList)

     val reverseList = listInit1.reverse // Изменение порядка элементов на обратный.




}
