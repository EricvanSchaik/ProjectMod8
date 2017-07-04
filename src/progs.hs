import Sprockell
hoihoi:: [Instruction]
hoihoi=

[Load (ImmValue 0) regE
Store regE (DirAddr 0)
Load (ImmValue 2) regE
Load (ImmValue 10) regD
Load (ImmValue 3) regF
Compute LtE regE regD regA
Compute Equal reg0 regA regA
Branch regA (Rel 8)
Store regE (DirAddr 0)
Load (DirAddr 0) regC
Load (ImmValue 1) regB
Compute Add regC regB regC
Store regC (DirAddr 0)
Compute Add regE regF regE
Jump (Abs 5)
Load (DirAddr 0) regE
WriteInstr regE numberIO
EndProg
]
main = run [hoihoi]