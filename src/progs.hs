import Sprockell
test:: [Instruction]
test=[WriteInstr reg0 (DirAddr 0), Load (ImmValue 0) regE, Store regE (DirAddr 1), Load (ImmValue 2) regE, Load (ImmValue 15) regD, Load (ImmValue 3) regF, Compute LtE regE regD regA, Compute Equal reg0 regA regA, Branch regA (Rel 8), Store regE (DirAddr 2), Load (DirAddr 1) regC, Load (ImmValue 1) regB, Compute Add regC regB regC, Store regC (DirAddr 1), Compute Add regE regF regE, Jump (Abs 6), Load (DirAddr 1) regE, WriteInstr regE numberIO, EndProg]
main = run [test, test, test, test, test]