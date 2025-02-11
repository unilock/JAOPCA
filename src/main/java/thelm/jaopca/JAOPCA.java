package thelm.jaopca;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import thelm.jaopca.events.CommonEventHandler;

@Mod(
		modid = JAOPCA.MOD_ID,
		name = JAOPCA.NAME,
		version = JAOPCA.VERSION,
		dependencies = JAOPCA.DEPENDENCIES
		)
public class JAOPCA {

	public static final String MOD_ID = "jaopca";
	public static final String NAME = "JAOPCA";
	public static final String VERSION = "1.12.2-0@VERSION@";
	public static final String DEPENDENCIES = "required-before:wrapup";
	@SidedProxy(
			clientSide = "thelm.jaopca.client.events.ClientEventHandler",
			serverSide = "thelm.jaopca.events.CommonEventHandler",
			modId = JAOPCA.MOD_ID)
	public static CommonEventHandler eventHandler;

	static {
		FluidRegistry.enableUniversalBucket();
	}

	@EventHandler
	public void onPreInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(eventHandler);
		eventHandler.onPreInit(event);
	}

	@EventHandler
	public void onInit(FMLInitializationEvent event) {
		eventHandler.onInit(event);
	}
}
