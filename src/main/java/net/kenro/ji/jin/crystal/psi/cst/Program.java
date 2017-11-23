package net.kenro.ji.jin.crystal.psi.cst;

import net.kenro.ji.jin.crystal.psi.CrystalElements;
import org.jetbrains.annotations.NotNull;

public class Program extends CrystalElement {
    protected Program() {
        super(CrystalElements.Program);
    }

    @NotNull
    public Module[] getModules() {
        return this.findChildren(Module.class);
    }
}
