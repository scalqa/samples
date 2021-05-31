package example; package val_container.idx; import language.implicitConversions

object SearchOrdered:

  def main(sa:  Array[String]): Unit =

    val x = ~~(1, 2, 3, 5).flatMap(v => ~~(v).repeat(4)).><

    x.~.zipIndex.print

    x.orderedSearch(0).tp    // Prints: 0 <>> 0

    x.orderedSearch(2).tp    // Prints: 4 <>> 5

    x.orderedSearch(2, 5).tp // Prints: 4 <>> 8

    x.orderedSearch(4).tp    // Prints: 12 <>> 12

    x.orderedSearch(6).tp    // Prints: 16 <>> 16

