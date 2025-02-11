package thelm.jaopca.modules.active;

import net.minecraft.init.Items;
import thelm.jaopca.api.oredict.IOredictModule;
import thelm.jaopca.api.oredict.JAOPCAOredictModule;
import thelm.jaopca.utils.ApiImpl;

@JAOPCAOredictModule
public class MinecraftOredictModule implements IOredictModule {

	@Override
	public String getName() {
		return "minecraft";
	}

	@Override
	public void register() {
		ApiImpl.INSTANCE.registerOredict("crystalCoal", Items.COAL);
	}
}
