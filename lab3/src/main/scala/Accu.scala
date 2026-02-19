import chisel3._

class Accu extends Module {
  val io = IO(new Bundle {
    val din = Input(UInt(8.W))
    val setZero = Input(Bool())
    val dout = Output(UInt(8.W))
  })

  val res = Wire(UInt())

  // ***** your code starts here *****

  val acc_reg = RegInit(0.U(8.W))
  when (io.setZero) {
    acc_reg := 0.U
  } .otherwise {
    acc_reg := acc_reg + io.din
  }
  res := acc_reg
  // ***** your code ends here *****

  io.dout := res
}
