package example; package fx.chart; import language.implicitConversions

//SBT: runMain example.fx.chart.Lines

object Lines extends Fx.Application(1000, 500, "Chart Test"):

  val buffer = Idx.OM[Int]().^(b =>{
    b ++= (0 <> 1)
    b.onChange(_.~.print)

    val stream: Int.~ = 2 <> 1000
    J.scheduleEvery(1.Second, b += stream.read).cancelIfTrue(isStopped)
  })

  object View extends Fx.Chart.XY.X.Lines(new Fx.Chart.Axis.X.Time(), new Fx.Chart.Axis.X.Ints("Int")):
    val Now = Time()
    data += new Line("Seconds", (0 <>> 100).~.map(i => (Now + i.Seconds, i)))
    data += new Line("Minutes", (0 <>> 100).~.map(i => (Now + i.Minutes, i)))
    data += new Line("Hours",   buffer.mutableMap_^(i => new ItemBase(Now + i.Hours, i), (it: ItemBase) => it.y))
