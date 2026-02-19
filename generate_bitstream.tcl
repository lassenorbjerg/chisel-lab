set_property board_part digilentinc.com:basys3:part0:1.2 [current_project]
add_files -norecurse C:/Users/Administrator/Desktop/dtu/F26/chisel-lab/lab3/Mux4.v
add_files -fileset constrs_1 -norecurse C:/Users/Administrator/Desktop/dtu/F26/chisel-lab/lab3/Basys3_mux4.xdc
update_compile_order -fileset sources_1
launch_runs impl_1 -to_step write_bitstream -jobs 4

open_hw_manager
connect_hw_server -allow_non_jtag
