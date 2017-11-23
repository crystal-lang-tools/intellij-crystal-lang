package net.kenro.ji.jin.crystal.psi;

public interface CrystalElements {
    CrystalElementType Identifier = new CrystalElementType("identifier");
    CrystalElementType ProperName = new CrystalElementType("ProperName");

    CrystalElementType Program = new CrystalElementType("Program");
    CrystalElementType Module = new CrystalElementType("Module");

    CrystalElementType StringLiteral = new CrystalElementType("StringLiteral");

    CrystalElementType programModule = new CrystalElementType("ProgramModule");

}
