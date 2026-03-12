import chisel3._

class CountSevenSeg extends Module {
  val io = IO(new Bundle {
    val seg = Output(UInt(7.W))
    val an = Output(UInt(4.W))
  })

  val sevSeg = WireDefault("b1111111".U(7.W))
  // *** your code starts here
  val sevSegDec = Module(new SevenSegDecoder())
  val clk_reg = RegInit(0.U(4.W))
  val cnt_reg = RegInit(0.U(4.W))

  val MAX_CLK = 50000000
  val MAX_CNT = 16

  clk_reg := clk_reg + 1.U
  when (clk_reg >= (MAX_CLK - 1).U) {
    clk_reg := 0.U
    cnt_reg := cnt_reg + 1.U
    when (cnt_reg >= (MAX_CNT - 1).U) {
      cnt_reg := 0.U
    }
  }
  sevSegDec.io.sw := cnt_reg

  // *** your code ends here

  io.seg := sevSeg
  io.an := "b1110".U
}

// generate Verilog
object CountSevenSeg extends App {
  emitVerilog(new CountSevenSeg())
}
