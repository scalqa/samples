package example; package j.json; import language.implicitConversions

//SBT: runMain example.j.json.Try

object Try:

  def main(sa:  Array[String]): Unit =

    var s = "{\"aaa\":\"bbb\",  \"employees\":[\n" +
      "    {\"firstName\":\"John\", \"lastName\":1},\n" +
      "    {\"firstName\":\"Anna\", \"lastName\":2},\n" +
      "    {\"firstName\":\"Peter\",\"lastName\":3}\n" +
      "]}"

    s.tp

    val o = J.Json.parseObject_??(s).value

    s = J.Json.format(o)

    s.tp

