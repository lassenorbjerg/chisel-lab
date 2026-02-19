import chisel3._

class Count6 extends Module {
  val io = IO(new Bundle {
    val dout = Output(UInt(8.W))
  })

  val res = Wire(UInt())

  // ***** your code starts here *****
  val cnter_reg = RegInit(0.U(4.W))
  when (cnter_reg === 6.U) {
    cnter_reg := 0.U
  } .otherwise {
    cnter_reg := cnter_reg + 1.U
  }
  res := cnter_reg
  // ***** your code ends here *****

  io.dout := res
}
