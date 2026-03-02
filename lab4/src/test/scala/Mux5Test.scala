import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class Mux5Test extends AnyFlatSpec with ChiselScalatestTester {
  for (i <- 0 until 5) {
    s"Mux5_$i " should "pass" in {
      test(new Mux5()) { dut =>
          dut.io.a.poke(0.U)
          dut.io.b.poke(1.U)
          dut.io.c.poke(2.U)
          dut.io.d.poke(3.U)
          dut.io.e.poke(4.U)
          dut.io.sel.poke(i.U)
          dut.clock.step(1)
          dut.io.y.expect(i.U)
        }
      }
  }
  s"Mux5_5 " should "pass" in {
      test(new Mux5()) { dut =>
        dut.io.a.poke(0.U)
        dut.io.b.poke(0.U)
        dut.io.c.poke(0.U)
        dut.io.d.poke(0.U)
        dut.io.e.poke(4.U)
        dut.io.sel.poke(4.U)
        dut.clock.step(1)
        dut.io.y.expect(4.U)
      }
  }
    for (i <- 0 until 5) {
      for (j <- 0 until 256) {
        s"Mux5_${j}_${i} " should "pass" in {
          test(new Mux5()) { dut =>
              dut.io.a.poke(0.U)
              dut.io.b.poke(0.U)
              dut.io.c.poke(0.U)
              dut.io.d.poke(0.U)
              dut.io.e.poke(0.U)
              i match {
                case 0 => dut.io.a.poke(j.U)
                case 1 => dut.io.b.poke(j.U)
                case 2 => dut.io.c.poke(j.U)
                case 3 => dut.io.d.poke(j.U)
                case 4 => dut.io.e.poke(j.U)
                case _ => dut.io.e.poke(0.U)
              }
              dut.io.sel.poke(i.U)
              dut.clock.step(1)
              dut.io.y.expect(j.U)
            }
          }
      }
  }
}
